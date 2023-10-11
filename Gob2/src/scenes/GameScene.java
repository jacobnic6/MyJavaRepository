package scenes;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import main.Game;
import main.Render;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 4, 2023
 */

//class we use to load all of the images and get them for our scenes
public class GameScene {

	public static final int UNIT_SIZE = 75;
	private BufferedImage headPic;
	private BufferedImage hdPic;
	private BufferedImage bgPic;
	private BufferedImage grassPic;
	private BufferedImage startB;
	private BufferedImage img;
	private Game game;
	private BufferedImage retryB;
	private BufferedImage hdBodyVert;
	private BufferedImage hdBodyHoriz;

	public GameScene(Game game) {
		this.game = game;

		importImg();
		loadAnimations();
	}

	/*
	 * gets subimages from our image file and sets them to local variable
	 * accordingly
	 */
	private void loadAnimations() {
		bgPic = getImg().getSubimage(0, 0, 600, 825);
		startB = getImg().getSubimage(75, 900, 225, UNIT_SIZE);
		retryB = getImg().getSubimage(300, 900, 225, UNIT_SIZE);

		headPic = getImg().getSubimage(300, 825, UNIT_SIZE, UNIT_SIZE);
		hdPic = getImg().getSubimage(375, 825, UNIT_SIZE, UNIT_SIZE);

		grassPic = getImg().getSubimage(450, 825, UNIT_SIZE, UNIT_SIZE);
		hdBodyHoriz = getImg().getSubimage(150, 825, UNIT_SIZE, UNIT_SIZE);
		hdBodyVert = getImg().getSubimage(0, 900, UNIT_SIZE, UNIT_SIZE);

	}

	/*
	 * imports our image. Initially i used input stream but using URL ended up being
	 * faster
	 */
	public void importImg() 
	{

		URL imgUrl = getClass().getResource("/gamepics.png");

		if (imgUrl == null) 
		{
			System.err.println("Couldn't find file");
		}

		else 
		{
			try 
			{

				img = ImageIO.read(imgUrl);
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

	}

//getter methods
	public BufferedImage getImg() {
		return img;
	}

	public BufferedImage getRetryB() {
		return retryB;
	}

	public BufferedImage getHeadPic() {
		return headPic;
	}

	public BufferedImage getHdPic() {
		return hdPic;
	}

	public BufferedImage getHdBodyVert() {
		return hdBodyVert;
	}

	public BufferedImage getBgPic() {
		return bgPic;
	}

	public BufferedImage getGrassPic() {
		return grassPic;
	}

	public BufferedImage getStartB() {
		return startB;
	}

	public BufferedImage getHdBodyHoriz() {
		return hdBodyHoriz;
	}

	public Game getGame() {
		return game;
	}

}
