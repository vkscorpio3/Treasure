/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author ganesan
 */
public class ReverseNumber {

    public static void main(String[] args) {
        int number = 1234;
        int reversedNumber = 0;
        int temp = 0;
        while (number > 0) {
//use modulus operator to strip off the last digit
            temp = number % 10;
            System.out.println("t "+temp);
//create the reversed number
            reversedNumber = reversedNumber * 10 + temp;
            System.out.println("reverse "+reversedNumber);
            number = number / 10;
            System.out.println(number);
        }
//output the reversed number
        System.out.println("Reversed Number is: " + reversedNumber);

    }
}
