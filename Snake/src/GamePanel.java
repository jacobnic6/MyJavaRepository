import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import inputs.KeyboardInput;

import java.util.Random;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Sep 13, 2023
 */
public class GamePanel extends JPanel implements Runnable, ActionListener {

	static final int UNIT_SIZE = 75;
	// game screen and how fast snake goes
	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 800;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
	final int tileSize = 75;
	final int maxScreenCol = 16;
	final int maxScreenRow = 16;

	static final int DELAY = 100;
	// Arrays for coordinates of bodyparts and head of snake
	final int x[] = new int[GAME_UNITS];// x coords
	final int y[] = new int[GAME_UNITS];// y coords
	int snakeSpeed = 4;
	ImageIcon hotdog = new ImageIcon(getClass().getClassLoader().getResource("hotDog.png"));
	ImageIcon hdSmall = new ImageIcon(hotdog.getImage().getScaledInstance(UNIT_SIZE, UNIT_SIZE, Image.SCALE_SMOOTH));
	ImageIcon sherm = new ImageIcon(getClass().getClassLoader().getResource("sherm.png"));
	ImageIcon shermBG1 = new ImageIcon(getClass().getClassLoader().getResource("shermBG.png"));;
	ImageIcon shermBG = new ImageIcon(shermBG1.getImage().getScaledInstance(800, 800, Image.SCALE_SMOOTH));
	int bodyParts = 4; // bodyparts snake starts with
	int applesEaten;
	int appleX;// location of apples
	int appleY;
	// starting Direction
	boolean running = false;
	// JButton startButton;
	Timer timer;
	Random random;
	Thread gameThread;
	
	JButton button = new JButton();
	// Label start = new Label("Start");
	// Image smallHD = hotdog.getScaledInstance(UNIT_SIZE , UNIT_SIZE ,
	// Image.SCALE_SMOOTH);
	int FPS = 60;
	public int gameState;
	public final int menuState = 1;
	public final int runState = 2;
	public final int endState = 3;
	char direction = 'R';

	GamePanel() {
		// GamePanel gamePanel = new GamePanel();
		setupGame();
		startGameThread();

		random = new Random();
		this.setLocation(100,0);
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		//this.setDoubleBuffered(true);
		this.addKeyListener(new KeyboardInput());
		this.setFocusable(true);
		
		this.add(button);
		button.setText("Start");
		button.addActionListener(this);
		// button.setActionCommand(getName());
		button.setVisible(true);
		button.setFocusable(false);
		System.out.println(button.getActionListeners());
		System.out.println(this.getKeyListeners());

		// call start after game has been constructed
	}

	public void buttonGone() {
		button.setVisible(false);
	}

	public void buttonhere() {
		button.setVisible(true);
		
	}

	public int GetState() {
		if (gameState == 1) {
			return menuState;
			
		}

		else if (gameState == 2) {

			return runState;
		}

		else {
			gameState = 3;
			return endState;

		}
	}

	public void SetState(int a) {
		switch (a) {
		case 1:
			gameState = menuState;
			
			buttonhere();
			System.out.println(gameThread.isAlive());
			break;

		case 2:
			gameState = runState;
			running = true;

			GameLoop();
			repaint();
			buttonGone();
			newApple();
			break;
		case 3:
			gameState = endState;
			buttonhere();
			System.out.println(gameThread.isAlive()); 
			break;

		}
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	

	public void setupGame() {
		gameState = 1;

	}

	public void resetGame(){
		bodyParts = 4; // bodyparts snake starts with
		applesEaten = 0;
		appleX=100;// location of apples
		appleY=100;
		// starting Direction
		// JButton startButton;
		random=new Random();
		direction = 'R';
		
	}

	private void GameLoop() {

		if (gameState == 2) {
			running = true;
			move();
			checkApple();
			checkCollisions();
		}

		else {
			if (gameState == 1) {
				
			} else if (gameState == 3) {
				running = false;
			}
		}
	}

	public void run() {
			
		double drawInterval = 1000000000 / 15; // 0.01666 seconds
		double nexDrawTime = System.nanoTime() + drawInterval;
		while (gameThread != null) {

			GameLoop();
			repaint();

			try {
				double remainingTime = nexDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;
				if (remainingTime < 0) {
					remainingTime = 0;
				}

				Thread.sleep((long) remainingTime);

				nexDrawTime += drawInterval;

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void paintComponent(Graphics g) 
	{
		// switch and draw your game
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		if (gameState == 1) 
		{// set up game state
			shermBG.paintIcon(this, g2, (0), 0);
			
		} 
		else if (gameState == 2) 
		{
			shermBG.paintIcon(this, g2, (0), 0);
			hdSmall.paintIcon(this, g2, (appleX), appleY);
			g.setColor(Color.red);
			g.setFont(new Font("Ink Free", Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2,
					g.getFont().getSize());
			g2.fillOval(appleX, appleY, 0, 0);

			ImageIcon shermSmall = new ImageIcon(
					sherm.getImage().getScaledInstance(UNIT_SIZE, UNIT_SIZE, Image.SCALE_SMOOTH));
			for (int i = 0; i < bodyParts; i++) {
				if (i == 0) 
				{
					shermSmall.paintIcon(this, g2, x[i], y[i]);
				} 
				else 
				{
					g2.setColor(new Color(246, 127, 123));// paints body of snake
					g2.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}

		} 
		else if (gameState == 3) 
		{
			super.paintComponent(g2);
			shermBG.paintIcon(this, g2, (0), 0);
			g2.setColor(Color.red);
			g2.setFont(new Font("Ink Free", Font.BOLD, 75));
			// font metrics for lining up text on center of screen
			FontMetrics metrics = getFontMetrics(g2.getFont());// getting the metrics of our font
			g2.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 3);// taking
			g2.setColor(Color.red);
			g2.setFont(new Font("Ink Free", Font.BOLD, 40));
			// font metrics for lining up text on center of screen
			FontMetrics metrics2 = getFontMetrics(g2.getFont());// getting the metrics of our font
			g2.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics2.stringWidth("Score: " + applesEaten)) / 2,
					g2.getFont().getSize());// taking metrics from above subtracted
		}

	}

	public void newApple() {
		appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
		appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

	}

	public void move() {

		// for loop for all of the snake body parts
		for (int i = bodyParts; i > 0; i--) {
			x[i] = x[i - 1]; // taking array of body part coordinates and moving by 1
			y[i] = y[i - 1];

		}
		// switch to change direction of snake
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

	public void checkApple() {
		// examine coords of snake and apple to see if snake went over it
		if ((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++; // grow snake
			applesEaten++; // keep score
			newApple(); // calls method to get a new apple
		}
	}

	public void checkCollisions() {

		// see if snake collides with itself
		for (int i = bodyParts; i > 0; i--) {
			if ((x[0] == x[i]) && (y[0] == y[i])) {// if true head collided with body
				running = false;
				SetState(3);
			}
		}
		// check if head touches left border
		if (x[0] < 0) {
			running = false;
			SetState(3);
		}
		// check if head touches right border
		if (x[0] > SCREEN_WIDTH) {
			running = false;
			SetState(3);
		}
		// check if head touches top border
		if (y[0] < 0) {
			running = false;
			SetState(3);
		}

		// check if head touches bottom border
		if (y[0] > SCREEN_HEIGHT) {
			running = false;
			SetState(3);
		}
	}	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
		if (running == true) {
			GameLoop();
		} else if (running == false && gameState== menuState) {

			SetState(2);

			// repaint();

			System.out.println(GetState());
			// System.out.println(SetState(2));
		} else if (gameState == endState && e.getActionCommand().equals("Start")) {
			
			setupGame();
			resetGame();
			
			
			
		}

	}

}
