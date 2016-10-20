import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Test;

public class CircularArrayQueueTest {
	final static int Q_SIZE = 10;

	@Test
	public void testEmpty() {
		Queue211<Integer> q = new CircularArrayQueue<>(Q_SIZE);

		assertEquals(0, q.size());
		assertEquals(null, q.peek());

		try {
			q.element();
			fail("Should have thrown exception");
		} catch (NoSuchElementException e) {
		}

		try {
			q.remove();
			fail("Should have thrown exception");
		} catch (NoSuchElementException e) {
		}
	}

	@Test
	public void testAddOffer() {
		CircularArrayQueue<Integer> q = new CircularArrayQueue<>(Q_SIZE);
		int i = 0;

		while (q.offer(i)) {
			i++;
		}

		assertEquals(Q_SIZE, i);
		assertEquals(Q_SIZE, q.size());

		try {
			q.add(13);
			fail("Shouldn't get here; add() should have thrown exception.");
		} catch (IllegalStateException e) {
		}
	}

	@Test
	public void testPollRemove() {
		/*
		 * 1. Populate queue 2. Check to make sure element, peek, remove, and
		 * poll all return items in FIFO order. 3. Test to make sure all items
		 * can be removed (i.e., you can empty the queue) and all methods return
		 * correct result or generate correct exception. 4. Test that the size()
		 * returns the correct values.
		 */

		Queue211<Integer> q = new CircularArrayQueue<>(Q_SIZE);
		for (int i = 0; i < Q_SIZE; i++) {
			q.add(i * 2);
		}
		assertEquals(10, q.size());
		assertEquals(new Integer(0), q.element());
		assertEquals(new Integer(0), q.peek());
		assertEquals(new Integer(0), q.remove());
		for (int i = 1; i < Q_SIZE; i++) {
			assertEquals(new Integer(i * 2), q.poll());
		}
		try {
			q.remove();
			fail("Should have thrown exception");
		} catch (NoSuchElementException nsee) {
			assertEquals(null, q.poll());
		}
	}

	@Test
	public void testPeekElement() {
		CircularArrayQueue<Integer> q = new CircularArrayQueue<>(Q_SIZE);
		/*
		 * Setup code...
		 */

		q.add(42);

		/*
		 * Add some more elements...
		 */
		q.add(34);
		q.add(0);
		q.add(23);
		// Make sure the head of the queue is the first element added.
		assertEquals(new Integer(42), q.peek());

		/*
		 * Make sure size() still returns correct result
		 */
		assertEquals(4, q.size());
	}

	@Test
	public void testWrapAround() {
		CircularArrayQueue<Integer> q = new CircularArrayQueue<>(Q_SIZE);
		int i = 0;
		/*
		 * Make sure the circular queue can handle wrapping around to beginning
		 * of array. Pseudo code:
		 */
		while (q.offer(i)) {
			i++;
		}

		assertEquals(new Integer(0), q.remove()); // Should check that item
													// returned is correct.
		q.add(99); // This should
		for (int j = 1; j < Q_SIZE; j++) {
			q.remove();
		}
		assertEquals(new Integer(99), q.poll());
	}
}