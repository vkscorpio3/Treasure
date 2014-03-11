package datastructure.queue;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import datastructure.stack.MyStackArray;
import datastructure.stack.MyStackList;

public class MyQueueTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testStackArray() {
		MyQueueArray<Integer> stack = new MyQueueArray<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(3);
		stack.push(4);
		
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
