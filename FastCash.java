import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
    JButton hund,twohund,fivehund,thous,twothous,tenthous,back;
    String pinNumber;
    FastCash(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        setSize(900,900);
        setTitle("FastCash");
        setLocation(300,0);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg")
        );
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(200,0,900,900);
        add(image);

        JLabel text=new JLabel("Please select withdraw amount :");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        text.setBounds(200,300,300,14);
        image.add(text);

        hund=new JButton("Rs 100");
        hund.setBounds(180,420,150,20);
        hund.addActionListener(this);
        image.add(hund);

        twohund=new JButton("Rs 200");
        twohund.setBounds(340,420,150,20);
        twohund.addActionListener(this);
        image.add(twohund);

        fivehund=new JButton("Rs 500");
        fivehund.setBounds(180,455,150,20);
        fivehund.addActionListener(this);
        image.add(fivehund);

        thous=new JButton("Rs 1000");
        thous.setBounds(340,455,150,20);
        thous.addActionListener(this);
        image.add(thous);

        twothous=new JButton("Rs 2000");
        twothous.setBounds(180,490,150,20);
        twothous.addActionListener(this);
        image.add(twothous);

        tenthous=new JButton("Rs 10000");
        tenthous.setBounds(340,490,150,20);
        tenthous.addActionListener(this);
        image.add(tenthous);

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
        else{
            String amount=((JButton)ae.getSource()).getText().substring(3);
            conn c=new conn();
            try{
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
                if(ae.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient balance!!!\nTry again");
                    return;
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
                String formattedDate = sdf.format(new Date());
                c.s.executeUpdate("Insert into bank values('"+pinNumber+"','"+formattedDate+"','FastCash','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Rs "+amount+" debited successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
