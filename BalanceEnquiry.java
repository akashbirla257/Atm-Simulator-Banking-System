package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lab = new JLabel(i3);
        lab.setBounds(0, 0, 960, 1080);
        add(lab);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(190, 350, 400, 35);
        lab.add(l1);

        b1 = new JButton("BACK");
        b1.setBounds(390, 633, 150, 35);

        int balance = 0;
        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin= '" + pin + "'");
            while (rs.next()) {
                if (rs.getString("pay_mode").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception ex) {

        }
        l1.setText("Your Current Account Balance is Rs " + balance);

        b1.addActionListener(this);

        setSize(960, 1080);
        setUndecorated(true);
        setLocation(200, -270);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String args[]) {
        new BalanceEnquiry("").setVisible(true);
    }
}
