package datastructure.queue;

import java.util.Arrays;

public class MyQueueArray<E> {

	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];

	public MyQueueArray() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	public void push(E e) {
		if (size == elements.length) {
			ensureCapa();
		}
		elements[size++] = e;
	}

	@SuppressWarnings("unchecked")
	public E pop() {
		int i = 0;
		E e = null;
		do {
			e = (E) elements[i];
			elements[i] = null;
			i++;

		} while (e == null);
		return e;
	}

	private void ensureCapa() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}
}
