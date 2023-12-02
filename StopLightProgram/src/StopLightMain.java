import javax.swing.JFrame;
import javax.swing.JPanel;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 30, 2023  
*/
public class StopLightMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		
		JPanel panel = new StopLightPanel();
		
		frame.add(panel);
		frame.setSize(250, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
