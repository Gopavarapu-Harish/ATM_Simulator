import java.sql.*;
public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
            c=DriverManager.getConnection("jdbc:mysql:///bank_management_system","root","Hvyshuiiit");
            s=c.createStatement();
        }
        catch(Exception e){
           e.printStackTrace();
        }
    }
}
