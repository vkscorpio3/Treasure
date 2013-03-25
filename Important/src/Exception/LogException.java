/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author ganesan
 */
import java.io.*;
import java.util.logging.*;

public class LogException {

    public static void main(String[] args) {
        LogException l = new LogException();
    }

    public void DivByZero() {
        System.out.println(1 / 0);
    }
    int arr[];

    public void ArrayBound() {
        System.out.println(arr[0]);
    }

    public LogException() {
        Logger log = Logger.getLogger("Loogggg");
        try {
            DivByZero();
        } catch (Exception e) {
            log.log(Level.WARNING, "Can not divede by zero", e.getMessage());
        }
        try {
            ArrayBound();
        } catch (Exception ex) {
            log.log(Level.INFO, "Array is blank", ex.getMessage());
        }
    }
}
