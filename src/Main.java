
public class Main {
	public static void main(String[] args) {
		CheckoutLanes checkout = new CheckoutLanes(1, 2);
		checkout.enterLane(0, new Shopper(15));
		checkout.enterLane(0, new Shopper(3));
		checkout.enterLane(1, new Shopper(20));
		checkout.enterLane(2, new Shopper(17));
		checkout.simulateCheckout();
	}
}
