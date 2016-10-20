/**
 * 
 * Main
 *
 * @author Zachery Knoebel
 *This class is the test class for CircularArrayQueue and CheckoutLanes
 */
public class Main {
	public static void main(String[] args) {
		CheckoutLanes checkout = new CheckoutLanes(1, 2);
		checkout.enterLane(0, new Shopper(15));
		checkout.enterLane(0, new Shopper(3));
		checkout.enterLane(1, new Shopper(20));
		checkout.enterLane(2, new Shopper(17));
		checkout.simulateCheckout();

		checkout = new CheckoutLanes(10,40);
		for(int i = 0; i < 10; i ++){
			for(int j = 0; j < 10; j ++){
				checkout.enterLane(i, new Shopper((i * j * 3)%13));
			}
		}
		for(int i = 0; i < 40; i ++){
			for( int j = 0; j < 10; j ++){
				checkout.enterLane(i + 10, new Shopper(j));
			}
		}
		checkout.simulateCheckout();
	}
}
