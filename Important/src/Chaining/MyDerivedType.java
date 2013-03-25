/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chaining;

/**
 *
 * @author ganesan
 */
public class MyDerivedType extends MyType {

    private String e;

////constructor
//    public MyDerivedType() {
//        super(); //We call the constructor of MyType
//        e = "";
//    }
//
//    public MyDerivedType setE(String s) {
//        e = s;
//        return this;
//    }
//
//    public MyDerivedType () {
//super(); //We call the constructor of MyType
//e = "";
//}

//Override notation to help readability, we can do without it, though
    @Override
    public MyDerivedType setA(String s) {
        return (MyDerivedType) super.setA(s);
    }

    @Override
    public MyDerivedType setB(String s) {
        return (MyDerivedType) super.setB(s);
    }

    @Override
    public MyDerivedType setC(String s) {
        return (MyDerivedType) super.setC(s);
    }

    @Override
    public MyDerivedType setD(String s) {
        return (MyDerivedType) super.setD(s);
    }

    public MyDerivedType setE(String s) {
        e = s;
        return this;
    }

    public static void main(String h[]) {

  //      MyDerivedType t = (MyDerivedType) (new MyType().setA("a").setB("b"));
    //    MyDerivedType t1 = ((MyDerivedType) (new MyType().setA("a").setB("b"))).setE("e");
        //       MyDerivedType t2 = new MyType();1

        MyDerivedType t3 = new MyDerivedType().setA("a").setB("b").setC("c").setD("d").setE("e");

    }
}
