/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import Tests.Student;
import Tests.Branch;
import Tests.StudentSemMarks;
import Tests.SemSubjects;
import java.util.Hashtable;

/**
 *
 * @author ujjaw
; */
public class Testing {
    public static void main(String[] args) {
        Branch cse = new Branch("1234","CSE","8");
        SemSubjects cse1subjects = new SemSubjects(cse.name,"1");
        cse1subjects.addsubject("Physics");
        cse1subjects.addsubject("Chemistry");
        
        Student st1 = new Student("181","Ujjawal","CSE","1","1","1");
        
        StudentSemMarks stm = new StudentSemMarks(st1);
        stm.inittable(cse1subjects);
        stm.assignmarks("Physics", 50);
        
        Hashtable<String,Integer> ht = stm.returnmarkstable();
        
        for(String st : ht.keySet())
        {
            System.out.println(st+" "+ht.get(st));
        }
    }
}
