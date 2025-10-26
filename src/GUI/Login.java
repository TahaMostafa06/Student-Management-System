package GUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import GUI.common.fieldcheckers.BasicValidators;

public class Login extends javax.swing.JPanel {

    // Components
    private JLabel passwordLabel;
    private JPasswordField passwordInput;
    private JLabel title;
    private JLabel UsernameLabel;
    private JTextField usernameInput;
    private JButton submitButton;

    public boolean validText(String input) {
        return (input.length() > 0);
    }

    public Login() {
        initComponents();
    }

    private void submission() {
        if (!BasicValidators.validate(usernameInput, BasicValidators.username)) {
            usernameInput.requestFocus();
        } else if (!BasicValidators.validate(passwordInput, BasicValidators.password)) {
            passwordInput.requestFocus();
        } else if (!(usernameInput.getText().equals("Taha") && String.valueOf(passwordInput.getPassword()).equals("9999"))) {
            passwordInput.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Login Successful", "Login Confirmation", JOptionPane.INFORMATION_MESSAGE);
            MainWindow frame = (MainWindow) javax.swing.SwingUtilities.getWindowAncestor(this);
            frame.showPanel("home");
        }
        
    }

    private void initComponents() {

        // Component Creation
        title = new JLabel("Student Management System");
        UsernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameInput = new JTextField();
        submitButton = new JButton("Login");
        passwordInput = new JPasswordField();

        // Cosmetic
        title.setFont(new java.awt.Font("Arial", 1, 24));
        UsernameLabel.setFont(new java.awt.Font("Arial", 1, 18));
        passwordLabel.setFont(new java.awt.Font("Arial", 1, 18));
        usernameInput.setFont(new java.awt.Font("Arial", 1, 18));
        passwordInput.setFont(new java.awt.Font("Arial", 1, 18));

        // Validations & Events

        // Custom-made Dynamic Validators
        usernameInput.setInputVerifier(BasicValidators.username);
        passwordInput.setInputVerifier(BasicValidators.password);

        // Enter events
        usernameInput.addActionListener((action) -> {
            if (BasicValidators.validate(usernameInput, BasicValidators.username)) {
                usernameInput.transferFocus();
            }
        });

        passwordInput.addActionListener((action) -> {
            submission();
        });

        submitButton.addActionListener((action) -> {
            submission();
        });

        // Netbeans generated layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(142, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(UsernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 144,
                                                Short.MAX_VALUE)
                                        .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(usernameInput)
                                        .addComponent(passwordInput, javax.swing.GroupLayout.DEFAULT_SIZE, 211,
                                                Short.MAX_VALUE))
                                .addContainerGap(62, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(title)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(title)
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(UsernameLabel))
                                .addGap(94, 94, 94)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(72, 72, 72)
                                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(54, Short.MAX_VALUE)));
    }

}
