import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 30, 2023  
*/
public class GraphicPanel extends JPanel{
	
	GraphicDrawing drawing = new GraphicDrawing();
	
	public GraphicPanel() {
		JButton colorChangeButton = new JButton("Change");
		
		drawing.setPreferredSize(new Dimension(300, 300));
		buttonListener listener = new buttonListener();
		colorChangeButton.addActionListener(listener);
		
		add(drawing);
		add(colorChangeButton);
		
	}
	
	class buttonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			drawing.generateRandomColor();
		}
		
	}
}
