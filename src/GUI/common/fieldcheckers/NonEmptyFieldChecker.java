package gui.common.fieldcheckers;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class NonEmptyFieldChecker {
    private final JLabel promptLabel;
    private final JTextField inputField;
    private final InputVerifier fieldVerifier;
    private final String defaultPrompt;
    private final String emptyInputPrompt;
    private boolean validationOn;

    public NonEmptyFieldChecker(JLabel promptLabel, String defaultPrompt,
            String emptyInputPrompt, JTextField inputField) {
        this.promptLabel = promptLabel;
        this.inputField = inputField;
        this.validationOn = true;
        this.defaultPrompt = defaultPrompt;
        this.emptyInputPrompt = emptyInputPrompt;
        this.fieldVerifier = new InputVerifier() {
            public boolean verify(JComponent component) {
                var check = true;

                if (validationOn)
                    check &= validate();

                if (check)
                    indicateNormal();
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

    private void indicateInvalid() {
        this.promptLabel.setText(defaultPrompt + " *(" + emptyInputPrompt + ")");
        this.inputField.requestFocus();
    }

    private void indicateNormal() {
        this.promptLabel.setText(defaultPrompt);
    }

    private boolean validate() {
        if (this.inputField.getText().length() > 0)
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

}