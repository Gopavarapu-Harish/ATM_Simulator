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
public class signupTwo extends JFrame implements ActionListener{
    Random r;
    String num;
    JTextField panTField,aadharTField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,Category,incomeCategory,eduCategory,oCategory;
    public signupTwo(String formno){
        num=formno;
        setLayout(null);
        setSize(850,800);       
        setVisible(true);
        setLocation(350,10);
        setTitle("NEW ACCOUNT APPLICATION FORM -PAGE 2");
        JLabel additionalDetails=new JLabel("Additional Details: Page 2");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        additionalDetails.setBounds(300,60,400,25);
        add(additionalDetails);

        JLabel Rname=new JLabel("Religion :");
        Rname.setFont(new Font("Raleway",Font.BOLD,18));
        Rname.setBounds(120,120,100,20);
        add(Rname);

        String[] religions={"Hindu","Muslim","Christian","other"};
        religion=new JComboBox<>(religions);
        religion.setFont(new Font("Raleway",Font.BOLD,16));
        religion.setBounds(400,118,300,20);
        religion.setBackground(Color.WHITE);
        add(religion);
        

        JLabel Cname=new JLabel("Category :");
        Cname.setFont(new Font("Raleway",Font.BOLD,18));
        Cname.setBounds(120,160,190,20);
        add(Cname);
         
        String[] categories={"General","OC","BC","SC","ST","other"};
        Category=new JComboBox<>(categories);
        Category.setFont(new Font("Raleway",Font.BOLD,16));
        Category.setBounds(400,160,300,20);
        Category.setBackground(Color.WHITE);
        add(Category);

        JLabel income=new JLabel("Income :");
        income.setFont(new Font("Raleway",Font.BOLD,18));
        income.setBounds(120,200,200,20);
        add(income);

        String[] incomeCategories={"null","<1,50,000","<2,50,000","<5,00,000","up to 10,00,000"};
        incomeCategory=new JComboBox<>(incomeCategories);
        incomeCategory.setFont(new Font("Raleway",Font.BOLD,16));
        incomeCategory.setBounds(400,200,300,20);
        incomeCategory.setBackground(Color.WHITE);
        add(incomeCategory);

        JLabel edu=new JLabel("Educational");
        edu.setFont(new Font("Raleway",Font.BOLD,18));
        edu.setBounds(120,240,200,20);
        add(edu);


        JLabel qua=new JLabel("Qualification :");
        qua.setFont(new Font("Raleway",Font.BOLD,18));
        qua.setBounds(120,270,200,20);
        add(qua);
        
        String[] eduCategories={"Non-Graduate","Graduate","Post-Graduate","Doctrate"};
        eduCategory=new JComboBox<>(eduCategories);
        eduCategory.setFont(new Font("Raleway",Font.BOLD,16));
        eduCategory.setBounds(400,270,300,20);
        eduCategory.setBackground(Color.WHITE);
        add(eduCategory);


        JLabel occupation=new JLabel("Occupation :");
        occupation.setFont(new Font("Raleway",Font.BOLD,18));
        occupation.setBounds(120,320,200,20);
        add(occupation);

        String[] occCategories={"Salaried","Self-Employed","Business","Student","Retired"};
        oCategory=new JComboBox<>(occCategories);
        oCategory.setFont(new Font("Raleway",Font.BOLD,16));
        oCategory.setBounds(400,320,300,20);
        oCategory.setBackground(Color.WHITE);
        add(oCategory);


        JLabel pan=new JLabel("PAN Number :");
        pan.setFont(new Font("Raleway",Font.BOLD,18));
        pan.setBounds(120,360,150,20);
        add(pan);

        

        panTField=new JTextField();
        panTField.setFont(new Font("Raleway",Font.BOLD,16));
        panTField.setBounds(400,360,300,20);
        add(panTField);

        JLabel aadhar=new JLabel("Aadhar Number :");
        aadhar.setFont(new Font("Raleway",Font.BOLD,18));
        aadhar.setBounds(120,400,200,20);
        add(aadhar);

        aadharTField=new JTextField();
        aadharTField.setFont(new Font("Raleway",Font.BOLD,16));
        aadharTField.setBounds(400,400,300,20);
        add(aadharTField);

        JLabel sCitizen = new JLabel("Senior Citizen :");
        sCitizen.setFont(new Font("Raleway", Font.BOLD, 18));
        sCitizen.setBounds(120, 440, 200, 20);
        add(sCitizen);

        syes = new JRadioButton("Yes");
        syes.setFont(new Font("Raleway", Font.BOLD, 16));
        syes.setBackground(Color.WHITE);
        syes.setBounds(400, 440, 80, 30);  // Increased width & height
        add(syes);

        sno = new JRadioButton("No");
        sno.setFont(new Font("Raleway", Font.BOLD, 16));
        sno.setBackground(Color.WHITE);
        sno.setBounds(500, 440, 80, 30);  // Positioned properly beside 'Yes'
        add(sno);

        // Grouping them so only one can be selected
        ButtonGroup sGroup = new ButtonGroup();
        sGroup.add(syes);
        sGroup.add(sno);
       
        JLabel eAccount = new JLabel("Existing Account :");
        eAccount.setFont(new Font("Raleway", Font.BOLD, 18));
        eAccount.setBounds(120, 480, 200, 20);
        add(eAccount);

        eyes = new JRadioButton("Yes");
        eyes.setFont(new Font("Raleway", Font.BOLD, 16));
        eyes.setBackground(Color.WHITE);
        eyes.setBounds(400, 480, 80, 30);  // Proper positioning
        add(eyes);

        eno = new JRadioButton("No");
        eno.setFont(new Font("Raleway", Font.BOLD, 16));
        eno.setBackground(Color.WHITE);
        eno.setBounds(500, 480, 80, 30);  // Proper positioning beside 'Yes'
        add(eno);

        // Grouping them so only one can be selected
        ButtonGroup eGroup = new ButtonGroup();
        eGroup.add(eyes);
        eGroup.add(eno);
        


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
        String rname=religion.getSelectedItem().toString();
        String cname=Category.getSelectedItem().toString();
        String iCategory=incomeCategory.getSelectedItem().toString();
        String eCategory=eduCategory.getSelectedItem().toString();
        String ocCategory=oCategory.getSelectedItem().toString();
        String pan=panTField.getText();
        String aadhar=aadharTField.getText();
        String sCitizen=null;
        if(syes.isSelected()){
            sCitizen="Yes";
        }
        if(sno.isSelected()){
            sCitizen="No";
        }
        String exAccount=null;
        if(eyes.isSelected()){
            exAccount="Yes";
        }
        if(eno.isSelected()){
            exAccount="No";
        }
        
        try{
            if(rname.equals("")){
                JOptionPane.showMessageDialog(null,"Religion is Required");
            }
            if(cname.equals("")){
                JOptionPane.showMessageDialog(null,"Category is Required");
            }
            if(iCategory.equals("")){
                JOptionPane.showMessageDialog(null,"income is Required");
            }
            if(eCategory.equals("")){
                JOptionPane.showMessageDialog(null,"education is Required");
            }
            if(ocCategory.equals("")){
                JOptionPane.showMessageDialog(null,"occupation is Required");
            }
            if(pan.equals("")){
                JOptionPane.showMessageDialog(null,"PAN is Required");
            }
            if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhar is Required");
            }
            if(sCitizen==null || sCitizen.equals("")){
                JOptionPane.showMessageDialog(null," Choosing option is Required");
            }
            if(exAccount==null || exAccount.equals("")){
                JOptionPane.showMessageDialog(null," Choosing option is Required");
            }
            
            else{
                conn c=new conn();
                String query="Insert into signuptwo values ('"+formno+"','"+rname+"','"+cname+"','"+iCategory+"','"+eCategory+"','"+ocCategory+"','"+pan+"','"+aadhar+"','"+sCitizen+"','"+exAccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signupThree(formno).setVisible(true);
            }
        }
        catch(Exception e){
           e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new signupTwo("");
    }
    
}
