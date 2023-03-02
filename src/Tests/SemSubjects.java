/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import java.util.ArrayList;

/**
 *
 * @author ujjaw
 */
public class SemSubjects {
    String branch,sem;
    ArrayList <String> subjects= new ArrayList<>();
    
    public SemSubjects(String branch,String sem)
    {
        this.branch=branch;
        this.sem=sem;
    }
    
    public void addsubject(String subject)
    {
        if(!subjects.contains(subject)) subjects.add(subject);
    }
}
