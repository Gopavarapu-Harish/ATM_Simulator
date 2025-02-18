import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class withdraw extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdraw, back;
    String pinNumber;

    withdraw(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        setTitle("Withdraw");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(200, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        text.setBounds(170, 300, 350, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 18));
        amount.setBounds(170, 340, 300, 25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(340, 490, 150, 20);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(340, 525, 150, 20);
        back.addActionListener(this);
        image.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else if (ae.getSource() == withdraw) {
            String number = amount.getText().trim();  // Remove extra spaces

            // Check if the input is empty or non-numeric
            if (number.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int withdrawAmount = Integer.parseInt(number);

                if (withdrawAmount <= 0) {
                    JOptionPane.showMessageDialog(null, "Amount must be greater than zero!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Database connection
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin='" + pinNumber + "'");

                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                // Check if balance is sufficient
                if (balance < withdrawAmount) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance!\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Insert withdrawal transaction into database
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = sdf.format(new Date());
                c.s.executeUpdate("INSERT INTO bank VALUES('" + pinNumber + "', '" + formattedDate + "', 'withdraw', '" + withdrawAmount + "')");

                JOptionPane.showMessageDialog(null, "Rs " + withdrawAmount + " debited successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter numbers only.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new withdraw("");
    }
}
