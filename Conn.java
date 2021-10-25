
package atm.simulator.system;
import java.sql.*;
public class Conn {
   Connection c;
    Statement s;

    public Conn() {
           String forName = "com.mysql.cj.jdbc.Driver";
     
    
       try {
            Class.forName(forName);
         /*   c = DriverManager.getConnection("jdbc:mysl:///ums", "root", "");*/
           c= DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root",""); 
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
}
      /*
    Connection con= 
    */
    

    public static void main(String args[]) {
        new Conn();
    }
}
