import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class signupThree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    String cnum,pnum;
    public signupThree(String formno){
        this.formno=formno;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel l1=new JLabel("Page 3: Account Details:");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        setSize(850,820);
        setVisible(true);
        setLocation(350,0);

        JLabel type=new JLabel("Account Type :");
        type.setFont(new Font("Raleway",Font.BOLD,18));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1=new JRadioButton("Savings Account");
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,180,190,20);
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,180,290,20);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setBackground(Color.WHITE);
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,210,190,20);
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setBackground(Color.WHITE);
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,210,290,20);
        add(r4);

        ButtonGroup accountGroup=new ButtonGroup();
        accountGroup.add(r1);
        accountGroup.add(r2);
        accountGroup.add(r3);
        accountGroup.add(r4);

        JLabel card=new JLabel("Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,18));
        card.setBounds(100,250,200,30);
        add(card);

        JLabel cardNumber=new JLabel("XXXX-XXXX-XXXX-8189");
        cardNumber.setBackground(Color.WHITE);
        cardNumber.setFont(new Font("Raleway",Font.BOLD,18));
        cardNumber.setBounds(300,250,400,30);
        add(cardNumber);

        JLabel cardDetails=new JLabel("Your 16 Digit Card Number");
        cardDetails.setBounds(300,290,400,30);
        cardDetails.setFont(new Font("Raleway",Font.BOLD,16));
        add(cardDetails);

        JLabel pin=new JLabel("PIN :");
        pin.setBounds(100,320,100,30);
        pin.setFont(new Font("Raleway",Font.BOLD,18));
        add(pin);

        JLabel pinNumber=new JLabel("XXXX");
        pinNumber.setBounds(300,320,100,30);
        pinNumber.setFont(new Font("Raleway",Font.BOLD,18));
        add(pinNumber);

        JLabel pinDetails=new JLabel("Your 4 Digit Pin Number");
        pinDetails.setBounds(300,360,400,30);
        pinDetails.setFont(new Font("Raleway",Font.BOLD,16));
        add(pinDetails);

        JLabel services=new JLabel("Services Required :");
        services.setFont(new Font("Raleway",Font.BOLD,18));
        services.setBounds(100,400,200,30);
        add(services);

        c1=new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,450, 150, 30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBackground(Color.WHITE);
        c2.setBounds(260,450, 200, 30);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBackground(Color.WHITE);
        c3.setBounds(470,450, 200, 30);
        add(c3);

        c4=new JCheckBox("Email & Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBackground(Color.WHITE);
        c4.setBounds(680,450, 200, 30);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100,490, 200, 30);
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBackground(Color.WHITE);
        c6.setBounds(320,490, 200, 30);
        add(c6);

        c7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBackground(Color.WHITE);
        c7.setBounds(60,550, 700, 20);
        add(c7);

        cancel=new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,18));
        cancel.setBounds(360,600,200,30);
        cancel.addActionListener(this);
        add(cancel);

        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,18));
        submit.setBounds(580,600,200,30);
        submit.addActionListener(this);
        add(submit);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String AccountType="";
            if(r1.isSelected()){
                AccountType="Savings Account";
            }
            else if(r2.isSelected()){
                AccountType="Fixed Deposit Account";
            }
            else if(r3.isSelected()){
                AccountType="Current Account";
            }
            else  if(r4.isSelected()){
                AccountType="Recurring Deposit Account";
            }
            Random r=new Random();
             cnum="8106293" + (long)(Math.random() * 1_000_000_000L);
             pnum=""+Math.abs(r.nextLong()%9000L)+1000L;
            String services="";
            if(c1.isSelected()){
                services+="ATM CARD,";
            }
            if(c2.isSelected()){
                services+=" Internet Banking,";
            }
            if(c3.isSelected()){
                services+=" Mobile Banking,";
            }
            if(c4.isSelected()){
                services+=" Email&Alers,";
            }
            if(c5.isSelected()){
                services+=" Cheque Book,";
            }
            if(c6.isSelected()){
                services+=" E-Statement,";
            }
            try{
                if(AccountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type is required");
                    return;
                }
                if(services.equals("")){
                    JOptionPane.showMessageDialog(null,"choose atleast one service");
                    return;
                }
            if(c7.isSelected()){
                conn c=new conn();
                String query1="Insert into signupthree values ('"+formno+"','"+AccountType+"','"+cnum+"','"+pnum+"','"+services+"')";
                c.s.executeUpdate(query1);

                String query2="Insert into login values ('"+formno+"','"+cnum+"','"+pnum+"')";
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Card Number :"+cnum+"\n"+"Pin Number :"+pnum );
                setVisible(false);
                new deposit(pnum).setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"please click on below checkbox to confirm changes");
                return; 
            }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new login().setVisible(true);
        }
    }
    public static void main(String[] args)  {
        new signupThree("");   
    }
}
