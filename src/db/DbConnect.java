
package db;

import java.sql.*;
import javax.swing.JOptionPane;
public class DbConnect {
    private static Connection c;
    public static Statement st;
   public static PreparedStatement insertClient,getClients,updateClient,deleteClient;
    static{
        try{
 Class.forName("com.mysql.jdbc.Driver");
 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/clientsoldb",
         "root","incapp");
 st=c.createStatement();   
 insertClient=c.prepareStatement(
     "insert into client_info (name,gender,dob,country,address,language) "
             + "values (?,?,?,?,?,?)");
 getClients=c.prepareStatement(
     "select * from client_info where name like ?");
 updateClient=c.prepareStatement(
 "update client_info set name=?,gender=?,dob=?,"
         + "country=?,address=?,language=? where clientid=?");
deleteClient=c.prepareStatement(
     "delete from client_info where clientid=?");
        }catch(Exception ex){
     JOptionPane.showMessageDialog(null, ex);       
        }
    }
    public static void closeConnection(){
        try{
            if(c!=null){
                c.close();
                c=null;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
