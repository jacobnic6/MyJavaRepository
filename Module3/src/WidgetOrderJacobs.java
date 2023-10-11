import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Sep 6, 2023
 */

public class WidgetOrderJacobs {

	public static void main(String[] args) {
		
		//create and use scanner to prompt user
		Scanner in =  new Scanner(System.in);
		System.out.print("Please enter the number of widgets purchased. \n(This should be a whole number between 0 and 100,000,000.): ");
		
		//create formats for data types
		DecimalFormat twoDecimals = new DecimalFormat("###,###,###.00");
		DecimalFormat noDecimals= new DecimalFormat("###,###,###");
		
		//declare and initialize variables
		int numOfWidgets = in.nextInt();
		final double PRICE_PER_WIDGET = 8.99;
		final double TAX_RATE = .065;
		final double SHIPPING_RATE = .20;
		
		//calculate output
		double widgetSubtotal = (double)numOfWidgets * PRICE_PER_WIDGET;
		double taxPaid = widgetSubtotal * TAX_RATE;
		double shippingCost = numOfWidgets * SHIPPING_RATE;
		double orderTotalCost = widgetSubtotal + taxPaid + shippingCost;
		
		//display output to user
		System.out.println("Number of widgets purchased: " + noDecimals.format(numOfWidgets));
		System.out.println("Subtotal: $" + twoDecimals.format(orderTotalCost));
		System.out.println("Tax: $" + twoDecimals.format(taxPaid));
		System.out.println("Shipping: $" + twoDecimals.format(shippingCost));
		System.out.println("Order Total: $" + twoDecimals.format(orderTotalCost));
		
		in.close();
	}

}
