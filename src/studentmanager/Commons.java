/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanager;

import java.util.Hashtable;

/**
 *
 * @author ujjaw
 */
public class Commons {
    public static Hashtable<String,String> slicer(String str)
    {
        Hashtable<String,String> ht = new Hashtable<>();
        int curindex = 0;
        while(true)
        {
            int colonindex = str.indexOf(";",curindex);
            if(colonindex>0)
            {
                String submark[] = str.substring(curindex,colonindex).split(",");
                //System.out.println(str.substring(curindex,colonindex));ee
                ht.put(submark[0],submark[1]);
                curindex=colonindex+1;
            }
            else{break;}
        }
        for(String st : ht.keySet())
        {
            //System.out.println(st+" "+ht.get(st));
        }
        return ht;
    }
}
