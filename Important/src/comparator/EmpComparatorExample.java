/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author ganesan
 */
public class EmpComparatorExample {

    public static void main(String args[]) {
        ArrayList empList = new ArrayList();
        /*
         * Create and populate employee objects and add them in the array list for next processing
         * */
        EmpVo emp1 = new EmpVo();
        emp1.setEmpName("Sarah Parker");
        emp1.setEmpDept("Human Resource");
        emp1.setEmpAge(29);
        empList.add(emp1);

        EmpVo emp2 = new EmpVo();
        emp2.setEmpName("Kathy Little");
        emp2.setEmpDept("Information and Technology");
        emp2.setEmpAge(40);
        empList.add(emp2);

        EmpVo emp3 = new EmpVo();
        emp3.setEmpName("Robert Fletcher");
        emp3.setEmpDept("Information and Technology");
        emp3.setEmpAge(32);
        empList.add(emp3);

        EmpVo emp4 = new EmpVo();
        emp4.setEmpName("Roger Andrews");
        emp4.setEmpDept("Finance");
        emp4.setEmpAge(37);
        empList.add(emp4);

        // printing the unsorted arraylist
        System.out.println("Employee Name----Age----Department");
        Iterator empItr = empList.iterator();
        while (empItr.hasNext()) {
            EmpVo emp = (EmpVo) empItr.next();
            System.out.println(emp.getEmpName() + "----" + emp.getEmpAge() + "----" + emp.getEmpDept());
        }

        Collections.sort(empList, new EmpNameComparator());
        // printing the unsorted arraylist
        System.out.println("\n\rAfter sorting based on employee name-");
        System.out.println("Employee Name----Age----Department");

        Iterator empItr1 = empList.iterator();
        while (empItr1.hasNext()) {
            EmpVo emp = (EmpVo) empItr1.next();
            System.out.println(emp.getEmpName() + "----" + emp.getEmpAge() + "----" + emp.getEmpDept());
        }


        Collections.sort(empList, new EmpDeptComparator());
        // printing the unsorted arraylist
        System.out.println("\n\rAfter sorting based on employee department-");
        System.out.println("Employee Name----Age----Department");

        Iterator empItr2 = empList.iterator();
        while (empItr2.hasNext()) {
            EmpVo emp = (EmpVo) empItr2.next();
            System.out.println(emp.getEmpName() + "----" + emp.getEmpAge() + "----" + emp.getEmpDept());
        }

        Collections.sort(empList, new EmpAgeComparator());
        // printing the unsorted arraylist
        System.out.println("\n\rAfter sorting based on employee age-");
        System.out.println("Employee Name----Age----Department");

        Iterator empItr3 = empList.iterator();
        while (empItr3.hasNext()) {
            EmpVo emp = (EmpVo) empItr3.next();
            System.out.println(emp.getEmpName() + "----" + emp.getEmpAge() + "----" + emp.getEmpDept());
        }
    }
}
