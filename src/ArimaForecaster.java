import java.util.Arrays;

/**
 * ARIMA (AutoRegressive Integrated Moving Average) implementation for
 * agricultural price forecasting.
 */
public class ArimaForecaster {

    public static void main(String[] args) {
        System.out.println("ARIMA Model for Agricultural Price Forecasting");
        System.out.println("---------------------------------------------");

        // Sample historical price data for tomatoes (weekly prices in USD per kg)
        double[] tomatoPrices = {
                1.25, 1.30, 1.28, 1.32, 1.40, 1.50, 1.45, 1.42, 1.38, 1.36,
                1.40, 1.45, 1.50, 1.55, 1.60, 1.58, 1.52, 1.48, 1.45, 1.50,
                1.55, 1.60, 1.65, 1.70, 1.68, 1.65, 1.60, 1.58, 1.62, 1.65,
                1.70, 1.75, 1.78, 1.80, 1.82, 1.80, 1.78, 1.75, 1.72, 1.70,
                1.68, 1.65, 1.62, 1.60, 1.58, 1.55, 1.52, 1.50, 1.48, 1.45
        };

        // Sample historical price data for potatoes (weekly prices in USD per kg)
        double[] potatoPrices = {
                0.75, 0.78, 0.80, 0.82, 0.85, 0.88, 0.90, 0.92, 0.95, 0.98,
                1.00, 1.02, 1.05, 1.08, 1.10, 1.12, 1.15, 1.18, 1.20, 1.18,
                1.15, 1.12, 1.10, 1.08, 1.05, 1.02, 1.00, 0.98, 0.95, 0.92,
                0.90, 0.88, 0.85, 0.82, 0.80, 0.78, 0.75, 0.72, 0.70, 0.68,
                0.65, 0.62, 0.60, 0.58, 0.55, 0.52, 0.50, 0.48, 0.45, 0.42
        };

        // Forecast tomato prices
        forecastCropPrices("Tomato", tomatoPrices, 12);

        System.out.println("\n");

        // Forecast potato prices
        forecastCropPrices("Potato", potatoPrices, 12);
    }

    /**
     * Forecast prices for a specific crop
     * @param cropName Name of the crop
     * @param historicalPrices Historical price data
     * @param forecastHorizon Number of periods to forecast
     */
    public static void forecastCropPrices(String cropName, double[] historicalPrices, int forecastHorizon) {
        System.out.println("Analyzing " + cropName + " prices:");
        System.out.println("--------------------------------");

        // Check stationarity
        boolean isStationary = isStationary(historicalPrices);
        System.out.println("Is the original series stationary? " + isStationary);

        // Find optimal parameters
        int[] optimalParams = findOptimalParameters(historicalPrices, 3, 2, 3);
        int p = optimalParams[0];
        int d = optimalParams[1];
        int q = optimalParams[2];

        System.out.println("Optimal ARIMA parameters: (" + p + "," + d + "," + q + ")");

        // Create and fit ARIMA model
        ArimaModel model = new ArimaModel(p, d, q);
        model.fit(historicalPrices);

        // Generate forecasts
        double[] forecasts = model.forecast(historicalPrices, forecastHorizon);

        // Display results
        System.out.println("\nForecasted " + cropName + " prices for the next " + forecastHorizon + " weeks (USD per kg):");
        for (int i = 0; i < forecasts.length; i++) {
            System.out.printf("Week %d: $%.2f\n", i + 1, forecasts[i]);
        }
    }

    /**
     * Check if a time series is stationary
     * @param data Time series data
     * @return true if stationary, false otherwise
     */
    public static boolean isStationary(double[] data) {
        // Simplified stationarity test
        // In a real implementation, this would use the Augmented Dickey-Fuller test

        // Calculate mean and variance for first half and second half
        int mid = data.length / 2;

        double mean1 = mean(Arrays.copyOfRange(data, 0, mid));
        double mean2 = mean(Arrays.copyOfRange(data, mid, data.length));

        double var1 = variance(Arrays.copyOfRange(data, 0, mid));
        double var2 = variance(Arrays.copyOfRange(data, mid, data.length));

        // Check if means and variances are approximately equal
        double meanDiff = Math.abs(mean1 - mean2) / Math.max(Math.abs(mean1), Math.abs(mean2));
        double varDiff = Math.abs(var1 - var2) / Math.max(var1, var2);

        return meanDiff < 0.1 && varDiff < 0.2; // Arbitrary thresholds
    }

    /**
     * Find optimal ARIMA parameters using AIC
     * @param data Time series data
     * @param maxP Maximum AR order to consider
     * @param maxD Maximum differencing order to consider
     * @param maxQ Maximum MA order to consider
     * @return Optimal parameters as int array [p, d, q]
     */
    public static int[] findOptimalParameters(double[] data, int maxP, int maxD, int maxQ) {
        double bestAic = Double.POSITIVE_INFINITY;
        int[] bestParams = new int[3];

        for (int d = 0; d <= maxD; d++) {
            // Apply differencing
            double[] diffedData = data;
            for (int i = 0; i < d; i++) {
                diffedData = difference(diffedData);
            }

            for (int p = 0; p <= maxP; p++) {
                for (int q = 0; q <= maxQ; q++) {
                    if (p == 0 && q == 0) continue; // Skip ARIMA(0,d,0)

                    try {
                        ArimaModel model = new ArimaModel(p, d, q);
                        model.fit(data);

                        // Calculate AIC
                        double aic = calculateAIC(model, diffedData);

                        if (aic < bestAic) {
                            bestAic = aic;
                            bestParams[0] = p;
                            bestParams[1] = d;
                            bestParams[2] = q;
                        }
                    } catch (Exception e) {
                        // Skip invalid models
                    }
                }
            }
        }

        return bestParams;
    }

    /**
     * Calculate AIC (Akaike Information Criterion)
     * @param model Fitted ARIMA model
     * @param data Differenced data
     * @return AIC value
     */
    private static double calculateAIC(ArimaModel model, double[] data) {
        int n = data.length;
        int k = model.getP() + model.getQ() + 1; // +1 for intercept

        // Calculate sum of squared residuals
        double ssr = 0.0;
        for (double residual : model.getResiduals()) {
            ssr += residual * residual;
        }

        // Calculate variance
        double variance = ssr / (n - k);

        // Calculate log-likelihood
        double logLikelihood = -n/2.0 * (Math.log(2 * Math.PI) + Math.log(variance)) - ssr / (2 * variance);

        // AIC formula: 2k - 2ln(L)
        return 2 * k - 2 * logLikelihood;
    }

    /**
     * Apply first-order differencing to make time series stationary
     * @param data Input time series
     * @return Differenced time series
     */
    public static double[] difference(double[] data) {
        double[] result = new double[data.length - 1];
        for (int i = 1; i < data.length; i++) {
            result[i - 1] = data[i] - data[i - 1];
        }
        return result;
    }

    /**
     * Calculate mean of a data array
     * @param data Input data
     * @return Mean value
     */
    public static double mean(double[] data) {
        double sum = 0.0;
        for (double value : data) {
            sum += value;
        }
        return sum / data.length;
    }

    /**
     * Calculate variance of a data array
     * @param data Input data
     * @return Variance value
     */
    public static double variance(double[] data) {
        double m = mean(data);
        double sum = 0.0;

        for (double value : data) {
            sum += Math.pow(value - m, 2);
        }

        return sum / data.length;
    }
}

/**
 * ARIMA model implementation
 */
class ArimaModel {
    private final int p; // AR order
    private final int d; // Differencing order
    private final int q; // MA order

    private double[] arCoefficients; // AR coefficients
    private double[] maCoefficients; // MA coefficients
    private double intercept;
    private double[] residuals;

    /**
     * Constructor for ARIMA model
     * @param p AR order
     * @param d Differencing order
     * @param q MA order
     */
    public ArimaModel(int p, int d, int q) {
        this.p = p;
        this.d = d;
        this.q = q;
        this.arCoefficients = new double[p];
        this.maCoefficients = new double[q];
        this.intercept = 0.0;
    }

    /**
     * Fit the ARIMA model to the provided time series data
     * @param data The time series data
     */
    public void fit(double[] data) {
        // Step 1: Apply differencing if needed
        double[] diffedData = data;
        for (int i = 0; i < d; i++) {
            diffedData = ArimaForecaster.difference(diffedData);
        }

        // Step 2: Estimate AR coefficients using Yule-Walker equations
        if (p > 0) {
            double[] acf = computeAutocorrelation(diffedData, p);
            arCoefficients = solveYuleWalker(acf);
        }

        // Step 3: Compute residuals
        residuals = new double[diffedData.length];
        for (int t = p; t < diffedData.length; t++) {
            double prediction = intercept;
            for (int i = 0; i < p; i++) {
                if (t - i - 1 >= 0) {
                    prediction += arCoefficients[i] * diffedData[t - i - 1];
                }
            }
            residuals[t] = diffedData[t] - prediction;
        }

        // Step 4: Estimate MA coefficients
        if (q > 0) {
            estimateMACoefficients();
        }

        // Step 5: Compute intercept (mean of the differenced series)
        intercept = ArimaForecaster.mean(diffedData);
    }

    /**
     * Forecast future values based on the fitted model
     * @param data Original time series data
     * @param forecastHorizon Number of periods to forecast
     * @return Array of forecasted values
     */
    public double[] forecast(double[] data, int forecastHorizon) {
        // Step 1: Apply differencing if needed
        double[] diffedData = data;
        for (int i = 0; i < d; i++) {
            diffedData = ArimaForecaster.difference(diffedData);
        }

        // Step 2: Generate forecasts for differenced series
        double[] diffedForecasts = new double[forecastHorizon];

        // Create extended array for historical data + forecasts
        double[] extendedSeries = Arrays.copyOf(diffedData, diffedData.length + forecastHorizon);
        double[] extendedResiduals = Arrays.copyOf(residuals, residuals.length + forecastHorizon);

        // Generate forecasts
        for (int h = 0; h < forecastHorizon; h++) {
            int t = diffedData.length + h;
            double forecast = intercept;

            // Add AR component
            for (int i = 0; i < p; i++) {
                if (t - i - 1 >= 0) {
                    forecast += arCoefficients[i] * extendedSeries[t - i - 1];
                }
            }

            // Add MA component
            for (int i = 0; i < q; i++) {
                if (t - i - 1 >= 0 && t - i - 1 < extendedResiduals.length) {
                    forecast += maCoefficients[i] * extendedResiduals[t - i - 1];
                }
            }

            extendedSeries[t] = forecast;
            diffedForecasts[h] = forecast;
        }

        // Step 3: Invert differencing to get forecasts in original scale
        double[] forecasts = diffedForecasts;
        for (int i = 0; i < d; i++) {
            forecasts = undifference(forecasts, data);
        }

        return forecasts;
    }

    /**
     * Invert differencing to restore original scale
     * @param diffedData Differenced data
     * @param originalData Original data before differencing
     * @return Undifferenced data
     */
    private double[] undifference(double[] diffedData, double[] originalData) {
        double[] result = new double[diffedData.length];
        double lastOriginal = originalData[originalData.length - 1];

        for (int i = 0; i < diffedData.length; i++) {
            result[i] = lastOriginal + diffedData[i];
            lastOriginal = result[i];
        }

        return result;
    }

    /**
     * Compute autocorrelation function up to specified lag
     * @param data Time series data
     * @param maxLag Maximum lag to compute
     * @return Array of autocorrelation values
     */
    private double[] computeAutocorrelation(double[] data, int maxLag) {
        double mean = ArimaForecaster.mean(data);
        double[] acf = new double[maxLag + 1];

        double denominator = 0.0;
        for (double value : data) {
            denominator += Math.pow(value - mean, 2);
        }

        for (int lag = 0; lag <= maxLag; lag++) {
            double numerator = 0.0;
            for (int t = lag; t < data.length; t++) {
                numerator += (data[t] - mean) * (data[t - lag] - mean);
            }
            acf[lag] = numerator / denominator;
        }

        return acf;
    }

    /**
     * Solve Yule-Walker equations to estimate AR coefficients
     * @param acf Autocorrelation function values
     * @return AR coefficients
     */
    private double[] solveYuleWalker(double[] acf) {
        // For AR(p), we need to solve the Yule-Walker equations
        // This is a simplified implementation using direct matrix inversion
        double[][] matrix = new double[p][p];
        double[] vector = new double[p];

        for (int i = 0; i < p; i++) {
            vector[i] = acf[i + 1];
            for (int j = 0; j < p; j++) {
                matrix[i][j] = acf[Math.abs(i - j)];
            }
        }

        // Solve the system using a simple Gaussian elimination
        return solveLinearSystem(matrix, vector);
    }

    /**
     * Solve a linear system using Gaussian elimination
     * @param A Coefficient matrix
     * @param b Right-hand side vector
     * @return Solution vector
     */
    private double[] solveLinearSystem(double[][] A, double[] b) {
        int n = b.length;

        if (n == 0) return new double[0];

        double[][] augmentedMatrix = new double[n][n + 1];

        // Create augmented matrix
        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, augmentedMatrix[i], 0, n);
            augmentedMatrix[i][n] = b[i];
        }

        // Gaussian elimination
        for (int i = 0; i < n; i++) {
            // Find pivot
            int maxRow = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(augmentedMatrix[j][i]) > Math.abs(augmentedMatrix[maxRow][i])) {
                    maxRow = j;
                }
            }

            // Swap rows
            double[] temp = augmentedMatrix[i];
            augmentedMatrix[i] = augmentedMatrix[maxRow];
            augmentedMatrix[maxRow] = temp;

            // Eliminate
            for (int j = i + 1; j < n; j++) {
                double factor = augmentedMatrix[j][i] / augmentedMatrix[i][i];
                for (int k = i; k <= n; k++) {
                    augmentedMatrix[j][k] -= factor * augmentedMatrix[i][k];
                }
            }
        }

        // Back substitution
        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            solution[i] = augmentedMatrix[i][n];
            for (int j = i + 1; j < n; j++) {
                solution[i] -= augmentedMatrix[i][j] * solution[j];
            }
            solution[i] /= augmentedMatrix[i][i];
        }

        return solution;
    }

    /**
     * Estimate MA coefficients using method of moments
     * This is a simplified implementation
     */
    private void estimateMACoefficients() {
        // For simplicity, we'll use a heuristic approach
        // In a real implementation, this would use maximum likelihood estimation
        double[] acfResiduals = computeAutocorrelation(residuals, q);

        for (int i = 0; i < q; i++) {
            maCoefficients[i] = acfResiduals[i + 1] / acfResiduals[0];
        }
    }

    // Getters
    public int getP() { return p; }
    public int getD() { return d; }
    public int getQ() { return q; }
    public double[] getResiduals() { return residuals; }
}