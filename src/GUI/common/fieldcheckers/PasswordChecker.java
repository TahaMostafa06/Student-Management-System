package gui.common.fieldcheckers;

import java.util.Collection;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class PasswordChecker {
    private final JLabel promptLabel;
    private final JPasswordField inputField;
    private final InputVerifier fieldVerifier;
    private final Collection<String> passwords;
    private final String defaultPrompt;
    private final String emptyPasswordPrompt;
    private final String incorrectPasswordPrompt;
    private boolean validationOn;
    private boolean verificationOn;

    public PasswordChecker(JLabel promptLabel, String defaultPrompt, String emptyPasswordPrompt,
            String incorrectPasswordPrompt, JPasswordField inputField, Collection<String> passwords) {
        this.promptLabel = promptLabel;
        this.inputField = inputField;
        this.passwords = passwords;
        this.verificationOn = false;
        this.validationOn = true;
        this.emptyPasswordPrompt = emptyPasswordPrompt;
        this.defaultPrompt = defaultPrompt;
        this.incorrectPasswordPrompt = incorrectPasswordPrompt;
        this.fieldVerifier = new InputVerifier() {
            public boolean verify(JComponent component) {
                var check = true;

                if (validationOn)
                    check &= validate();
                if (verificationOn)
                    check &= check();

                if (check)
                    indicateNormal();
                else if (!check && verificationOn)
                    indicateIncorrect();
                else if (!check && validationOn)
                    indicateInvalid();

                return check;
            }
        };
        this.inputField.setInputVerifier(fieldVerifier);
    }

    public void setAutoValidate(boolean newState) {
        this.validationOn = newState;
    }

    public boolean getAutoValidate() {
        return this.validationOn;
    }

    public boolean getAutoCheck() {
        return this.verificationOn;
    }

    public void setAutoCheck(boolean newState) {
        this.verificationOn = newState;
    }

    private String getPass() {
        return String.valueOf(this.inputField.getPassword());
    }

    private void indicateInvalid() {
        this.promptLabel.setText(defaultPrompt + " *(" + emptyPasswordPrompt + ")");
        this.inputField.requestFocus();
    }

    private void indicateIncorrect() {
        this.promptLabel.setText(defaultPrompt + " *(" + incorrectPasswordPrompt + ")");
    }

    private void indicateNormal() {
        this.promptLabel.setText(defaultPrompt);
    }

    private boolean validate() {
        var pass = getPass();
        if (pass.length() > 0)
            return true;
        return false;
    }

    private boolean check() {
        if (!validate())
            return false;
        if (passwords.contains(getPass()))
            return true;
        return false;
    }

    public boolean checkValid() {
        if (!validate()) {
            indicateInvalid();
            return false;
        } else {
            indicateNormal();
            return true;
        }
    }

    public boolean checkCorrect() {
        if (!check()) {
            indicateIncorrect();
            return false;
        } else {
            indicateNormal();
            return true;
        }
    }
}