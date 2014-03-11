/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ganesan
 */
public class HashTableExamples {

    public static void main(String a[]) {
        Hashtable ht = new Hashtable();
        ht.put(1, "ganesan");
        ht.put(2, "yasik");
        ht.put(3, "Suresh");

        System.out.println("********* All Values Enumeration ***********");
        Enumeration e = ht.elements();

        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }


        System.out.println("********* Sets ***********");
        Set s = ht.entrySet();
        Iterator it = s.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("********* All Keys using  keySets Method  ***********");
        Set s1 = ht.keySet();
        Iterator it1 = s1.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        System.out.println("********* All  keys using  Enumeration ***********");
        Enumeration e1 = ht.keys();
        while (e1.hasMoreElements()) {
            System.out.println(e1.nextElement());
        }

        System.out.println("********* All Values  ***********");
        Collection c = ht.values();
        Iterator itc = c.iterator();
        while (itc.hasNext()) {
            System.out.println(itc.next());

        }

        System.out.println("********* Map.Entry helps to get key pair value  ***********");
        Set es = ht.entrySet();
        Iterator ite = es.iterator();
        while (ite.hasNext()) {
            Map.Entry mp = (Map.Entry) ite.next();
            System.out.println(mp.getKey() + "==" + mp.getValue());
        }


       
        Hashtable ht1 = new Hashtable();
        ht1.put("Ganesan", "New");
        ht1.putAll(ht);
        try {
            ht1.put(null, null);
            ht1.put("Ramu", null);
            ht1.put(null, "string");
        } catch (Exception ee) {
            System.out.println("Errrrrooooooooooorrrrrrrrrrrrrrrrrrr");
            System.out.println("*************** HashTable will not allow null Value *****************");

        }
    }
}
