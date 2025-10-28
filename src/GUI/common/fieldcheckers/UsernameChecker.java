package gui.common.fieldcheckers;

import java.util.Collection;
import java.util.jar.JarInputStream;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class UsernameChecker {
    private final JLabel promptLabel;
    private final JTextField inputField;
    private final InputVerifier fieldVerifier;
    private final Collection<String> usernames;
    private final String defaultPrompt;
    private final String emptyUsernamePrompt;
    private final String incorrectUsernamePrompt;
    private boolean validationOn;
    private boolean verificationOn;

    public UsernameChecker(JLabel promptLabel, String defaultPrompt, String emptyUsernamePrompt,
            String incorrectUsernamePrompt, JTextField inputField, Collection<String> usernames) {
        this.promptLabel = promptLabel;
        this.inputField = inputField;
        this.usernames = usernames;
        this.verificationOn = false;
        this.validationOn = true;
        this.emptyUsernamePrompt = emptyUsernamePrompt;
        this.defaultPrompt = defaultPrompt;
        this.incorrectUsernamePrompt = incorrectUsernamePrompt;
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

    private String getUser() {
        return this.inputField.getText();
    }

    private void indicateInvalid() {
        this.promptLabel.setText(defaultPrompt + " *(" + emptyUsernamePrompt + ")");
        this.inputField.requestFocus();
    }

    private void indicateIncorrect() {
        this.promptLabel.setText(defaultPrompt + " *(" + incorrectUsernamePrompt + ")");
        this.inputField.requestFocus();
    }

    private void indicateNormal() {
        this.promptLabel.setText(defaultPrompt);
    }

    private boolean validate() {
        var user = getUser();
        if (user.length() > 0)
            return true;
        return false;
    }

    private boolean check() {
        if (!validate())
            return false;
        if (usernames.contains(getUser()))
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