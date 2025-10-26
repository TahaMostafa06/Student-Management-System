package GUI;
import Records.Student;
import Records.StudentDatabase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ViewStudents extends javax.swing.JPanel {
    
    final String filename;

    public boolean validText(String input){
        return (input.length() > 0);
    }
    public boolean validGPA(String input){
        if(input.length() == 0)
            return false;
        try {
            double value = Double.parseDouble(input);
            if(value < 0 || value > 4)
                return false;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean validAge(String input){ //age between 0 and 99
       if(input.length() == 0)
            return false;
        try {
            int value = Integer.parseInt(input);
            return (value >= 0 && value <= 99);
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public boolean validID(String input){ //age between 0 and 99
       if(input.length() == 0)
            return false;
        try {
            int id = Integer.parseInt(input);
            return (id >= 0);
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    
    public int countFileLines(String filename){
        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while (br.readLine() != null) {
                lineCount++;
            }
            System.out.println("Number of lines: " + lineCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }
    
    public static void sortFileByID(String filename) throws IOException{
        StudentDatabase st=new StudentDatabase(filename);
        ArrayList <Student> s=st.returnAllRecords();
        for(int i=0; i < s.size(); i++){
	       for(int j=0; j< s.size() - i - 1; j++){
		        if(Integer.parseInt((s.get(j)).getSearchKey()) > Integer.parseInt(s.get(j + 1).getSearchKey())){
			         Student temp = s.get(j);
				 s.set(j, s.get(j + 1)); // Use set method for assignment
                                 s.set(j + 1, temp);
			}
		}
	} try (var writer = new BufferedWriter(new FileWriter(filename, false))) {
            writer.write(""); 
            for (var r : s) {
                writer.write(r.lineRepresentation());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
    
    public void addToCell(String filename) throws IOException{
        StudentDatabase st=new StudentDatabase(filename);
        ArrayList <Student> s=st.returnAllRecords();
        int rowCount=0;
        for (var i : s){
            boolean A=validID(i.getSearchKey());
            boolean B=validText(i.getName());
            boolean C=validAge(String.valueOf(i.getAge()));
            boolean D=false;
            if (i.getGender()==true || i.getGender()==false){
                D=true;
            }
            boolean F=validText(i.getDepartment());
            boolean E=validGPA(String.valueOf(i.getGPA()));
            if (A && B && C && D && F && E){
                jTable1.setValueAt(i.getSearchKey(),rowCount,0);
                jTable1.setValueAt(i.getName(),rowCount,1);
                jTable1.setValueAt(i.getAge(),rowCount,2);
                if (i.getGender()==true){
                    jTable1.setValueAt("Male",rowCount,3);
                }else{
                    jTable1.setValueAt("Female",rowCount,3);
                }
                jTable1.setValueAt(i.getDepartment(),rowCount,4);
                jTable1.setValueAt(i.getGPA(),rowCount,5);
            }
            rowCount++;
        }
    } 
    
    public ViewStudents() {
        filename="Students.txt";
        try {
            sortFileByID(filename);
        } catch (IOException ex) {
            System.getLogger(ViewStudents.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        initComponents();
        setVisible(true);
        jTable1.getTableHeader().setOpaque(false); 
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();  
        model.setRowCount(countFileLines(filename));
        try {
            addToCell(filename);
        } catch (IOException ex) {
            System.getLogger(ViewStudents.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(130, 195, 130));
        setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("View Students");

        jButton2.setBackground(new java.awt.Color(255, 153, 153));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Age", "Gender", "Department", "GPA"
            }
        ));
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton2)
                .addGap(177, 177, 177)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(113, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(113, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(392, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(39, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MainWindow frame = (MainWindow) javax.swing.SwingUtilities.getWindowAncestor(this);
        frame.showPanel("home");
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}