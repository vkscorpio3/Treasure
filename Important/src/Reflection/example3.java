/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * @author ganesan
 */
public class example3 {

    public static void main(String args[]) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        test t = new test("ganesan", 12);
        Class<?> c = t.getClass();
        Method meth[] = c.getMethods();
        System.out.println("********  Invoke ***********");
        
        Object o = meth[0].invoke(t);
        System.out.println(meth[0].getName() + "=== " + o);
        Object o1 = meth[2].invoke(t);
        System.out.println(meth[2].getName() + "=== " + o1);

//        Object o2 = meth[3].invoke(t,"Rajesh");
//        System.out.println(meth[3].getName() + " Sucessss ");
//
//        Object o3 = meth[1].invoke(t);
//        System.out.println(meth[1].getName() + "=== " + o3);

        System.out.println("********  End ***********");
        for (int i = 0; i <= meth.length; i++) {
            System.out.println("Method Name =" + meth[i].getName());
            System.out.println("Method return type " + meth[i].getReturnType());
            System.out.println(meth[i].getModifiers());
            int nn = meth[i].getModifiers();
            System.out.println("Modifier " + Modifier.toString(nn));
            Class c1[] = meth[0].getParameterTypes();
            System.out.println("Parameter Types  ====" + c1[0]);


            System.out.println("---------------------------------------");



        }
    }
}

class test {

    String name;
    int id;

    test(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}