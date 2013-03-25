/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author ganesan
 */
public class GeneratePyramidExample {

    public static void main(String[] args) throws Exception {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter Number:");
        int as = Integer.parseInt(keyboard.readLine());
        System.out.println("Enter X:");
        int x = Integer.parseInt(keyboard.readLine());



        int y = 0;



        for (int i = 0; i <= as; i++) {



            for (int j = 1; j <= i; j++) {

                System.out.print(y + "\t");

                y = y + x;

            }



            System.out.println("");

        }

    }
}
