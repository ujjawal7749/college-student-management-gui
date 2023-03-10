/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package studentmanager;
import java.sql.*;
import java.util.Hashtable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ujjaw
 */
public class Grader extends javax.swing.JFrame {
Hashtable<String,Hashtable<String,String>> semarks;
    /**
     * Creates new form Grader
     */
    public Grader() {
        initComponents();
    }
    public Grader(String stid)
    {
        initComponents();
        jTextField1.setEditable(false);
        jTextField1.setText(stid);
        calculategrades(stid);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGPA and CGPA Calculation by Student ID");

        jButton1.setText("Calculate Grades");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("1BY18CS181");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Semester", "SGPA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Student ID");

        jLabel2.setText("CGPA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(229, 229, 229))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(52, 52, 52)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(182, 182, 182))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        calculategrades(jTextField1.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    void calculategrades(String stid)
    {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
       model.setRowCount(0);
        heck(stid);
    }
    
    private String sempercentage(Hashtable<String,String> submarks)
    {
        try{
        Hashtable<String,Integer> subcredits = new Hashtable<>();
        
        float totalcredits=0;
        for(String sub:submarks.keySet())
        {
            ResultSet rs = dbexec.retv("select credits from semsubjects where subject_id="+ad(sub));
            rs.next();
            totalcredits+=Integer.parseInt(rs.getString(1));
            subcredits.put(sub,Integer.parseInt(rs.getString(1)));
        }
        
        Hashtable<String,Float> subweight=new Hashtable<>();
        for(String sub:subcredits.keySet())
        {
            subweight.put(sub, subcredits.get(sub)/totalcredits);
        }
        
        float sgpa=0;
        for(String sub:submarks.keySet())
        {
            sgpa=sgpa+(Integer.parseInt(submarks.get(sub))*subweight.get(sub));
        }
        return String.valueOf(sgpa/10);
        }
        catch(Exception e){System.out.println(e.toString());return null;}
    }
    
    class gradevw extends Thread
    {
        String sem;
        Hashtable<String,String> submarks;
        public gradevw(String sem,Hashtable<String,String> submarks)
        {
            this.sem=sem;
            this.submarks=submarks;
        }
        public void run()
        {
            GradeViewer gv = new GradeViewer(sem,submarks);
            gv.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            gv.setVisible(true);
        }
    }
    
    private void heck(String stid)
    {
        try{
       ResultSet x = dbexec.retv("select sem from student where id="+ad(stid));
       x.next();
       int sem = Integer.parseInt(x.getString(1));
            //System.out.println(sem);
       Hashtable<String,String> ht= new Hashtable<>();
       for (int i=1;i<=sem;i++)
       {
           ResultSet y = dbexec.retv("select marks from studentmarks where student_id="+ad(stid)+" and sem="+ad(String.valueOf(i)));
           while(y.next())
           {
               //System.out.println(y.getString(1));
               ht.put(String.valueOf(i), y.getString(1));
           }
       }
       
       semarks= new Hashtable<>();
       for(String semester:ht.keySet())
       {
           semarks.put(semester,Commons.slicer(ht.get(semester)));
       }
       
       DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
       model.setRowCount(0);
       
       float totalsgpa=0;
       int subs=0;
       for(String semester: semarks.keySet())
       {
           subs+=1;
           String sgpa = sempercentage(semarks.get(semester));
           totalsgpa=totalsgpa+Float.parseFloat(sgpa);
           model.addRow(new Object[]{semester,sgpa});
       }
       jTextField2.setText(String.valueOf(totalsgpa/subs));
//       gradevw gv = new gradevw("1",semarks.get("1"));
//       gv.start();
//       for(String semester:semarks.keySet())
//       {
//           System.out.println(semester);
//           for(String xyz:semarks.get(semester).keySet())
//           {
//               System.out.println(xyz+"-"+semarks.get(semester).get(xyz));
//           }
//       }
       //for(String semester:ht.keySet()){System.out.println(semester+" "+ht.get(semester)); }
        }
        catch(Exception e){System.out.println(e.toString());}
    }
    public String ad(String st)
    {
        st="\""+st+"\"";
        return st;
    }
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            String sem = String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(),0));
                   gradevw gv = new gradevw(sem,semarks.get(sem));
       gv.start();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Grader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grader().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
