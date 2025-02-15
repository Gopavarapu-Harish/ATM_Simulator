import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit,back;
    String pinNumber;
    deposit(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        setSize(900,900);
        setTitle("Deposit");
        setLocation(300,0);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg")
        );
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(200,0,900, 900);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to deposit :");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        text.setBounds(170,300 ,350,20);
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,18));
        amount.setBounds(170,340,300,25);
        image.add(amount);

        deposit=new JButton("Deposit");
        deposit.setBounds(340,490,150,20);
        deposit.addActionListener(this);
        image.add(deposit);

        back=new JButton("Back");
        back.setBounds(340,525,150,20);
        back.addActionListener(this);
        image.add(back);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        if(ae.getSource()==deposit){
            String number=amount.getText();
            if(number==null || number.equals("") || Integer.parseInt(number)<=0){
                JOptionPane.showMessageDialog(null,"Please enter valid amount");
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            String formattedDate = sdf.format(new Date());
            try
            {
            conn c=new conn();
            String query="Insert into bank values('"+pinNumber+"','"+formattedDate+"','deposit','"+number+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Rs "+number+" is successfully deposited");
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
            }
            catch (SQLException e) {
                System.out.println("SQL Error: " + e.getMessage());  // Print error message
                e.printStackTrace();  // Show full error details
            }            

        }
    }
    public static void main(String[] args) {
        new deposit("");
    }
}
