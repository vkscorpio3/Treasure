/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ganesan
 */
public class example1 {

    public static void main(String a[]) {
        try {
            throw new test();
        } catch (test ex) {

            System.out.println(ex.variable);
            StackTraceElement e[] = ex.getStackTrace();
            System.out.println(e[0]);            
        //Logger.getLogger(example1.class.getName()).log(Level.SEVERE, "Ganesan", ex);
        }
    }
}

class test extends Exception {

    int variable = 55555;

    test() {
        System.out.println("Hiiiiiiiii");
    }
}
