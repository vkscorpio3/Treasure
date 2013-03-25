/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author ganesan
 */
public class NumberFactorial {

    public static void main(String[] args) {
        int number = 5;
        int factorial = number;

        for (int i = (number - 1); i > 1; i--) {
            factorial = factorial * i;
        }
        System.out.println("Factorial of a number is " + factorial);

        System.out.println("Facto  " + fact(6));
    }

    static int fact(int b) {

        if (b <= 1) //if the number is 1 then return 1
        {
            return 1;
        } else //else call the same function with the value - 1
        {
            return b * fact(b - 1);
        }

    }
}
