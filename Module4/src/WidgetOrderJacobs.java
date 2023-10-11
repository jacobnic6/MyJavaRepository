import java.util.Scanner;
import java.text.DecimalFormat;
/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Sep 6, 2023
 */

public class WidgetOrderJacobs {
	
	//declare constants static because they wont change
	public static final double PRICE_PER_WIDGET = 8.99;
	public static final double TAX_RATE = .065;
	public static final double SHIPPING_RATE = .20;
	
	public static double computeSubtotal(int numOfWidgets) {
		double widgetSubtotal= (double)numOfWidgets * PRICE_PER_WIDGET;
		return widgetSubtotal;
	}
	
	public static double taxPaid(double widgetSubtotal) {
		double taxPaid = widgetSubtotal * TAX_RATE;
		return taxPaid;
	}
	
	public static double shippingCost(int numOfWidgets) {
		double shippingCost = numOfWidgets * SHIPPING_RATE;
		return shippingCost;
	}
	
	
	public static double computeTotal(double widgetSubtotal, double shippingCost, double taxPaid) {
		double orderTotalCost = widgetSubtotal + taxPaid + shippingCost;
		return orderTotalCost;
	}
	
	public static void main(String[] args) {
		
		//create and use scanner to prompt user
		Scanner in =  new Scanner(System.in);
		System.out.print("Please enter the number of widgets purchased. \n(This should be a whole number between 0 and 100,000,000.): ");
		
		//create formats for data types
		DecimalFormat twoDecimals = new DecimalFormat("###,###,###.00");
		DecimalFormat noDecimals= new DecimalFormat("###,###,###");
		
		//declare and initialize variables. Call methods and store them in their respective variables.
		int numOfWidgets = in.nextInt();
		double widgetSubtotal = computeSubtotal(numOfWidgets);
		double taxPaid = taxPaid(widgetSubtotal);
		double shippingCost = shippingCost(numOfWidgets);
		double orderTotalCost = computeTotal(widgetSubtotal, shippingCost, taxPaid);
		
		//calculate output
		
		
		//display output to user
		System.out.println("Number of widgets purchased: " + noDecimals.format(numOfWidgets));
		System.out.println("Subtotal: $" + twoDecimals.format(widgetSubtotal));
		System.out.println("Tax: $" + twoDecimals.format(taxPaid));
		System.out.println("Shipping: $" + twoDecimals.format(shippingCost));
		System.out.println("Order Total: $" + twoDecimals.format(orderTotalCost));
		
		in.close();
	}

}
