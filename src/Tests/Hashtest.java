/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import java.util.Hashtable;

/**
 *
 * @author ujjaw
 */
public class Hashtest {
    public static void main(String[] args) {
        Hashtable <String,String> hs= new Hashtable<>();
        
        hs.put("1","X");
        hs.put("1","Y");
        
        System.out.println(hs.get("1"));
        System.out.println(hs.get(1));
        System.out.println(hs.get("2"));
    }
}
