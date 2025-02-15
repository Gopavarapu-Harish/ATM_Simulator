/*
javac -cp ".:lib/mysql-connector-j-9.2.0.jar:lib/jcalendar-tz-1.3.3-4.jar" signupOne.java conn.java
 */
/*
 java -cp ".:lib/mysql-connector-j-9.2.0.jar:lib/jcalendar-tz-1.3.3-4.jar" signupOne
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
public class signupOne extends JFrame implements ActionListener{
    Random r;
    long num;
    JTextField nameTField,fnameTField,emailTField,addressTField,cityTField,pcTField,stateTField;
    JButton next;
    JRadioButton male,female,yes,no;
    JDateChooser dateChooser;
    public signupOne(){
        setLayout(null);
        setSize(850,800);       
        setVisible(true);
        setLocation(350,10);
        setTitle("NEW ACCOUNT APPLICATION FORM -PAGE 1");
        r=new Random();
        num=r.nextInt(9000)+1000;//1000-9999
        JLabel formno=new JLabel("APPLICATION NO. "+num);
        formno.setFont(new Font("Raleway",Font.BOLD,30));
        formno.setBounds(260,20,600,30);
        add(formno);
        JLabel personDetails=new JLabel("Personal Details: Page 1");
        personDetails.setFont(new Font("Raleway",Font.BOLD,20));
        personDetails.setBounds(300,60,400,25);
        add(personDetails);

        JLabel name=new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,18));
        name.setBounds(120,120,100,20);
        add(name);

        nameTField=new JTextField();
        nameTField.setFont(new Font("Raleway",Font.BOLD,16));
        nameTField.setBounds(400,118,300,20);
        add(nameTField);

        JLabel fname=new JLabel("Father's name :");
        fname.setFont(new Font("Raleway",Font.BOLD,18));
        fname.setBounds(120,160,190,20);
        add(fname);
         
        fnameTField=new JTextField();
        fnameTField.setFont(new Font("Raleway",Font.BOLD,16));
        fnameTField.setBounds(400,160,300,20);
        add(fnameTField);

        JLabel dob=new JLabel("Date Of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,18));
        dob.setBounds(120,200,200,20);
        add(dob);

        dateChooser=new JDateChooser();
        dateChooser.setBounds(400,200,300,20);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel gender=new JLabel("Gender :");
        gender.setFont(new Font("Raleway",Font.BOLD,18));
        gender.setBounds(120,240,100,20);
        add(gender);

        male=new JRadioButton("Male");
        male.setBackground(Color.WHITE);
        male.setBounds(400,240,100,20);
        add(male);

        female=new JRadioButton("Female");
        female.setBackground(Color.WHITE);
        female.setBounds(530,240,100,20);
        add(female);

        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email=new JLabel("Email :");
        email.setFont(new Font("Raleway",Font.BOLD,18));
        email.setBounds(120,280,100,20);
        add(email);
         
        emailTField=new JTextField();
        emailTField.setFont(new Font("Raleway",Font.BOLD,16));
        emailTField.setBounds(400,280,300,20);
        add(emailTField);

        JLabel martial=new JLabel("Martial Status :");
        martial.setFont(new Font("Raleway",Font.BOLD,18));
        martial.setBounds(120,320,200,20);
        add(martial);

        yes=new JRadioButton("Married");
        yes.setBackground(Color.WHITE);
        yes.setBounds(400,320,100,20);
        add(yes);

        no=new JRadioButton("Unmarried");
        no.setBackground(Color.WHITE);
        no.setBounds(530,320,100,20);
        add(no);

        ButtonGroup optionsGroup=new ButtonGroup();
        optionsGroup.add(yes);
        optionsGroup.add(no);

        JLabel address=new JLabel("Address :");
        address.setFont(new Font("Raleway",Font.BOLD,18));
        address.setBounds(120,360,150,20);
        add(address);

        

        addressTField=new JTextField();
        addressTField.setFont(new Font("Raleway",Font.BOLD,16));
        addressTField.setBounds(400,360,300,20);
        add(addressTField);

        JLabel city=new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD,18));
        city.setBounds(120,400,100,20);
        add(city);

        cityTField=new JTextField();
        cityTField.setFont(new Font("Raleway",Font.BOLD,16));
        cityTField.setBounds(400,400,300,20);
        add(cityTField);

        JLabel pincode=new JLabel("PinCode :");
        pincode.setFont(new Font("Raleway",Font.BOLD,18));
        pincode.setBounds(120,440,100,20);
        add(pincode);

        pcTField=new JTextField();
        pcTField.setFont(new Font("Raleway",Font.BOLD,16));
        pcTField.setBounds(400,445,300,20);
        add(pcTField);

        JLabel state=new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,18));
        state.setBounds(120,480,100,20);
        add(state);

        stateTField=new JTextField();
        stateTField.setFont(new Font("Raleway",Font.BOLD,16));
        stateTField.setBounds(400,480,300,20);
        add(stateTField);

        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(580,550,100,30);
        next.setFont(new Font("Raleway",Font.BOLD,20));
        next.addActionListener(this);
        add(next);
        getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent ae){
        String formno=""+num;
        String name=nameTField.getText();
        String fname=fnameTField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        if(female.isSelected()){
            gender="Female";
        }
        String mstatus;
        if(yes.isSelected()){
            mstatus="Married";
        }
        else{
            mstatus="Unmarried";
        }
        String email=emailTField.getText();
        String address=addressTField.getText();
        String city=cityTField.getText();
        String pinCode=pcTField.getText();
        String state=stateTField.getText();
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father's name is Required");
            }
            if(dob==null || dob.equals("")){
                JOptionPane.showMessageDialog(null,"DOB is Required");
            }
            if(gender==null || gender.equals("")){
                JOptionPane.showMessageDialog(null,"gender is Required");
            }
            if(mstatus ==null || mstatus.equals("")){
                JOptionPane.showMessageDialog(null, "Martial status is Required");
            }
            if(email.equals("")){
                JOptionPane.showMessageDialog(null,"email is Required");
            }
            if(address.equals("")){
                JOptionPane.showMessageDialog(null,"address is Required");
            }
            if(city.equals("")){
                JOptionPane.showMessageDialog(null,"city is Required");
            }
            if(pinCode.equals("")){
                JOptionPane.showMessageDialog(null,"PINCODE is Required");
            }
            if(state.equals("")){
                JOptionPane.showMessageDialog(null,"state is Required");
            }
            else{
                conn c=new conn();
                String query="Insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+mstatus+"','"+email+"','"+address+"','"+city+"','"+pinCode+"','"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signupTwo(formno).setVisible(true);
            }
        }
        catch(Exception e){
           e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new signupOne();
    }
    
}
