package model;

import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Nov 30, 2023
 */
public class Blanket {
	private String size;
	private String color;
	private String material;
	protected double price;
	private static ArrayList<Blanket> blanketArray = new ArrayList<Blanket>();

	//no arg default const
	public Blanket() {
		this.price = 25;
		this.size = "twin";
		this.color = "blue";
		this.material = "wool";
		blanketArray.add(this);

	}

	/**
	 * @param size
	 * @param color
	 * @param material
	 */
	public Blanket(String size, String color, String material) {
		this.price = 25;
		setSize(size);
		setColor(color);
		setMaterial(material);
		blanketArray.add(this);
	}
	
	//method to find blankets in our static ArrayList less than a certain amount
	public String getLessthan(int a) {
		String blanketsLessThan = "-----Blankets under $" + a +"-----\n";
		for (Blanket blanket : blanketArray) {
			if (blanket.getPrice() < a) {
				blanketsLessThan += blanket.featureReport() +"\n";
			}
		}
		return blanketsLessThan;
	}

	//method to return our formatted description of the blanket
	public String featureReport() {
		DecimalFormat priceFormat = new DecimalFormat("$#.00");
		return "" + getColor() + " " + getSize() + " blanket made from " + getMaterial() + ", total price: "
				+ priceFormat.format(getPrice());
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {

		try {
			if (size.equalsIgnoreCase("twin")) {
				this.size = size;
			} else if (size.equalsIgnoreCase("queen")) {
				this.size = size;
				this.price += 25;
			} else if (size.equalsIgnoreCase("king")) {
				this.size = size;
				this.price += 40;
			} else {
				throw new IllegalArgumentException("Must be a size of twin, queen, or king.");
			}

		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * @param material the material to set
	 */
	public void setMaterial(String material) {

		this.material = material;
		if (material.equalsIgnoreCase("wool")) {
			this.price += 20;

		} else if (material.equalsIgnoreCase("chenille")) {
			this.price += 30;

		} else if (material.equalsIgnoreCase("cashmere")) {
			this.price += 45;
		}
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
}
