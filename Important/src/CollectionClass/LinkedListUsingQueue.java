/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionClass;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author ganesan
 */
public class LinkedListUsingQueue {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        queue.offer("Fourth");

        System.out.println("Size: " + queue.size());

        System.out.println("Queue head using peek   : " + queue.peek());
        System.out.println("Queue head using element: " + queue.element());

        Object data;
        while ((data = queue.poll()) != null) {
            System.out.println(data);
        }
    }
}
