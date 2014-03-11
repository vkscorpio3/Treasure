/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author ganesan
 */
public class CollectionClassExamples {

    public static void main(String a[]) {
        CollectionClassExamples c = new CollectionClassExamples();
        c.CreateEmptyListSetMap();
        c.BinarySearch();
        c.reverseMethod();
        c.shuffleMethod();
        c.swapMethod();
        c.fillMethod();
        c.copyMethod();
        c.minMethod();
        c.rotateMethod();
        c.replaceAllMethod();
        c.indexOfSubListMethod();
        try {
            c.unmodifiableCollectionMethod();
        } catch (Exception ex) {
            System.out.println("Errrrrrrroooooorrrrrr");
            System.out.println("UnMofied List Cannot add the value");
        }
        c.synchronizedCollectionMethod();
        try {
            c.singletonMethod();
        } catch (Exception ex) {
            System.out.println("Errrrrrrroooooorrrrrr");
            System.out.println("Singleton List Cannot add the value");
        }
        c.nCopiesMethod();
        c.listMethod();
        c.addAllMethod();
        c.DisJointMethod();
        c.queueMethod();





    }

    void CreateEmptyListSetMap() {
        System.out.println("Creating List");
        List l = Collections.emptyList();
        System.out.println(l);
        Set s = Collections.emptySet();
        Map mp = Collections.emptyMap();
    }

    void BinarySearch() {
        System.out.println("************** Binary Search ******************");
        //search from ascending order
        ArrayList ar = new ArrayList();
        ar.add("aaaa");
        ar.add("baa");
        ar.add("cilent");
        ar.add("delivery");
        int key = Collections.binarySearch(ar, "delivery");
        System.out.println(key);
        System.out.println("Get a value using Key  == " + ar.get(key));
    }

    void reverseMethod() {
        System.out.println("************** Reverse Order ******************");
        ArrayList ar = new ArrayList();
        ar.add("First");
        ar.add("Second");
        ar.add("Third");
        ar.add("Fourth");
        System.out.println(ar);
        Collections.reverse(ar);
        System.out.println(ar);
        System.out.println(" This will Return comparator");
        Comparator co = Collections.reverseOrder();
        Comparator co1 = Collections.reverseOrder(new comp());
    }

    @SuppressWarnings("empty-statement")
    void shuffleMethod() {
        System.out.println("************** Shuufle ******************");
        ArrayList ar = new ArrayList();
        ar.add("First");
        ar.add("Second");
        ar.add("Third");
        ar.add("Fourth");
        System.out.println(ar);
        Collections.shuffle(ar);
        System.out.println(ar);

        //The java.util.Random class allows you to create objects that produce pseudo-random numbers
        //with uniform or gaussian distributions according to a linear congruential formula with a 48-bit seed.

        System.out.println("Random class and its Instance with example");
        Random r = new Random(109876L);
        int i = r.nextInt();
        for (int t = 0; t < 10; t++) {
            System.out.print(r.nextInt(100) + "\t");
        }
        System.out.println(i);
        long l = r.nextLong();
        float f = r.nextFloat();
        double d = r.nextDouble();
        int k = (int) r.nextGaussian();
        System.out.println("Shuffle using random as paramater");
        Collections.shuffle(ar, r);
        System.out.println(ar);
    }

    void swapMethod() {
        System.out.println("************** Swap ******************");
        ArrayList ar = new ArrayList();
        ar.add("First");
        ar.add("Second");
        ar.add("Third");
        ar.add("Fourth");
        System.out.println(ar);
        Collections.swap(ar, 0, 1);
        System.out.println(ar);
    }

    void fillMethod() {
        System.out.println("************** Fill ******************");
        ArrayList ar = new ArrayList();
        ar.add("First");
        ar.add("Second");
        ar.add("Third");
        ar.add("Fourth");
        Collections.fill(ar, "ganesan");
        System.out.println(ar);
    }

    void copyMethod() {
        System.out.println("************** Copy ******************");
        ArrayList src = new ArrayList();
        src.add(1);
        src.add(2);
        ArrayList dest = new ArrayList();
        dest.add(99);
        dest.add(98);
        dest.add(97);
        System.out.println("src - " + src);
        System.out.println("dest- " + dest);
        Collections.copy(dest, src);
        System.out.println("dest -" + dest);
    }

    void minMethod() {
        System.out.println("************** Min & Max ******************");
        ArrayList src = new ArrayList();
        src.add("ganesan");
        src.add("sudan");
        src.add("yasik");
        src.add("suresh");
        src.add("Abilash");
        System.out.println("**Min Method");
        Object o = Collections.min(src);
        System.out.println(o);
        Object o1 = Collections.min(src, new comp());
        System.out.println(o1);
        System.out.println("**Max Method");
        Object o2 = Collections.max(src);
        System.out.println(o2);
        Object o3 = Collections.max(src, new comp());
        System.out.println(o3);

    }

    void rotateMethod() {
        System.out.println("************** Rotate to Some Distance ******************");
        ArrayList src = new ArrayList();
        src.add("ganesan");
        src.add("sudan");
        src.add("yasik");
        src.add("suresh");
        src.add("Abilash");
        System.out.println(src);
        Collections.rotate(src, 2);
        System.out.println(src);
    }

    void replaceAllMethod() {

        System.out.println("************** Replace All ******************");
        ArrayList src = new ArrayList();
        src.add("ganesan");
        src.add("sudan");
        src.add("yasik");
        src.add("suresh");
        src.add("Abilash");
        System.out.println(src);
        Collections.replaceAll(src, "ganesan", "ganesanNew");
        System.out.println(src);

    }

    void indexOfSubListMethod() {
        System.out.println("************** IndexOfSubList ******************");
        ArrayList dest = new ArrayList();
        dest.add(99);
        dest.add(98);
        dest.add(97);

        ArrayList src = new ArrayList();
        src.add("ganesan");
        src.add("sudan");
        src.add("yasik");
        src.addAll(dest);
        src.add("suresh");
        src.add("Abilash");
        System.out.println(src);
        int index = Collections.indexOfSubList(src, dest);
        System.out.println(index);
    }

    void unmodifiableCollectionMethod() {

        System.out.println("************** unmodifiable List,Map ,Set ******************");

        ArrayList src1 = new ArrayList();
        src1.add("ganesan");
        src1.add("sudan");
        src1.add("yasik");
        src1.add("suresh");
        src1.add("Abilash");


        ArrayList arNew = (ArrayList) Collections.unmodifiableList(src1);
        try {
            arNew.add("yyyyyyyyyyyyyyyyy");
        } catch (Exception ex) {
            System.out.println("UnMofied List Cannot add the value");

        }

    }

    void synchronizedCollectionMethod() {
        System.out.println("************** Synchronized List,Map ,Set ******************");
        Set src1 = new HashSet();
        src1.add("ganesan");
        src1.add("sudan");
        src1.add("yasik");
        src1.add("suresh");
        src1.add("Abilash");
        Set aa = Collections.synchronizedSet(src1);
        System.out.println(aa);

    }

    void singletonMethod() {
        System.out.println("************** Singleton List,Map ,Set ******************");
        Set src11 = new HashSet();
        src11.add("ganesan");
        src11.add("sudan");
        src11.add("yasik");
        src11.add("suresh");
        src11.add("Abilash");
        Set aa = Collections.singleton(src11);
        aa.add("Singleton");
        System.out.println(aa);
    }

    void nCopiesMethod() {
        System.out.println("************** nCopies ******************");
        List l = Collections.nCopies(2, "RamKumar");
        System.out.println(l);
    }

    void listMethod() {
        System.out.println("************** Producing List from vector ******************");
        Vector<String> v = new Vector<String>();
        v.add("A");
        v.add("B");
        v.add("D");
        v.add("E");
        v.add("F");

        System.out.println(v);
        Enumeration<String> e = v.elements();
        ArrayList<String> aList = Collections.list(e);
        System.out.println(aList);

    }

    void addAllMethod() {
        System.out.println("************** add all from String array ******************");
        ArrayList src1 = new ArrayList();
        src1.add("ganesan");
        src1.add("sudan");
        src1.add("yasik");
        System.out.println(src1);
        String arays[] = {"Suriya", "Kamal"};
        Collections.addAll(src1, arays);
        System.out.println(src1);
    }

    void DisJointMethod() {
        System.out.println("************** DisJoint  ******************");
        ArrayList src1 = new ArrayList();
        src1.add("ganesan");
        src1.add("sudan");
        src1.add("yasik");
        //Return true if two collection contain different values
        ArrayList src = new ArrayList();
        src.add("ganesan1");
        src.add("sudan1");
        src.add("yasik1");
        boolean b = Collections.disjoint(src, src1);
        System.out.println(b);
    }

    void queueMethod() {
        System.out.println("************** Queue ******************");
        Queue src1 = new LinkedList();
        src1.add("ganesan");
        src1.add("sudan");
        src1.add("yasik");
        Queue qq = Collections.asLifoQueue((Deque) src1);
        System.out.println(qq);
    }
}

class comp implements Comparator<String> {

    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}
