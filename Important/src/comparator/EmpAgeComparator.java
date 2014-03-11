/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

import java.util.Comparator;

/**
 *
 * @author ganesan
 */
public class EmpAgeComparator implements Comparator {

    public int compare(Object obj1, Object obj2) {
        int empAge1 = ((EmpVo) obj1).getEmpAge();
        int empAge2 = ((EmpVo) obj2).getEmpAge();

        if (empAge1 > empAge2) {
            return 1;
        } else if (empAge1 < empAge2) {
            return -1;
        } else {
            return 0;
        }
    }
}
