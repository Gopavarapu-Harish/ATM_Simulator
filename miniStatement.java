import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
public class miniStatement  extends JFrame implements ActionListener{
    JButton back;
    String pinNumber;
    miniStatement(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        setTitle("Mini-Statement");
        setSize(800,600);
        setLocation(300,150);
        getContentPane().setBackground(Color.white);
        JLabel bank=new JLabel("UNION BANK OF INDIA");
        bank.setFont(new Font("System",Font.BOLD,18));
        bank.setBounds(550,60,300,20);
        add(bank);

        JLabel card=new JLabel("");
        card.setBounds(100,100,400,20);
        add(card);
        setVisible(true);

        JLabel mini=new JLabel("");
        mini.setBounds(100,150,600,400);
        add(mini);
        setVisible(true);

        back=new JButton("Back");
        back.setBounds(100,600,150,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from login where pinNumber='"+pinNumber+"'");
            while(rs.next()){
                card.setText("Card Number "+rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12));

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        try{
            conn c=new conn();
            ResultSet rs2 = c.s.executeQuery("SELECT * FROM bank WHERE pin='" + pinNumber + "'");
            StringBuilder statement = new StringBuilder("<html>");

            while (rs2.next()) {
                statement.append(rs2.getString("date")).append("&nbsp;&nbsp;")
                        .append(rs2.getString("type")).append("&nbsp;&nbsp;")
                        .append(rs2.getString("amount")).append("<br><br>");
            }

            statement.append("</html>");
            mini.setText(statement.toString());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
       }
    }

    public static void main(String[] args) {
        new miniStatement("");
    }   
}
