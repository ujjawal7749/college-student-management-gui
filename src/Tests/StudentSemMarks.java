/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import Tests.SemSubjects;
import java.util.Hashtable;

/**
 *
 * @author ujjaw
 */
public class StudentSemMarks {
    String stid,branch,sem;
    private Hashtable<String,Integer> markstable = new Hashtable<>();
    
    public StudentSemMarks(Student st)
    {
        this.stid=st.id;
        this.branch=st.branch;
        this.sem=st.sem;
        inittable();
    }
    
    
   private void inittable()
   {
       markstable.clear();
       SemSubjects ss = new SemSubjects("","");
       // Add code to get subjects object from databse above
       for (String subject : ss.subjects)
       {
           markstable.put(subject,0);
       }
   }
   
   public void inittable(SemSubjects ss)
   {
       markstable.clear();
       for (String subject : ss.subjects)
       {
           markstable.put(subject,0);
       }
   }
   
   public void assignmarks(String subject,Integer marks)
   {
       if(markstable.containsKey(subject))
       {
           markstable.put(subject, marks);
       }
   }
   
   public void assignmarks(Hashtable<String,Integer> giventable)
   {
       for(String givensubject: giventable.keySet())
       {
           if(markstable.containsKey(givensubject))
        {
            markstable.put(givensubject, giventable.get(givensubject));
        }
       }
   }
  
   public Hashtable<String,Integer> returnmarkstable()
   {
       return markstable;
   }
   
}
