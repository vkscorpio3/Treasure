/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author ganesan
 */
public class swap {

    public static void main(String s[]) {

        int a = 2;
        int b = 3;
        System.out.println(a);
        System.out.println(b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("");
        System.out.println(a);
        System.out.println(b);

        int c = 0;

        c = a;
        a = b;
        b = c;
        System.out.println("");
        System.out.println(a);
        System.out.println(b);


    }
}
