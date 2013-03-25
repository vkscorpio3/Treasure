/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author ganesan
 */
public class NewClass {

    int g;
    public static void main(String a[]) {
        int i = 6;
        int j;
        int COUNT = 0;
        boolean isPrime = true;
        ram:
        for (j = 2; j < i; j++) {

            System.out.println(i + " " + j);
            System.out.println(i % j);
            if (i % j == 0) {
                isPrime = false;
                break ram;
            }
        }
        if (isPrime) {
            COUNT++;
            System.out.print("  " + i);
        }
        System.out.println();
        System.out.println("Count " + COUNT);
    }
}

