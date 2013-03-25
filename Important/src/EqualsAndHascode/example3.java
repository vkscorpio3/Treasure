/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EqualsAndHascode;

/**
 *
 * @author ganesan
 */
public class example3 {

    public static void main(String args[]) {
        
        Person admin1 = new Person("Admin", "r035198x", 2);
        Person admin2 = new Person("Admin", "r035198x", 2);
        System.out.println(admin1.equals(admin2));
    }
}

class Person {

    String title;
    String fullName;
    int age;

    public Person(String title, String fullName, int age) {
        this.title = title;
        this.fullName = fullName;
        this.age = age;
    }

    String getFullName() {
        return fullName;
    }

    int getAge() {
        return age;
    }

    String getTitle() {
        return title;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        return age == person.getAge() && fullName.equals(person.getFullName()) && title.equals(person.getTitle());

    }
}