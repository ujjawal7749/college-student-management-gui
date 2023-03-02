/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

/**
 *
 * @author ujjaw
 */
public class marktest {
    public static void main(String[] args) {
        String str ="14XLYWD,54;1KX1Y,66;";
        
        int curindex = 0;
        while(true)
        {
            int colonindex = str.indexOf(";",curindex);
            if(colonindex>0)
            {
                String submark[] = str.substring(curindex,colonindex).split(",");
                System.out.println(submark[0]+" "+submark[1]);
                curindex=colonindex+1;
            }
        }
    }
}
