/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EqualsAndHascode;

/**
 *
 * @author ganesan
 */
public class example2 {

    public static void main(String a[]) {

        test t1 = new test("1234");
        test t2 = new test("1234");
        System.out.println(t1.equals(t2));
    }
}

class test {

    String val;

    test(String value) {
        this.val = value;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof test) {
            this.val.equals(((test) obj).val);
            return true;

        }
        return false;
    }
}
