import java.sql.*;  
class dbtest{  
public static void main(String args[]){  
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/studentdatabase","root","pass");  
//here sonoo is database name, root is username and password  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from branch");  
while(rs.next())  
System.out.println(rs.getInt(1)+"  "+rs.getString(2));  

ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
         int count = md.getColumnCount();
         System.out.println("The column names are as follows:");
         for (int loop = 1; loop <= count; loop++) {
            System.out.println(md.getColumnLabel(loop));
         }

con.close();  
}catch(Exception e){ System.out.println(e);}  
}  
}  