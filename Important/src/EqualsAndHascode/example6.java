/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EqualsAndHascode;

import java.util.HashSet;

/**
 * remove the hashcode and equals methods check it out
 *
 * @author ganesan
 */
public class example6 {

    public static void main(String[] args) {
        Emp emp1 = new Emp(23);
        Emp emp2 = new Emp(24);
        Emp emp3 = new Emp(25);
        Emp emp4 = new Emp(26);
        Emp emp5 = new Emp(27);
        HashSet<Emp> hs = new HashSet<Emp>();
        hs.add(emp1);
        hs.add(emp2);
        hs.add(emp3);
        hs.add(emp4);
        hs.add(emp5);

        System.out.println("HashSet Size--->>>" + hs.size());
        System.out.println("hs.contains( new Emp(25))--->>>" + hs.contains(new Emp(25)));
        System.out.println("hs.remove( new Emp(24)--->>>" + hs.remove(new Emp(24)));
        System.out.println("Now HashSet Size--->>>" + hs.size());
    }
}

class Emp {

    private int age;

    public Emp(int age) {
        super();
        this.age = age;
    }

    public int hashCode() {
        return age;
    }

    public boolean equals(Object obj) {        
        Emp emp = (Emp) obj;
        if (emp.age == age) {
        	return true;
        }
        return false;
    }
}