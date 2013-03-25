/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Douts;

/**
 *
 * @author ganesan
 */
public class casting {

    public static void main(String f[]) {
        a ref = new a();
        ref.method();
        b ref1 = new b();
        ref1.method();
        ref1.method1();

        a ref3 = new b();
        ref3.method();

        b ref4 = (b) new a();

        ref4.method();




    }
}

class a {

    void method() {
        System.out.println("class A");
    }
}

class b extends a {

    void method() {
        System.out.println("class B");
    }

    void method1() {
        System.out.println("class B Method 1");
    }
}
