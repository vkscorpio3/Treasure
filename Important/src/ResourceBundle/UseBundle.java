/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ResourceBundle;

/**
 *
 * @author ganesan
 */
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Locale;

public class UseBundle {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("ResourceBundle.MyApp");
        String okLabel = bundle.getString("OKButtonLabel");
        String cancelLabel = bundle.getString("CancelButtonLabel");
        System.out.println(okLabel);
        System.out.println(cancelLabel);
    }
}
