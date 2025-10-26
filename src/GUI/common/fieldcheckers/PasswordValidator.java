package GUI.common.fieldcheckers;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

class PasswordValidator extends InputVerifier {
    public PasswordValidator() {

    }

    public PasswordValidator(boolean showTooltip) {

    }

    public PasswordValidator(boolean showTooltip, String tootltip) {

    }

    public boolean verify(JComponent input) {
        JTextField tf = (JTextField) input;
        var valid = tf.getText().length() > 0;
        if (!valid)
            tf.setToolTipText("E");
        else
            tf.setToolTipText("");
        return valid;
    }
}