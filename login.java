/*
 * javac -cp ".:lib/*" *.java
 * java -cp ".:lib/*" login

 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class login extends JFrame implements ActionListener{
    JButton signIn,clear,signUp;
    JTextField cardTField;
    JPasswordField pinTField;
    login(){
        setLayout(null);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        setTitle("AUTOMATED TELLER MACHINE");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/logo.jpg")
        );
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100, 100);
        add(label); 
        JLabel text=new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        JLabel card=new JLabel("Card no:");
        card.setFont(new Font("Raleway",Font.BOLD,28));
        card.setBounds(120,150,150,40);//x,y,width,height x-horizontal padding ,y-vertical padding,width-space alloted for text horizontal and height space alloted for text vertically.
        add(card);
        cardTField=new JTextField();
        cardTField.setBounds(300,150,240,40);
        cardTField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTField);
        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,150,40);
        add(pin);
        pinTField=new JPasswordField();
        pinTField.setBounds(300,220,240,40);
        pinTField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTField);
        signIn=new JButton("SIGN IN");
        signIn.setBounds(300,300,100,20);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.addActionListener(this);
        add(signIn);
        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,20);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        signUp=new JButton("SIGN UP");
        signUp.setBounds(300,350,230,30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);
        getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent ae){
       
        if(ae.getSource()==signUp){
           setVisible(false);
           new signupOne().setVisible(true);
        }
        else if(ae.getSource()==signIn){
            conn c=new conn();
            String cardNumber=cardTField.getText();
            String pinNumber=pinTField.getText();
            String query="Select * from login where cardNumber='"+cardNumber+"' and pinNumber='"+pinNumber+"'";
            try{
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Credentials");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==clear){
            cardTField.setText("");
            pinTField.setText("");
        }
    }
    public static void main(String[] args) {
        new login();
    }

}