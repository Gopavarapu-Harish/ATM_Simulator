import java.util.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class pinChange extends JFrame implements ActionListener{
    String pinNumber;
    JButton change,back;
    JPasswordField pinText,ReText;
    public pinChange(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setTitle("Pin change");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg")
        );
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(200,0,900, 900);
        add(image);

        JLabel text=new JLabel("Change Your PIN :");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,300 ,350,20);
        image.add(text);

        JLabel newPin=new JLabel("Enter new PIN :");
        newPin.setForeground(Color.WHITE);
        newPin.setFont(new Font("System",Font.BOLD,14));
        newPin.setBounds(170,350 ,300,20);
        image.add(newPin);

        pinText=new JPasswordField();
        pinText.setFont(new Font("Raleway",Font.BOLD,14));
        pinText.setBounds(310,350 ,200,20);
        image.add(pinText);

        JLabel RePin=new JLabel("Re-Enter PIN :");
        RePin.setForeground(Color.WHITE);
        RePin.setFont(new Font("System",Font.BOLD,14));
        RePin.setBounds(170,410 ,300,20);
        image.add(RePin);

        ReText=new JPasswordField();
        ReText.setFont(new Font("Raleway",Font.BOLD,14));
        ReText.setBounds(310,410 ,200,20);
        image.add(ReText);

        change=new JButton("Change");
        change.setBounds(340,490,150,20);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("Back");
        back.setBounds(340,525,150,20);
        back.addActionListener(this);
        image.add(back);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{
                String pin=pinText.getText();
                String repin=ReText.getText();
                if(!pin.equals(repin) || pin.equals("") ||repin.equals("")){
                    JOptionPane.showMessageDialog(null,"Entered pin isn't match with re-pin");
                    return;
                }
                conn c=new conn();
                String query1="update bank set pin='"+pin+"' where pin='"+pinNumber+"'";
                c.s.executeUpdate(query1);

                String query2="update login set pinNumber='"+pin+"' where pinNumber='"+pinNumber+"'";
                c.s.executeUpdate(query2);

                String query3="update signupthree set pinNumber='"+pin+"' where pinNumber='"+pinNumber+"'";
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new pinChange("");
    }
}