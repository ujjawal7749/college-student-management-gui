/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import Tests.SemSubjects;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author ujjaw
 */
public class Branch {
    String id,name,semesters;
    Hashtable<String,SemSubjects> semsubjects = new Hashtable<>();
    
    public Branch(String id,String name,String semesters)
    {
        this.id=id;
        this.name=name;
        this.semesters=semesters;
    }
    
    public void addsemsubjects(String semester,SemSubjects SemSubjectsObject)
    {
        semsubjects.put(semester,SemSubjectsObject);
    }
}
