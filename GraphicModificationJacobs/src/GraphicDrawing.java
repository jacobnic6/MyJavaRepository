import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 30, 2023  
*/
public class GraphicDrawing extends JComponent{

	Color graphicColor = Color.black;
	Color gapColor = Color.white;
	
	
	public void paintComponent(Graphics g) {
		
		
		g.setColor(graphicColor);
		g.fillOval(35, 35, 220, 220);
		
		g.setColor(gapColor);
		g.fillOval(50, 50, 190, 190);
		
		g.setColor(graphicColor);
		g.fillOval(65, 65, 160, 160);
		
		g.setColor(gapColor);
		g.fillOval(80, 80, 130, 130);
		
		g.setColor(graphicColor);
		g.fillOval(95, 95, 100, 100);
		
		g.setColor(gapColor);
		g.fillOval(110, 110, 70, 70);
		
		g.setColor(graphicColor);
		g.fillOval(125, 125, 40, 40);
	}
	
	public void generateRandomColor() {
		int r = (int)(Math.random()*256);
		int g = (int)(Math.random()*256);
		int b = (int)(Math.random()*256);
		graphicColor = new Color(r, g, b);
		repaint();
	}


}
