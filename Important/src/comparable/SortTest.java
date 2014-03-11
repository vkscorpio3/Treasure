/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package comparable;

/**
 *
 * @author ganesan
 */
import java.util.*;

public class SortTest {

    public static void main(String args[]) {
        new SortTest();
    }

    public SortTest() {
        //fill some employee objects
        ArrayList list = new ArrayList();
        list.add(new Employee(500, "Shifoo", 150000));
        list.add(new Employee(504, "Oogway", 120000));
        list.add(new Employee(503, "Tigress", 100000));
        list.add(new Employee(130, "Mantis", 100000));

        System.out.println("Initial List :");
        print(list);
        System.out.println("\n");

        Collections.sort(list);
    
        System.out.println("Sorted List :");
        print(list);
        System.out.println("\n");

    }

    public void print(ArrayList list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Employee emp = (Employee) it.next();
            System.out.println(emp);
        }
    }
}

class Employee implements Comparable {

    public int id;
    public String name;
    public double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int compareTo(Object object) {
        int value = 0;

        Employee emp = (Employee) object;

        if (this.id > emp.id) {
            value = 1;
        } else if (this.id < emp.id) {
            value = -1;
        } else if (this.id == emp.id) {
            value = 0;
        }

        return value;
    }

    public String toString() {
        return this.id + ", " + this.name + ", " + this.salary;
    }
}
