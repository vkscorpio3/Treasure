/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chaining;

/**
 *
 * @author ganesan
 */
public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
        System.out.println("I'm executed first.");
    }

    public static void main(String h[]) {
        Carnivore c= new Carnivore("ganesans");
    }
}

class Mammal extends Animal {

    public Mammal(String name) {
        super(name);
        System.out.println("I'm executed second");
    }
}

class Carnivore extends Mammal {

    public Carnivore(String name) {
        super(name);
        System.out.println("I'm executed last");
    }
}
