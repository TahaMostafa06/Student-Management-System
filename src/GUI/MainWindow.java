package gui;
import common.data.StudentDatabase;
import gui.common.tablemodels.StudentTableModel;
import java.awt.CardLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public final class MainWindow extends javax.swing.JFrame {
    Login login;
    HomePage home;
    AddStudents addStudents;
    ViewStudents viewStudents;
    SearchAndUpdate searchUpdateStudents;
    DeleteStudents deleteStudents;
    CardLayout cardLayout;
    StudentTableModel tableModel;
    public void showPanel(String panel){
        cardLayout.show(ContentPanel, panel);
    }
    public MainWindow() {
        initComponents();
        try {
            tableModel = new StudentTableModel(StudentDatabase.getInstance("Students.txt"));
            login = new Login();
            home = new HomePage();
            addStudents = new AddStudents(tableModel);
            viewStudents = new ViewStudents(tableModel);
            searchUpdateStudents = new SearchAndUpdate(tableModel);
            deleteStudents = new DeleteStudents(tableModel);
            cardLayout = (CardLayout) ContentPanel.getLayout();
            ContentPanel.add(login, "login");
            ContentPanel.add(home, "home");
            ContentPanel.add(addStudents, "addstudents");
            ContentPanel.add(viewStudents, "viewstudents");
            ContentPanel.add(searchUpdateStudents, "searchupdatestudents");
            ContentPanel.add(deleteStudents, "deletestudents");
            showPanel("login");
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Grey"));

        ContentPanel.setMinimumSize(new java.awt.Dimension(650, 500));
        ContentPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(() -> {
            new MainWindow().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentPanel;
    // End of variables declaration//GEN-END:variables
}
