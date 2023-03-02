/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanager;

/**
 *
 * @author ujjaw
 */
public class dbhelp {
  
    public static String makesql(String table,String[] items)
    {
        String sql = "INSERT INTO "+table+" VALUES (";
        for(String s : items)
        {
            sql = sql + ad(s);
        }
        sql = sql.substring(0,sql.length()-1);
        sql=sql+")";
        
        //System.out.println(sql);
        return sql;
    }
    
    public static String ad(String x)
    {
        return "\""+x+"\",";
    }
    
}
