import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class withdraw extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw,back;
    String pinNumber;
    withdraw(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setTitle("Withdraw");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg")
        );
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(200,0,900, 900);
        add(image);

        JLabel text=new JLabel("Enter the amount you want to withdraw :");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        text.setBounds(170,300 ,350,20);
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,18));
        amount.setBounds(170,340,300,25);
        image.add(amount);

        withdraw=new JButton("WithDraw");
        withdraw.setBounds(340,490,150,20);
        withdraw.addActionListener(this);
        image.add(withdraw);

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
        if(ae.getSource()==withdraw){
            String number=amount.getText();
            if(number==null || number.equals("") || Integer.parseInt(number)<=0){
                JOptionPane.showMessageDialog(null,"Please enter valid amount");
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            String formattedDate = sdf.format(new Date());
            conn c=new conn();
            try
            {
            // String query="Insert into bank values('"+pinNumber+"','"+formattedDate+"','withdraw','"+number+"')";
            // c.s.executeUpdate(query);
            // JOptionPane.showMessageDialog(null,"Rs "+number+" is withdrawed successfully");
            // setVisible(false);
            // new Transactions(pinNumber).setVisible(true);

            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinNumber+"'");
            int balance=0;
            while(rs.next()){
                if(rs.getString("type").equals("deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
            if(ae.getSource()!=back && balance<Integer.parseInt(number)){
                JOptionPane.showMessageDialog(null, "Insufficient balance!!!\nTry again");
                return;
            }
            c.s.executeUpdate("Insert into bank values('"+pinNumber+"','"+formattedDate+"','FastCash','"+number+"')");
            JOptionPane.showMessageDialog(null,"Rs "+number+" debited successfully");
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
        new withdraw("");
    }
}
