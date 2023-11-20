/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 19, 2023
*/

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.CurrencyPanel;

/**
 * 
 */
public class StartProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new CurrencyPanel();
		
		frame.add(panel);
		
		frame.setSize(250, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}

}
