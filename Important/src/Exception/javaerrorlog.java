/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author ganesan
 */
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class javaerrorlog {

    private static Logger l = Logger.getLogger("");

    public static void main(String args[]) throws Exception {
        FileHandler handler = new FileHandler("log1.txt");
        l.addHandler(handler);

        l.setLevel(Level.ALL);

        l.info("Error logs");
        try {
        } catch (Error ex) {
            l.log(Level.INFO, "", ex);
        }
        l.fine("");
    }
}
