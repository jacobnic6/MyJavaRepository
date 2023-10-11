
import javax.swing.JFrame;
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Sep 13, 2023  
*/
public class GameFrame extends JFrame{
	

	

	GameFrame(){
	
		
		GamePanel gamePanel = new GamePanel();
		gamePanel.setSize(800, 800);
		//gamePanel.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//gamePanel.setResizable(false);
		this.pack();
		gamePanel.setVisible(true);
		this.setLocationRelativeTo(null);
	
	}
		
	
}