import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 30, 2023  
*/
public class ChartComponent extends JComponent{
	
	private ArrayList<Double> values;
	private double maxValue;
	
	public ChartComponent(double max) {
		values = new ArrayList<Double>();
		maxValue = max;
	}
	
	public void append(double value) {
		values.add(value);
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		final int GAP = 5;
		final int BAR_HEIGHT = 10;
		
		int y = GAP;
		for (Double value : values) {
			int barWidth = (int) (getWidth() * value / maxValue);
			g.fillRect(0, y, barWidth, BAR_HEIGHT);
			y = y + BAR_HEIGHT + GAP;
		}
		
	}

	/**
	 * @return the values
	 */
	public ArrayList<Double> getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(ArrayList<Double> values) {
		this.values = values;
	}

	/**
	 * @return the maxValue
	 */
	public double getMaxValue() {
		return maxValue;
	}

	/**
	 * @param maxValue the maxValue to set
	 */
	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}
}
