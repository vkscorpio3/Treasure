/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reflection;

/**
 *
 * @author ganesan
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


//1.Reflection is a powerful approach to analyze the class at runtime. If new classes are added into your
//application dynamically then Reflection is used to get the structure of the class.
//2.Reflection uses special kind of java class: Class. The object of the Class type can hold all
//the information of the class and have getter methods to extract this information.

public class ReflectionExample {

    public static void main(String[] args) {
        try {
            // Creates an object of type Class which contains the information of
            // the class String
            Class cl = Class.forName("java.lang.String");

            // getDeclaredFields() returns all the constructors of the class.
            Constructor cnst[] = cl.getConstructors();

            // getFields() returns all the declared fields of the class.
            Field fld[] = cl.getDeclaredFields();

            // getMethods() returns all the declared methods of the class.
            Method mtd[] = cl.getMethods();
            System.out.println("Name of the Constructors of the String class");

            for (int i = 0; i < cnst.length; i++) {
                System.out.println(cnst[i].getName());
            }

            System.out.println("Name of the Declared fields");

            for (int i = 0; i < fld.length; i++) {
                System.out.println(fld[i].getName());
            }

            System.out.println("Name of the Methods");

            for (int i = 0; i < mtd.length; i++) {
                System.out.println(mtd[i].getName());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
