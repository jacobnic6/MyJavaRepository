
/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Sep 6, 2023
 */
public class WidgetOrderJacobs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numOfWidgets = 5;
		final double PRICE_PER_WIDGET = 8.99;
		final double TAX_RATE = .065;
		final double SHIPPING_RATE = .20;
		double widgetSubtotal = (double) numOfWidgets * PRICE_PER_WIDGET;
		double taxPaid = widgetSubtotal * TAX_RATE;
		double shippingCost = numOfWidgets * SHIPPING_RATE;
		double orderTotalCost = widgetSubtotal + taxPaid + shippingCost;
		System.out.println("Number of widgets purchased: " + numOfWidgets);
		System.out.println("Subtotal: " + widgetSubtotal);
		System.out.println("Tax: " + taxPaid);
		System.out.println("Shipping: " + shippingCost);
		System.out.println("Order Total: " + orderTotalCost);
	}

}
