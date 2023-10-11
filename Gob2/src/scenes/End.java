package scenes;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


import main.Game;
import main.Gamestate;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 4, 2023  
*/
public class End extends GameScene implements SceneMethods{
	

	private BufferedImage retryB;
	private BufferedImage bgPic;
	private final int UNIT_SIZE = 75;
	private final int SCREEN_WIDTH = 1200;
	private final int SCREEN_HEIGHT = 1200;
	private String scoreMsg = "Game Over";
	private BufferedImage  grassPic;

	public End(Game game) {
		super(game);
		initEnd();
	}

	//initiate our end scene which calls our method to get our images
	public void initEnd(){
		imgInit();
	}

	@Override
	public void render(Graphics g) {
		//nested for loop drawing our grass tile img across the panel
		for (int yy = 0; yy <16; yy++)
		{
			for (int xx = 0; xx <16; xx++)
			{
				
				
				g.drawImage(grassPic, xx * 75, yy * 75, 75, 75, null);
			}
		}
		//draw our images
		g.drawImage(bgPic, 300, 150,  600, 825,  null);
		
		g.drawImage(retryB,  487, 330,  225, 75,  null);
		
		
		
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		// font metrics for lining up text on center of screen
		FontMetrics metrics2 = g.getFontMetrics(g.getFont());// getting the metrics of our font
		g.drawString(scoreMsg, (SCREEN_WIDTH - metrics2.stringWidth(scoreMsg)) / 2, 300);// taking
		g.setColor(Color.red);
	
		//dispose of graphics if not end state
		if(Gamestate.getState() != 3) {
			g.dispose();
		}
		
		
	}
	
	//get our images and set our local variables to them
	private void imgInit() {
		this.grassPic = getGrassPic();
		this.bgPic = getBgPic();
		this.retryB = getRetryB();
	}





}
