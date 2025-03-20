import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CropPriceForecast {
    public static void main(String[] args) {
        // Sample historical price data for demonstration
        // In a real system, this would come from a database or file
        List<PriceData> tomatoPriceHistory = new ArrayList<>();
        tomatoPriceHistory.add(new PriceData(LocalDate.of(2023, 1, 1), 2.50));
        tomatoPriceHistory.add(new PriceData(LocalDate.of(2023, 2, 1), 2.75));
        tomatoPriceHistory.add(new PriceData(LocalDate.of(2023, 3, 1), 2.40));
        tomatoPriceHistory.add(new PriceData(LocalDate.of(2023, 4, 1), 2.30));
        tomatoPriceHistory.add(new PriceData(LocalDate.of(2023, 5, 1), 2.10));
        tomatoPriceHistory.add(new PriceData(LocalDate.of(2023, 6, 1), 1.90));
        tomatoPriceHistory.add(new PriceData(LocalDate.of(2023, 7, 1), 1.70));
        tomatoPriceHistory.add(new PriceData(LocalDate.of(2023, 8, 1), 1.60));
        tomatoPriceHistory.add(new PriceData(LocalDate.of(2023, 9, 1), 1.80));
        tomatoPriceHistory.add(new PriceData(LocalDate.of(2023, 10, 1), 2.00));
        tomatoPriceHistory.add(new PriceData(LocalDate.of(2023, 11, 1), 2.20));
        tomatoPriceHistory.add(new PriceData(LocalDate.of(2023, 12, 1), 2.40));
        tomatoPriceHistory.add(new PriceData(LocalDate.of(2024, 1, 1), 2.60));
        tomatoPriceHistory.add(new PriceData(LocalDate.of(2024, 2, 1), 2.80));
        tomatoPriceHistory.add(new PriceData(LocalDate.of(2024, 3, 1), 2.50));

        // Create forecaster and generate predictions
        PriceForecastEngine forecaster = new PriceForecastEngine();
        List<PriceData> forecast = forecaster.generateForecast(tomatoPriceHistory, 6);

        // Print historical data
        System.out.println("=== HISTORICAL PRICE DATA FOR TOMATOES ===");
        for (PriceData data : tomatoPriceHistory) {
            System.out.println(data);
        }

        // Print forecast
        System.out.println("\n=== PRICE FORECAST FOR NEXT 6 MONTHS ===");
        for (PriceData data : forecast) {
            System.out.println(data);
        }

        // Generate marketing recommendations
        System.out.println("\n=== MARKETING RECOMMENDATIONS ===");
        MarketingRecommender recommender = new MarketingRecommender();
        recommender.generateRecommendations(tomatoPriceHistory, forecast);
    }
}

class PriceData {
    private LocalDate date;
    private double price;

    public PriceData(LocalDate date, double price) {
        this.date = date;
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public int getMonth() {
        return date.getMonthValue();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM yyyy");
        return date.format(formatter) + ": $" + String.format("%.2f", price) + " per kg";
    }
}

class PriceForecastEngine {
    private static final int MOVING_AVG_WINDOW = 3;
    private static final double SEASONAL_WEIGHT = 0.4;
    private static final double TREND_WEIGHT = 0.3;
    private static final double RECENT_WEIGHT = 0.3;

    /**
     * Generates price forecasts for the specified number of months
     * @param historicalData Historical price data
     * @param months Number of months to forecast
     * @return List of forecasted prices
     */
    public List<PriceData> generateForecast(List<PriceData> historicalData, int months) {
        if (historicalData == null || historicalData.isEmpty()) {
            throw new IllegalArgumentException("Historical data cannot be empty");
        }

        List<PriceData> forecast = new ArrayList<>();

        // Calculate seasonal factors
        Map<Integer, Double> seasonalFactors = calculateSeasonalFactors(historicalData);

        // Calculate trend
        double trend = calculateTrend(historicalData);

        // Get the most recent price
        PriceData lastDataPoint = historicalData.get(historicalData.size() - 1);
        double lastPrice = lastDataPoint.getPrice();

        // Generate forecast for each month
        LocalDate forecastDate = lastDataPoint.getDate().plus(1, ChronoUnit.MONTHS);

        for (int i = 0; i < months; i++) {
            // Get moving average component
            double movingAvg = calculateMovingAverage(historicalData);

            // Get seasonal component
            int month = forecastDate.getMonthValue();
            double seasonalFactor = seasonalFactors.getOrDefault(month, 1.0);

            // Calculate forecasted price using weighted components
            double forecastedPrice = (movingAvg * RECENT_WEIGHT) +
                    (lastPrice * (1 + trend) * TREND_WEIGHT) +
                    (lastPrice * seasonalFactor * SEASONAL_WEIGHT);

            // Create new price data point and add to forecast
            PriceData forecastPoint = new PriceData(forecastDate, forecastedPrice);
            forecast.add(forecastPoint);

            // Update for next iteration
            forecastDate = forecastDate.plus(1, ChronoUnit.MONTHS);
            lastPrice = forecastedPrice;

            // Add the forecast point to historical data for next calculation
            List<PriceData> extendedData = new ArrayList<>(historicalData);
            extendedData.add(forecastPoint);
            historicalData = extendedData;
        }

        return forecast;
    }

    /**
     * Calculates seasonal factors for each month based on historical data
     */
    private Map<Integer, Double> calculateSeasonalFactors(List<PriceData> historicalData) {
        Map<Integer, List<Double>> monthlyPrices = new HashMap<>();

        // Group prices by month
        for (PriceData data : historicalData) {
            int month = data.getMonth();
            if (!monthlyPrices.containsKey(month)) {
                monthlyPrices.put(month, new ArrayList<>());
            }
            monthlyPrices.get(month).add(data.getPrice());
        }

        // Calculate average price across all data
        double overallAverage = historicalData.stream()
                .mapToDouble(PriceData::getPrice)
                .average()
                .orElse(0.0);

        // Calculate seasonal factors
        Map<Integer, Double> seasonalFactors = new HashMap<>();
        for (Map.Entry<Integer, List<Double>> entry : monthlyPrices.entrySet()) {
            int month = entry.getKey();
            List<Double> prices = entry.getValue();

            // Calculate average price for this month
            double monthlyAverage = prices.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);

            // Seasonal factor is the ratio of monthly average to overall average
            double seasonalFactor = monthlyAverage / overallAverage;
            seasonalFactors.put(month, seasonalFactor);
        }

        return seasonalFactors;
    }

    /**
     * Calculates the overall trend in the data
     */
    private double calculateTrend(List<PriceData> historicalData) {
        if (historicalData.size() < 2) {
            return 0.0;
        }

        // Simple linear trend calculation
        double firstPrice = historicalData.get(0).getPrice();
        double lastPrice = historicalData.get(historicalData.size() - 1).getPrice();
        int periods = historicalData.size() - 1;

        // Average change per period
        return (lastPrice - firstPrice) / (firstPrice * periods);
    }

    /**
     * Calculates moving average of the most recent data points
     */
    private double calculateMovingAverage(List<PriceData> historicalData) {
        int startIndex = Math.max(0, historicalData.size() - MOVING_AVG_WINDOW);

        double sum = 0.0;
        for (int i = startIndex; i < historicalData.size(); i++) {
            sum += historicalData.get(i).getPrice();
        }

        return sum / (historicalData.size() - startIndex);
    }
}

class MarketingRecommender {
    /**
     * Generates marketing recommendations based on historical and forecasted prices
     */
    public void generateRecommendations(List<PriceData> historicalData, List<PriceData> forecastData) {
        if (historicalData.isEmpty() || forecastData.isEmpty()) {
            System.out.println("Insufficient data for recommendations");
            return;
        }

        // Find highest and lowest price months in forecast
        PriceData highestPricePoint = forecastData.get(0);
        PriceData lowestPricePoint = forecastData.get(0);

        for (PriceData data : forecastData) {
            if (data.getPrice() > highestPricePoint.getPrice()) {
                highestPricePoint = data;
            }
            if (data.getPrice() < lowestPricePoint.getPrice()) {
                lowestPricePoint = data;
            }
        }

        // Calculate average price
        double avgForecastPrice = forecastData.stream()
                .mapToDouble(PriceData::getPrice)
                .average()
                .orElse(0.0);

        // Calculate price volatility
        double priceVolatility = calculateVolatility(forecastData);

        // Generate recommendations
        System.out.println("1. PRICE OUTLOOK:");
        System.out.println("   - Average forecasted price: $" + String.format("%.2f", avgForecastPrice) + " per kg");
        System.out.println("   - Price volatility: " + String.format("%.2f", priceVolatility * 100) + "%");

        System.out.println("\n2. OPTIMAL SELLING PERIODS:");
        System.out.println("   - Highest price expected: " + highestPricePoint);
        System.out.println("   - Lowest price expected: " + lowestPricePoint);

        System.out.println("\n3. MARKETING STRATEGY RECOMMENDATIONS:");

        // Determine if prices are trending up or down
        double firstPrice = forecastData.get(0).getPrice();
        double lastPrice = forecastData.get(forecastData.size() - 1).getPrice();
        boolean pricesTrendingUp = lastPrice > firstPrice;

        if (pricesTrendingUp) {
            System.out.println("   - Prices are trending upward. Consider:");
            System.out.println("     * Holding inventory for later sales if storage is feasible");
            System.out.println("     * Securing forward contracts at current prices");
            System.out.println("     * Focusing on quality to maximize returns during peak price periods");
        } else {
            System.out.println("   - Prices are trending downward. Consider:");
            System.out.println("     * Selling inventory sooner rather than later");
            System.out.println("     * Exploring value-added products to increase margins");
            System.out.println("     * Diversifying crop portfolio to mitigate risk");
        }

        if (priceVolatility > 0.15) {
            System.out.println("\n4. RISK MANAGEMENT:");
            System.out.println("   - High price volatility detected. Consider:");
            System.out.println("     * Staggered selling approach to average out price fluctuations");
            System.out.println("     * Exploring direct-to-consumer channels for more stable pricing");
            System.out.println("     * Investigating crop insurance options");
        }
    }

    /**
     * Calculates price volatility as coefficient of variation
     */
    private double calculateVolatility(List<PriceData> priceData) {
        double mean = priceData.stream()
                .mapToDouble(PriceData::getPrice)
                .average()
                .orElse(0.0);

        double sumSquaredDiff = priceData.stream()
                .mapToDouble(data -> Math.pow(data.getPrice() - mean, 2))
                .sum();

        double standardDeviation = Math.sqrt(sumSquaredDiff / priceData.size());

        return standardDeviation / mean; // Coefficient of variation
    }
}

