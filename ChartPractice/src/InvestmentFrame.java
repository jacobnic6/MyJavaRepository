import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 30, 2023  
*/
public class InvestmentFrame extends JFrame{
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 400;
	
	private static final int CHART_WIDTH = 300;
	private static final int CHART_HEIGHT = 300;
	
	private static final double DEFAULT_RATE = 5;
	private static final double INITIAL_BALANCE = 1000;
	
	private JLabel rateLabel;
	private JTextField rateField;
	private JButton button;
	private ChartComponent chart;
	private double balance;
	
	public InvestmentFrame() {
		balance = INITIAL_BALANCE;
		chart = new ChartComponent(3 * INITIAL_BALANCE);
		chart.setPreferredSize(new Dimension(CHART_WIDTH, CHART_HEIGHT));
		chart.append(INITIAL_BALANCE);
		
		createTextField();
		createButton();
		createPanel();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	class AddInterestListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			double rate = Double.parseDouble(rateField.getText());
			double interest = balance * rate / 100;
			balance = balance + interest;
			chart.append(balance);
		}
		
	}

	private void createPanel() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		panel.add(rateLabel);
		panel.add(rateField);
		panel.add(button);
		panel.add(chart);
		add(panel);
	}

	private void createButton() {
		// TODO Auto-generated method stub
		button = new JButton("Add Interest");
		
		ActionListener listener = new AddInterestListener();
		button.addActionListener(listener);
	}

	private void createTextField() {
		// TODO Auto-generated method stub
		rateLabel = new JLabel("Interest Rate: ");
		
		final int FIELD_WIDTH = 10;
		rateField = new JTextField(FIELD_WIDTH);
		rateField.setText("" + DEFAULT_RATE);
	}

	/**
	 * @return the rateLabel
	 */
	public JLabel getRateLabel() {
		return rateLabel;
	}

	/**
	 * @param rateLabel the rateLabel to set
	 */
	public void setRateLabel(JLabel rateLabel) {
		this.rateLabel = rateLabel;
	}

	/**
	 * @return the rateField
	 */
	public JTextField getRateField() {
		return rateField;
	}

	/**
	 * @param rateField the rateField to set
	 */
	public void setRateField(JTextField rateField) {
		this.rateField = rateField;
	}

	/**
	 * @return the button
	 */
	public JButton getButton() {
		return button;
	}

	/**
	 * @param button the button to set
	 */
	public void setButton(JButton button) {
		this.button = button;
	}

	/**
	 * @return the chart
	 */
	public ChartComponent getChart() {
		return chart;
	}

	/**
	 * @param chart the chart to set
	 */
	public void setChart(ChartComponent chart) {
		this.chart = chart;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
}

