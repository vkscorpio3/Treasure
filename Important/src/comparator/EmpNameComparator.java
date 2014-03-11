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
public class EmpNameComparator implements Comparator {

    public int compare(Object obj1, Object obj2) {
        String empName1 = ((EmpVo) obj1).getEmpName();
        String empName2 = ((EmpVo) obj2).getEmpName();

        return empName1.compareTo(empName2);
    }
}


