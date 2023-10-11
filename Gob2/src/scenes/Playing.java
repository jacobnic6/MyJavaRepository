package scenes;

import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;
import main.Game;
import main.Gamestate;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 4, 2023
 */
public class Playing extends GameScene implements SceneMethods {
	private Random random;
	int hotdogX;// location of hotdogs
	int hotdogY;
	int bodyParts = 5;
	public int hotdogsEaten = 0;

	int x[] = new int[GAME_UNITS];
	int y[] = new int[GAME_UNITS];
	public static final int UNIT_SIZE = 75;
	public static final int SCREEN_WIDTH = 1200;
	public static final int SCREEN_HEIGHT = 1200;
	public static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
	public static final int DELAY = 100;
	private String scoreMsg = "Score: ";

	private BufferedImage grassPic;
	private BufferedImage headPic;
	private BufferedImage hdPic;
	private BufferedImage bgPic;
	private BufferedImage hdBodyVert;
	private BufferedImage hdBodyHoriz;

	private static char direction = 'R';
	Timer timer;

	// playing method that takes our game as parameter so we can get our graphics to
	// render into our gamePanel
	public Playing(Game game) {
		super(game);

		random = new Random();
		initPlaying();
	}

	// method to reset our values
	public void resetValues() {

		direction = 'R';
		bodyParts = 5;
		hotdogsEaten = 0;
		this.x = new int[GAME_UNITS];
		this.y = new int[GAME_UNITS];
	}

	// method calling all our methods neccesary to initiate the scene
	public void initPlaying() {
		imgInit();
		newHotDog();
	}

	// update method calling our game loop.
	public void update() {
		gameLoop();
	}

	// method calling the methods that make our game playable
	public void gameLoop() {
		move();
		checkCollisions();
		checkHotDog();
	}

	// method called when we lose
	public void endGame() {
		resetValues();
		Gamestate.setState(3);
		System.out.println("Gameover");
	}

	// renders the scene
	@Override
	public void render(Graphics g) {
		/*
		 * unused currently, was going to use when I figure out affine tranformations a
		 * little more 
		 * Graphics2D g2 = (Graphics2D) g;
		 */

		// nested for loop drawing our grass tile img across the panel
		for (int yy = 0; yy < 16; yy++) {
			for (int xx = 0; xx < 16; xx++) {
				g.drawImage(grassPic, xx * UNIT_SIZE, yy * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE, null);
			}
		}

		// our middle image
		g.drawImage(bgPic, 300, 150, 600, 825, null);

		// hotdog drawn randomly with our random x and y coords
		g.drawImage(hdPic, hotdogX, hotdogY, UNIT_SIZE, UNIT_SIZE, null);

		// Drawing our score by setting our font preferences
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 40));
		FontMetrics metrics1 = g.getFontMetrics(g.getFont());
		g.drawString(scoreMsg + hotdogsEaten, (SCREEN_WIDTH - metrics1.stringWidth(scoreMsg + hotdogsEaten)) / 2,
				g.getFont().getSize());

		/*
		 * for loop that moves the snake uses final array for x and y values passing in
		 * i for the amount of body parts
		 */

		for (int i = 0; i < bodyParts; i++) {
			// head
			if (i == 0) {
				g.drawImage(headPic, x[i], y[i], UNIT_SIZE, UNIT_SIZE, null);
			} else {

				/*
				 * displays different horizontal or vertical images according to the direction
				 * of the snake.
				 */
				if (direction == 'R' || direction == 'L') {
					g.drawImage(hdBodyHoriz, x[i], y[i], UNIT_SIZE, UNIT_SIZE, null);
				} else {
					g.drawImage(hdBodyVert, x[i], y[i], UNIT_SIZE, UNIT_SIZE, null);
				}

			}
		}
		// if not playing dispose of the graphics
		if (Gamestate.getState() != 2) {
			g.dispose();
		}
	}

	// generates our new hotdog when our snake moves over the last one
	public void newHotDog() {
		getRndInt();
		hotdogX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
		hotdogY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
	}

	public void checkHotDog() {
		// examine coords of snake and hotDog to see if snake went over it
		if ((x[0] == hotdogX) && (y[0] == hotdogY)) {
			bodyParts++; // grow snake
			hotdogsEaten++; // keep score
			newHotDog(); // calls method to get a new hotDog
		}
	}

	public void move() {

		// for loop for all of the snake body parts
		for (int i = bodyParts; i > 0; i--) {
			x[i] = x[i - 1]; // taking array of body part coordinates and moving by 1
			y[i] = y[i - 1];

		}
		/*
		 * switch to change direction of snake uses index 0 as head and body follows
		 */
		switch (direction) {
		case 'U':
			y[0] = (y[0] - UNIT_SIZE);
			break;
		case 'D':
			y[0] = (y[0] + UNIT_SIZE);
			break;
		case 'L':
			x[0] = (x[0] - UNIT_SIZE);
			break;
		case 'R':
			x[0] = (x[0] + UNIT_SIZE);
			break;
		}
	}

	public void checkCollisions() {

		// see if snake collides with itself
		for (int i = bodyParts; i > 0; i--) {
			if ((x[0] == x[i]) && (y[0] == y[i])) // if true head collided with body
			{
				endGame();
			}
		}
		// check if head touches left border
		if (x[0] < 0) {
			endGame();
		}
		// check if head touches right border
		if (x[0] + UNIT_SIZE > SCREEN_WIDTH) {
			endGame();
		}
		// check if head touches top border
		if (y[0] < 0) {

			endGame();
		}

		// check if head touches bottom border
		if (y[0] + UNIT_SIZE > SCREEN_HEIGHT) {
			endGame();
		}
	}

	// used by our key adapter to change the direction
	public static void setDirection(char a) {
		direction = a;
	}

	// used by our key adapter to change the direction
	public char getDirection() {
		return direction;
	}

	private int getRndInt() {
		return random.nextInt();
	}

	// sets our variables the the buffered images returned by the getters
	private void imgInit() {
		this.grassPic = getGrassPic();
		this.bgPic = getBgPic();
		this.headPic = getHeadPic();
		this.hdPic = getHdPic();
		this.hdBodyVert = getHdBodyVert();
		this.hdBodyHoriz = getHdBodyHoriz();
	}

}
