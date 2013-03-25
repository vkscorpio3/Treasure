package EqualsAndHascode;


import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ganesan
 */
public class HashCodeExample {

    public static void hashMapExample() {

        System.out.println("\nHashMap Example Method");
        System.out.println("======================\n");

        //construct a HashMap with default size and load factor
        HashMap table = new HashMap();

        String name;
        String key;

        // We want to map people with their social security numbers the
        // key/value pair is ssn[i]/people[i]. Note that the value "Tom" appears
        // twice, but has different keys.
        String[] ssn = new String[5];
        ssn[0] = "00000";
        ssn[1] = "11111";
        ssn[2] = "22222";
        ssn[3] = "33333";
        ssn[4] = "44444";

        String[] people = new String[5];
        people[0] = "Tom";
        people[1] = "Jay";
        people[2] = "Pat";
        people[3] = "Meghan";
        people[4] = "Tom";


        // put() maps key/value pairs
        for (int i = 0; i < people.length; i++) {
            table.put(ssn[i], people[i]);
        }


        // Now return the name for social security number 11111 ...
        key = "11111";
        if (table.containsKey(key)) {
            name = (String) table.get(key);
            System.out.println(key + " is mapped to " + name);
        } else {
            System.out.println(key + " not mapped.");
        }

        // What if the key didn't map in the table???
        key = "55555";
        if (table.containsKey(key)) {
            name = (String) table.get(key);
            System.out.println(key + " is mapped to " + name);
        } else {
            System.out.println(key + " not mapped.");
        }

    }

    public static void testHashCodeOverride() {

        System.out.println("\nTesting Override hashCode() Method");
        System.out.println("==================================\n");


        HashPerson william = new HashPerson("Willy");
        HashPerson bill = new HashPerson("Willy");


        // What hashCode() returns
        System.out.println("Hash code for william  = " + william.hashCode());
        System.out.println("Hash code for bill     = " + bill.hashCode());


        // map key william to "Silly"
        HashMap table = new HashMap();
        table.put(william, "Silly");

        if (table.containsKey(william)) {
            System.out.println(table.get(william));
        } else {
            System.out.println("Key " + william + " not found");
        }


        // Now look for the same key
        if (table.containsKey(bill)) {
            System.out.println(table.get(bill));
        } else {
            System.out.println("Key " + bill + " not found");
        }
    }

    public static void testHashCodeEqualsOverride() {

        System.out.println("\nRunning hashCode() and equals() Override");
        System.out.println("========================================\n");

        Team a = new Team("Eagles", 6, 2);
        Team b = new Team("Eagles", 6, 2);

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        if (a.equals(b)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    public static void main(String[] args) {

        System.out.println("\nRunning several hashCode() implementations");
        System.out.println("==========================================\n");

        // Default hashCode() implementation
        Object someObject = new Object();
        System.out.println("Default hashCode() method        [Object]                 : " + someObject.hashCode());

        // Default hashCode() implementation
        HashCodeExample hce1 = new HashCodeExample();
        System.out.println("Default hashCode() method        [HashCodeExample]        : " + hce1.hashCode());

        // Default hashCode() implementation
        java.util.NoSuchElementException jay = new java.util.NoSuchElementException();
        System.out.println("Default hashCode() method        [NoSuchElementException] : " + jay.hashCode());

        // some objects choose to override hashCode()
        Integer one = new Integer(1);
        System.out.println("Classes that Override hashCode() [Integer]                : " + one.hashCode());

        // some overrides may even be negative
        java.awt.Color red = new java.awt.Color(0x44, 0x88, 0xcc);
        System.out.println("Negative Hash Codes              [Color]                  : " + red.hashCode());

        // Override the hashCode() method
        HashCodeExample2 hce2 = new HashCodeExample2();
        System.out.println("Override hashCode() method       [HashCodeExample2]       : " + hce2.hashCode());

        // Even if the default hashCode() method has been overridden in a class,
        // you can get the integer value to be returned by the default
        // hashCode() by using:   System.identityHashCode(hce2)
        System.out.println("Call default hashCode() method   [HashCodeExample2]       : " + System.identityHashCode(hce2));

        // A HashMap Example
        hashMapExample();

        // Testing Overriding the hashCode() method
        testHashCodeOverride();

        // Testing Overriding the hashCode() and equals() method
        testHashCodeEqualsOverride();

        System.out.println();

    }
}














/**
 * This class overrides the hashCode() method.
 */
class HashCodeExample2 {

    public int hashCode() {
        return 100;
    }
}

/**
 * This class overrides the hashCode() method. It also overrides equals().
 */
class HashPerson {

    private static final int HASH_PRIME = 1000003;

    public HashPerson(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    /**
     * This overrides equals() from java.lang.Object
     */
    public boolean equals(Object rhs) {
        // first determine if they are the same object reference
        if (this == rhs) {
            return true;
        }

        // make sure they are the same class
        if (rhs == null || rhs.getClass() != getClass()) {
            return false;
        }

        // ok, they are the same class. Cast rhs to HashPerson
        HashPerson other = (HashPerson) rhs;

        // our test for equality simply checks the name field
        if (!name.equals(other.name)) {
            return false;
        }

        // if we get this far, they are equal
        return true;
    }

    /**
     * Simple hashCode() implementation
     */
    public int hashCode() {

        int result = 0;
        result = HASH_PRIME * result + name.hashCode();
        return result;

    }
    private String name;
}





















class Team {

    private static final int HASH_PRIME = 1000003;
    private String name;
    private int wins;
    private int losses;

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, int wins, int losses) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
    }

    /**
     * this overrides equals() in java.lang.Object
     */
    public boolean equals(Object obj) {
        /**
         * return true if they are the same object
         */
        if (this == obj) {
            return true;
        }

        /**
         * the following two tests only need to be performed
         * if this class is directly derived from java.lang.Object
         */
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        // we know obj is of type Team
        Team other = (Team) obj;

        // now test all pertinent fields ...
        if (wins != other.wins || losses != other.losses) {
            return false;
        }

        if (!name.equals(other.name)) {
            return false;
        }

        // otherwise they are equal
        return true;
    }

    /**
     * This overrides hashCode() in java.lang.Object
     */
    public int hashCode() {
        int result = 0;

        result = HASH_PRIME * result + wins;
        result = HASH_PRIME * result + losses;
        result = HASH_PRIME * result + name.hashCode();

        return result;
    }
}

