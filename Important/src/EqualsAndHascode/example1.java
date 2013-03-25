/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EqualsAndHascode;

/**
 *
 * @author ganesan
 */
public class example1 {

    public static void main(String ar[]) {
        a A1 = new a("ganesan");
        a A2 = new a("ganesan");


        boolean result = A1.equals(A2);
        System.out.println(result);
        System.out.println(A1.hashCode());
        System.out.println(A2.hashCode());
    }
}

class a {

    String name;

    a(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        a b= (a)obj;
        return name.equals(b.name);
    }

}