import java.util.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class balance extends JFrame implements ActionListener{
    JButton back;
    String pinNumber;
    public balance(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setTitle("Balance");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg")
        );
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(200,0,900, 900);
        add(image);

        back=new JButton("Back");
        back.setBounds(340,525,150,20);
        back.addActionListener(this);
        image.add(back);

        conn c=new conn();
        int balance=0;
        try{
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinNumber+"'");
            while (rs.next()) {
                String amountStr = rs.getString("amount"); // Get amount from DB
                if (amountStr != null && !amountStr.isEmpty()) { // Check if it's valid
                    int amount = Integer.parseInt(amountStr); // Convert to int
                    if (rs.getString("type").equals("deposit")) {
                        balance += amount;
                    } else {
                        balance -= amount;
                    }
                } else {
                    balance+=0;
                }
            }
        }            
            catch(Exception e){
                e.printStackTrace();
            }
        JLabel amount=new JLabel("Your current account balance is "+balance);
        amount.setForeground(Color.WHITE);
        amount.setBounds(200,300,500,14);
        image.add(amount);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
            return;
        }
    }
    public static void main(String[] args) {
        new balance("");
    }
}