package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    Transactions(String pin) {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lab = new JLabel(i3);
        lab.setBounds(0, 0, 940, 1080);
        add(lab);

        l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(235,400,700,35);
        lab.add(l1);

        b1 = new JButton("DEPOSIT");
         b1.setBounds(170,499,150,35);
        lab.add(b1);
        b2 = new JButton("CASH WITHDRAWL");
        b2.setBounds(390,499,150,35);
        lab.add(b2);

        b3 = new JButton("FAST CASH");
          b3.setBounds(170,543,150,35);
        lab.add(b3);

        b4 = new JButton("MINI STATEMENT");
         b4.setBounds(390,543,150,35);
        lab.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setBounds(170,588,150,35);
        lab.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
           b6.setBounds(390,588,150,35);
        lab.add(b6);

        b7 = new JButton("EXIT");
       b7.setBounds(390,633,150,35);
        lab.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(940, 1080);
        setLocation(200, -270);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == b2) {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        } else if (ae.getSource() == b3) {
            setVisible(false);
           new FastCash(pin).setVisible(true);
        } else if (ae.getSource() == b4) {
           new MiniStatement(pin).setVisible(true);
        } else if (ae.getSource() == b5) {
            setVisible(false);
            new Pin(pin).setVisible(true);
        } else if (ae.getSource() == b6) {
            this.setVisible(false);
           new BalanceEnquiry(pin).setVisible(true);
        } else if (ae.getSource() == b7) {
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        new Transactions("").setVisible(true);
    }

}
