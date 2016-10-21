public class CheckoutLanes {
	private CircularArrayQueue<Shopper>[] expressQueues;
	private CircularArrayQueue<Shopper>[] regularQueues;
	private int shortestRegularLane = -1;

	/**
	 * Checks to see if there is at least one regular line if not, throws
	 * exception then adds regular lanes and express lanes
	 * 
	 * @param numExpress
	 *            number of express lanes to be made
	 * @param numRegular
	 *            number of regular lanes to be made
	 */
	@SuppressWarnings("unchecked")
	public CheckoutLanes(int numExpress, int numRegular) {
		if (numRegular < 1) {
			throw new IllegalStateException();
		} else {
			expressQueues = new CircularArrayQueue[numExpress];
			regularQueues = new CircularArrayQueue[numRegular];
			for (int i = 0; i < numExpress; i++) {
				expressQueues[i] = new CircularArrayQueue<Shopper>();
			}
			for (int i = 0; i < numRegular; i++) {
				regularQueues[i] = new CircularArrayQueue<Shopper>();
			}
		}
	}

	/**
	 * adds a shopper to one of the lanes
	 * 
	 * @param laneNumber
	 *            the lane the shopper will go into
	 * @param shopper
	 *            the shopper to be added to the line
	 */
	public void enterLane(int laneNumber, Shopper shopper) {
		if (laneNumber < expressQueues.length) {
			expressQueues[laneNumber].add(shopper);
		} else {
			regularQueues[laneNumber - expressQueues.length].add(shopper);
		}
	}

	/**
	 * simulates the shoppers going through the lanes. if a shopper in the
	 * express lane has too many (over 10) items, then the shopper gets moved to
	 * the shortest regular lane
	 */
	public void simulateCheckout() {
		while (shoppersPresent()) {
			for (int i = 0; i < expressQueues.length; i++) {
				if (expressQueues[i].size() > 0) {
					while (((Shopper) expressQueues[i].peek()).getNumItems() > 10) {
						System.out.println(
								"Express lane shopper with " + ((Shopper) expressQueues[i].peek()).getNumItems()
										+ " items moved to lane " + (shortestRegularQueue() + expressQueues.length));
						regularQueues[shortestRegularLane].add((Shopper) expressQueues[i].remove());
					}
					if (((Shopper) expressQueues[i].peek()) != null) {
						System.out.println("Express lane " + i + ", shopper had "
								+ ((Shopper) expressQueues[i].poll()).getNumItems() + " items");
					}
				}
			}
			for (int i = 0; i < regularQueues.length; i++) {
				if (((Shopper) regularQueues[i].peek()) != null) {
					System.out.println("Regular lane " + (i + expressQueues.length) + ", shopper had "
							+ ((Shopper) regularQueues[i].poll()).getNumItems() + " items");
				}
			}
		}
	}

	/**
	 * determines whether or not a Shopper is in any of the queues
	 * 
	 * @return true if a shopper is in one of the queues return false if all
	 *         queues are empty
	 */
	private boolean shoppersPresent() {
		for (int i = 0; i < expressQueues.length; i++) {
			if (expressQueues[i].size() > 0) {
				return true;
			}
		}
		for (int i = 0; i < regularQueues.length; i++) {
			if (regularQueues[i].size() > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * checks to see which expressQueue is the shortest
	 * 
	 * @return the number of the shortest expressQueue
	 * 
	 *         not currently used
	 */
//	private int shortestExpressQueue() {
//		int min = 0;
//		for (int i = 1; i < expressQueues.length; i++) {
//			if (((CircularArrayQueue<Shopper>) expressQueues[min])
//					.size() > ((CircularArrayQueue<Shopper>) expressQueues[i]).size()) {
//				min = i;
//			}
//		}
//		return min;
//	}

	/**
	 * checks to see which regularQueue is the shortest
	 * 
	 * @return the number of the shortest regularQueue
	 */
	private int shortestRegularQueue() {
		shortestRegularLane = 0;
		for (int i = 1; i < regularQueues.length; i++) {
			if (((CircularArrayQueue<Shopper>) regularQueues[shortestRegularLane])
					.size() > ((CircularArrayQueue<Shopper>) regularQueues[i]).size()) {
				shortestRegularLane = i;
			}
		}
		return shortestRegularLane;
	}
}