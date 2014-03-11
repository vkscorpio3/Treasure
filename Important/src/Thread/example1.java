/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ganesan
 */
public class example1 {

    public static void main(String g[]) {
        test t = new test();
        
        test1 t1 = new test1();

        Thread th= new Thread(t);
         Thread th1= new Thread(t1);
        th.start();
        
       
        th1.start();


    }
}

class test implements Runnable {

    public void run() {
        int i = 0;
        while (i < 100) {
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("t" + i);
        }
    }
}

class test1 implements Runnable {

    public void run() {
        int i = 0;
        while (i < 100) {
            i++;
            System.out.println("tt" + i);
        }
    }
}