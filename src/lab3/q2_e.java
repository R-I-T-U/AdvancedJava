package lab3;

import javax.swing.*;
import java.awt.*;

public class q2_e {
    JFrame frame;
    JLabel label;
    JList list;
    public q2_e(){
        frame = new JFrame("JList Example");
        label = new JLabel("Semester");
        String [] data = {"First", "Second", "Third", "Fourth"};
        list = new JList(data);
        list.setVisibleRowCount(3);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        frame.add(label);
        frame.add(list);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setSize(300, 200);
        frame.add(new JScrollPane(list));
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new q2_e();
    }
}
