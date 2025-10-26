package GUI.common.fieldcheckers;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

class UsernameValidator extends InputVerifier {
    @Override
    public boolean verify(JComponent input) {
        JTextField tf = (JTextField) input;
        return tf.getText().length() > 0;
    }
}