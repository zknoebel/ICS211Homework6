public class CheckoutLanes {
	private CircularArrayQueue<Shopper>[] expressQueues;
	private CircularArrayQueue<Shopper>[] regularQueues;
	private int shortestRegularLane = -1;

	public CheckoutLanes(int numExpress, int numRegular) {
		if (numRegular < 1) {
			throw new IllegalStateException();
		} else {
			expressQueues = new CircularArrayQueue[numExpress];
			regularQueues = new CircularArrayQueue[numRegular];
			for (int i = 0; i < numExpress; i++) {
				expressQueues[i] = new CircularArrayQueue();
			}
			for (int i = 0; i < numRegular; i++) {
				regularQueues[i] = new CircularArrayQueue();
			}
		}
	}

	public void enterLane(int laneNumber, Shopper shopper) {
		if (laneNumber < expressQueues.length) {
			expressQueues[laneNumber].add(shopper);
		} else {
			regularQueues[laneNumber - expressQueues.length].add(shopper);
		}
	}

	public void simulateCheckout() {
		while (shoppersPresent()) {
			for (int i = 0; i < expressQueues.length; i++) {
				if (expressQueues[i].size() > 0) {
					while (((Shopper) expressQueues[i].peek()).getNumItems() > 10) {
						System.out.println(
								"Express lane shopper with " + ((Shopper) expressQueues[i].peek()).getNumItems()
										+ " items moved to lane " + shortestRegularQueue());
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

	private int shortestExpressQueue() {
		int min = 0;
		for (int i = 1; i < expressQueues.length; i++) {
			if (((CircularArrayQueue<Shopper>) expressQueues[min])
					.size() > ((CircularArrayQueue<Shopper>) expressQueues[i]).size()) {
				min = i;
			}
		}
		return min;
	}

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