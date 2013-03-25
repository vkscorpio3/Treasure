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

public class GetBundle {

    public static void main(String[] args) {
        Locale locale = new Locale("en", "AU");
        ResourceBundle bundle = ResourceBundle.getBundle("ResourceBundle.MyApp",locale);
        Enumeration keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String value = bundle.getString(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}

