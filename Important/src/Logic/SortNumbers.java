/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author ganesan
 */
public class SortNumbers {

    
    public static void sort(int[] nums) {


        for (int i = 0; i < nums.length; i++) {
            int min = i;
            System.out.println(i);
            System.out.println("df " + nums[i]);
            for (int j = i; j < nums.length; j++) {               
                if (nums[j] > nums[min]) {

                    min = j;
                }
            }
            int tmp;
            tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2334, 465, 67, 345, 456, 76, 34, 234,};

        sort(nums);
        System.out.println("Numer are");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}


