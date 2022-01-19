package com.blueorange.fx;

import javax.swing.*;
import java.awt.*;

public class FXRealTimeDataUI {

    private JTextField field1;
    private JTextField field2;
    private JTextField time1;
    private JTextField time2;

    public FXRealTimeDataUI() {
        setUI();
    }

    public JTextField getField1() {
        return field1;
    }

    public JTextField getField2() {
        return field2;
    }

    public JTextField getTime1() {
        return time1;
    }

    public JTextField getTime2() {
        return time2;
    }

    private void setUI() {
        JFrame frame = new JFrame("TEST");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(2, 3, 1, 1));
        JLabel label1 = new JLabel("EUR/USD:");
        JLabel label2 = new JLabel("EUR/GBP");
        field1 = new JTextField("-");
        field1.setEnabled(false);
        field2 = new JTextField("-");
        field2.setEnabled(false);
        time1 = new JTextField("-");
        time1.setEnabled(false);
        time2 = new JTextField("-");
        time2.setEnabled(false);
        panel.add(label1);
        panel.add(field1);
        panel.add(time1);
        panel.add(label2);
        panel.add(field2);
        panel.add(time2);
        frame.getContentPane().add(panel);
        frame.setSize(500, 125);
        frame.setVisible(true);
    }

}