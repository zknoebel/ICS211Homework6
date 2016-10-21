
/**
 * 
 * @author Zachery Knoebel
 *
 *         This class creates a Shopper that holds a specific number of items
 */
public class Shopper {
	private int numItems;

	/**
	 * creates shopper
	 * 
	 * @param numberOfItems:
	 *            the number of items the shopper is created with
	 */
	Shopper(int numberOfItems) {
		numItems = numberOfItems;
	}

	/**
	 * creates a default shopper with 10 items
	 */
	Shopper() {
		numItems = 10;
	}

	/**
	 * @return: the number of items that the shopper has
	 */
	public int getNumItems() {
		return numItems;
	}
}