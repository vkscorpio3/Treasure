/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chaining;

/**
 *
 * @author ganesan
 */
public class MyType {

    private String a,  b,  c,  d;

//constructor
    public MyType() {
        a = "";
        b = "";
        c = "";
        d = "";
//return this;
    }

    public MyType setA(String s) {
        a = s;
        return this;
    }

    public MyType setB(String s) {
        b = s;
        return this;
    }

    public MyType setC(String s) {
        c = s;
        return this;
    }

    public MyType setD(String s) {
        d = s;
        return this;
    }
}
