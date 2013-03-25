/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reflection;

/**
 *
 * @author ganesan
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//This is concept is uses to call the private method 
class AnotherClass {

    private void m() {
        System.out.println("Calling Private Meyhods...........");
    }
}

public class example2 {

    public static void main(String... args) {
        AnotherClass ac = new AnotherClass();
        try {
            Class<?> c = ac.getClass();
            Method m = c.getDeclaredMethod("m");
             m.setAccessible(true); // solution
            Object o = m.invoke(ac); // IllegalAccessException
            
        // production code should handle these exceptions more gracefully
        } catch (NoSuchMethodException x) {
            x.printStackTrace();
        } catch (InvocationTargetException x) {
            x.printStackTrace();
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        }
    }
}