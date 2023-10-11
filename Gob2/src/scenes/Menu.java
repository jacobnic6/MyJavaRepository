package scenes;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import main.Game;
import main.Gamestate;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 4, 2023
 */
public class Menu extends GameScene implements SceneMethods {
	private BufferedImage bgPic;
	private BufferedImage startB;
	private boolean sceneRunning = true;
	private Image grassPic;

	public Menu(Game game) {
		super(game);
		imgInit();
	}

	@Override
	public void render(Graphics g) {

		// nested for loop drawing our grass tile img across the panel
		for (int yy = 0; yy < 16; yy++) 
		{
			for (int xx = 0; xx < 16; xx++) 
			{
				g.drawImage(grassPic, xx * + UNIT_SIZE, yy * + UNIT_SIZE, + UNIT_SIZE, + UNIT_SIZE, null);
			}
		}

		// draw our middle image and our start button graphic
		g.drawImage(bgPic, 300, 150, 600, 825, null);
		g.drawImage(startB, 487, 330, 225, 75, null);
		// dispose of graphics if not menu gamestate
		if (Gamestate.getState() != 1) {
			g.dispose();
		}

	}

	// initialize our images
	private void imgInit() {
		this.grassPic = getGrassPic();
		this.bgPic = getBgPic();
		this.startB = getStartB();
	}

}
