import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener{
    JButton deposit,withdraw,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinNumber;
    Transactions(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        setSize(900,900);
        setTitle("Transactions");
        setLocation(300,0);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg")
        );
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(200,0,900,900);
        add(image);

        JLabel text=new JLabel("Please Select Your Transaction");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(200,300,300,14);
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(180,420,150,20);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw=new JButton("WithDraw");
        withdraw.setBounds(340,420,150,20);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(180,455,150,20);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(340,455,150,20);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("PIN change");
        pinchange.setBounds(180,490,150,20);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(340,490,150,20);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit=new JButton("Exit");
        exit.setBounds(340,525,150,20);
        exit.addActionListener(this);
        image.add(exit);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
        if(ae.getSource()==deposit){
            setVisible(false);
            new deposit(pinNumber).setVisible(true);
        }
        if(ae.getSource()==withdraw){
            setVisible(false);
            new withdraw(pinNumber).setVisible(true);
        }
        if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        if(ae.getSource()==pinchange){
            setVisible(false);
            new pinChange(pinNumber).setVisible(true);
        }
        if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new balance(pinNumber).setVisible(true);
        }
        if(ae.getSource()==ministatement){
            setVisible(false);
            new miniStatement(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}
