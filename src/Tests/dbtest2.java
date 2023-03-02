/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import java.sql.*;

/**
 *
 * @author ujjaw
 */
public class dbtest2 {
    public static void main(String[] args) {
        try{
          String url = "jdbc:MySQL://localhost:3306/studentdatabase";         //db is the name of the database
            String user ="root";                                                  
            String password = "pass";
            
            Connection myConn = DriverManager.getConnection(url,user,password);
            Statement myStmt = myConn.createStatement();
            
            String id= "181";
            String name= "Ujjawal";
            String branch= "1BY18CS";
            String dob= "08-07-1999";
            String aadhar= "243862690074";
            String sql = "INSERT INTO student VALUES ("+ad(id)+ad(name)+ad(branch)+ad(dob)+ad(aadhar)+"1"+")";
            myStmt.executeUpdate(sql);
            
            myConn.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
    private static String ad(String x)
    {
        return "\""+x+"\",";
    }
}
