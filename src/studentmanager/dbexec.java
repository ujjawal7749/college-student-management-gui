/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanager;
import java.sql.*;  


/**
 *
 * @author ujjaw
 */
public class dbexec {
    public static void query(String sql)
    {
        try{
          String url = "jdbc:MySQL://localhost:3306/studentdatabase";         //db is the name of the database
            String user ="root";                                                  
            String password = "pass";
            
            Connection myConn = DriverManager.getConnection(url,user,password);
            Statement myStmt = myConn.createStatement();
            
            myStmt.executeUpdate(sql);
            
            myConn.close();
        }
        catch(Exception e)
        {
            System.out.println(e .toString());
        }
    }
    
    public static ResultSet retv(String sql)
    {
        try{
            
        //Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","pass");  
        Statement stmt=con.createStatement();
        
        ResultSet rs=stmt.executeQuery(sql);
        return rs;
        }
        catch(Exception e){
            System.out.println(e.toString());
            return null;}
    }
}
