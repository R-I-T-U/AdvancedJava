package lab3;

import javax.swing.*;

public class q2_d {
    JFrame frame;
    JTable table;
    JScrollPane scrollPane;
    public q2_d() {
        frame = new JFrame("Table Demo");
        String [] col = {"Name", "Roll", "Score"};
        String [][] row = {{"Ritu", "36", "100"}, {"Situ", "12", "90"}};
        table = new JTable(row,col);
        scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setSize(300,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new q2_d();
    }
}
