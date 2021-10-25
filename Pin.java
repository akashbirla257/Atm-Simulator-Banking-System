package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener {

    JPasswordField t2, t3;
    JButton b1, b2;
    JLabel l1, l2, l3;
    String pin;

    Pin(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lab = new JLabel(i3);
        lab.setBounds(0, 0, 960, 1080);
        add(lab);
        setLayout(null);

        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        l1.setBounds(280, 330, 800, 35);
        lab.add(l1);

        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        l2.setBounds(180, 390, 150, 35);
        lab.add(l2);

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        t2.setBounds(350, 390, 180, 25);
        lab.add(t2);

        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);
        l3.setBounds(180, 440, 200, 35);
        lab.add(l3);

        t3 = new JPasswordField();
        t3.setFont(new Font("Raleway", Font.BOLD, 25));
        t3.setBounds(350, 440, 180, 25);
        lab.add(t3);

        b1 = new JButton("CHANGE");
        b1.setBounds(390, 588, 150, 35);
        lab.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(390, 633, 150, 35);
        lab.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        setSize(960, 1080);
        setLocation(200, -270);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try {
            String npin = t2.getText();
            String rpin = t3.getText();
            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if (ae.getSource() == b1) {
                if (t2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (t3.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
                 
                Conn c1 = new Conn();
                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
                String q3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pin+"' ";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);
                
                  JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
              new Transactions(rpin).setVisible(true);
            }
            else if(ae.getSource()==b2){
               new Transactions(pin).setVisible(true);
                setVisible(false);
            }
        } catch (Exception ex) {

        }

    }

    public static void main(String args[]) {
        new Pin("").setVisible(true);
    }

}