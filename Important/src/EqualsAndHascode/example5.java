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
public class example5 {

    public static void main(String args[]) {

        hashtest ht1 = new hashtest("A");
        hashtest ht2 = new hashtest("A");
        Hashtable hash = new Hashtable();
        hash.put(ht1, "wwwwww");
      
        System.out.println(hash.get(ht2));
    }
}

class hashtest {

    String name;

    hashtest(String name) {

        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof hashtest) {

            this.name.endsWith(((hashtest) obj).name);
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        
        return name.hashCode();
    }
}