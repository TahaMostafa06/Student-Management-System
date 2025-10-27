package gui.common.fieldcheckers;

import javax.swing.InputVerifier;
import javax.swing.JComponent;

public class BasicValidators {
    public static final UsernameValidator username = new UsernameValidator();
    public static final PasswordValidator password = new PasswordValidator();

    public static boolean validate(JComponent fieldComponent, InputVerifier validator) {
        return validator.verify(fieldComponent);
    }
}
