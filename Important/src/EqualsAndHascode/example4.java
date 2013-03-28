/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EqualsAndHascode;

import java.util.Hashtable;

/**
 *
 * @author ganesan
 */
public class example4 {

    public static void main(String args[]) {

        bean b1 = new bean("ganesan");
        bean b2 = new bean("ganesan");
        bean b3 = new bean("ganesan");
        
        Hashtable ht = new Hashtable();
        ht.put(b1, "rajesh");
        ht.put(b2, "Ramu");
        ht.put(b3, "Rajan");

        System.out.println(ht.size());

        System.out.println(ht.get(b1));
        System.out.println(ht.get(b2));


    }
}

//Remove the equals method and check
class bean {

    String name;

    bean(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof bean) {
              this.name.equals(((bean) obj).name);
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        //System.out.println(name.hashCode());
        return name.hashCode();
    }
}