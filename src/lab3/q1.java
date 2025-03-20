package lab3;

import javax.swing.*;

public class q1 {
    public static void main(String[] args) {
        int p = Integer.parseInt(JOptionPane.showInputDialog("Enter principle:"));
        int t = Integer.parseInt(JOptionPane.showInputDialog("Enter time:"));
        int r = Integer.parseInt(JOptionPane.showInputDialog("Enter rate:"));

        double si = (p*t*r)/100;
        JOptionPane.showMessageDialog(null, "The principle is " + si);
    }
}
