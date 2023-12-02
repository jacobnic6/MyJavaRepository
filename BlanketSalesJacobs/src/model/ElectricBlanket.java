package model;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Dec 1, 2023
 */
public class ElectricBlanket extends Blanket {
	private int numOfHeatSettings;
	private boolean hasAutoShutOff;

	//default no arg const that calls to superClass
	public ElectricBlanket() {
		// TODO Auto-generated constructor stub
		super();
		this.numOfHeatSettings = 1;
		this.hasAutoShutOff = false;
	}

	//non Default const
	/**
	 * @param numOfHeatSettings
	 * @param hasAutoShutOff
	 */
	public ElectricBlanket(String size, String color, String material, int numOfHeatSettings, boolean hasAutoShutOff) {
		super(size, color, material);
		setNumOfHeatSettings(numOfHeatSettings);
		setHasAutoShutOff(hasAutoShutOff);
	}

	//overridden feature report so we can return our report with the added settings
	@Override
	public String featureReport() {
		String report = super.featureReport() + " including ";
		if (getNumOfHeatSettings() == 1) {
			if (getHasAutoShutOff()) {
				report += getNumOfHeatSettings() + " setting" + " with auto shut off";
			} else {
				report += getNumOfHeatSettings() + " setting" + " without auto shut off";
			}
		} else {
			if (getHasAutoShutOff()) {
				report += getNumOfHeatSettings() + " settings" + " with auto shut off";
			} else {
				report += getNumOfHeatSettings() + " settings" + " without auto shut off";
			}
		}
		return report;
	}

	/**
	 * @return the numOfHeatSettings
	 */
	public int getNumOfHeatSettings() {
		return numOfHeatSettings;
	}

	/**
	 * @param numOfHeatSettings the numOfHeatSettings to set
	 */
	public void setNumOfHeatSettings(int numOfHeatSettings) {
		if (numOfHeatSettings < 1 || numOfHeatSettings > 5) {
			this.numOfHeatSettings = 1;
		} else {
			this.numOfHeatSettings = numOfHeatSettings;
		}

	}

	/**
	 * @return the hasAutoShutOff
	 */
	public boolean getHasAutoShutOff() {
		return hasAutoShutOff;
	}

	/**
	 * @param hasAutoShutOff the hasAutoShutOff to set
	 */
	public void setHasAutoShutOff(boolean hasAutoShutOff) {
		if (hasAutoShutOff == true) {
			this.hasAutoShutOff = hasAutoShutOff;
			super.price += 5.75;
		} else {
			this.hasAutoShutOff = hasAutoShutOff;
		}

	}

}
