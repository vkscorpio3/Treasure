/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author ganesan
 */
public class primenumber {

    public static void main(String a[]) {
        int i;
        int j;
        int COUNT = 0;


        for (i = 2; i < 40; i++) {

            boolean isPrime = true;

            for (j = 2; j < i; j++) {
               
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                COUNT++;

                System.out.print("  " + i);
            }
        }

        System.out.println("");
        System.out.println("Count " + COUNT);
    }
}
