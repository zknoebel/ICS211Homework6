
/**
 * @author Zachery Knoebel
 * 
 * This class creates a queue that is structured around a circular array
 */

import java.util.NoSuchElementException;

public class CircularArrayQueue<E> implements Queue211<E> {
	static int DEFAULT_SIZE = 10;
	private E[] data;
	private E temp;
	private int front = 0;
	private int end = 0;
	private int size = 0;

	/**
	 * creates CircularArrayQueue without arguments for the size of the queue
	 */
	@SuppressWarnings("unchecked")
	CircularArrayQueue() {
		data = (E[]) new Object[DEFAULT_SIZE];
	}

	/**
	 * creates CircularArrayQueue with an argument for size
	 * 
	 * @param queueSize
	 *            the queue will be the size of queueSize
	 */
	@SuppressWarnings("unchecked")
	CircularArrayQueue(int queueSize) {
		data = (E[]) new Object[queueSize];
	}

	/**
	 * adds an object to the end of the queue
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(Object e) {
		if (size >= data.length) {
			// The reallocate method should be uncommented if the add and offer
			// methods
			// are to grow when the queue gets full.
			// reallocate();
			throw new IllegalStateException();
		}
		data[end] = (E) e;
		end = (end + 1) % data.length;
		size++;

		return true;
	}

	/**
	 * returns the first element if there is no first element, throws exception
	 */
	@Override
	public E element() {
		if (size == 0) {
			throw new NoSuchElementException();
		} else {
			return data[front];
		}
	}

	/**
	 * if there is room in the queue, adds object e to the end
	 */
	@Override
	public boolean offer(Object e) {
		try {
			return add(e);
		} catch (IllegalStateException ise) {
			return false;
		}
	}

	/**
	 * returns the first element in the queue if there is no first element,
	 * returns null
	 */
	@Override
	public E peek() {
		try {
			return element();
		} catch (NoSuchElementException nsee) {
			return null;
		}
	}

	/**
	 * removes and returns first element if there is no first element returns
	 * null
	 */
	@Override
	public E poll() {
		try {
			return remove();
		} catch (NoSuchElementException nsee) {
			return null;
		}
	}

	/**
	 * removes and returns the first element if there is no first element,
	 * throws exception
	 */
	@Override
	public E remove() {
		if (size == 0) {
			throw new NoSuchElementException();
		} else {
			temp = data[front];
			front = (front + 1) % data.length;
			size--;
			return temp;
		}
	}

	/**
	 * returns the size of the queue
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * moves array objects to an array of double the size this is to be used in
	 * the add method so that when the queue becomes full, it will grow
	 * 
	 * because of the nature of the assignment, that this class is included
	 * with, the reallocate() method is not currently used, however it is
	 * written in the add method and can be used if it is uncommented
	 */
	@SuppressWarnings("unchecked")
	private void reallocate() {
		Object[] dataTemp = new Object[data.length * 2];
		for (int i = 0; i < size; i++) {
			dataTemp[i] = (data[front + i % data.length]);
		}
		data = (E[]) dataTemp;
		size = size * 2;
	}

}