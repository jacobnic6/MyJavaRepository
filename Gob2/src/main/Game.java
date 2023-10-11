package main;

import javax.swing.JFrame;
import input.MouseInput;
import input.MyKeyAdapter;
import scenes.End;
import scenes.GameScene;
import scenes.Menu;
import scenes.Playing;

/**
 * Nicholas Jacobs - ndjacobs2
 * 
 * CIS171 <11232> Oct 4, 2023
 */

//Main game class. Main is at the bottom
public class Game extends JFrame implements Runnable {
	private final int TICKS_PER_SEC = 10;
	private float position = 0.0f;
	private float speed = 2f;// per sec
	private boolean running = false;
	public int numOfGames = 0;
	private final int MILISEC = 1000;
	// Classes
	private GamePanel gamePanel;
	private static Thread gameThread;
	private Render render;
	private GameScene gameScene;
	private MyKeyAdapter myKey;
	private Menu menu;
	private Playing playing;
	private End end;

	// set our frame to the values we want and add our gamePanel into the JFrame
	Game() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		initClasses(this);
		add(gamePanel);
		setVisible(true);
		pack();
		initKey();
	}

	// initialize our classes and pass our game as a parameter
	private void initClasses(Game game) {
		render = new Render(game);
		gamePanel = new GamePanel(game);
		menu = new Menu(game);
		playing = new Playing(game);
		end = new End(game);

		// this.getBufferStrategy();
	}

	// create thread and start it
	private void start() {
		gameThread = new Thread(this);
		gameThread.start();
		running = true;
	}

	// initialize key adapter
	void initKey() {
		myKey = new MyKeyAdapter(this);
		addKeyListener(myKey);
		this.requestFocus();
	}

	/*
	 * update our gamestate with switch and validate() to ensure everything is in
	 * the right place
	 */
	private void updateGame() {
		switch (Gamestate.state) {

		case MENU:
			this.validate();
			break;
		case PLAYING:
			myKey.resetKey();
			this.validate();
			playing.update();
			break;
		case END:
			this.validate();
			break;
		}
	}

	// time since last call in seconds
	public void gameTick(float delta) {
		// update game elements
		position += speed * delta;
		System.out.println(speed * delta);

	}

	// thread run method for updating the game
	public void run() {
		long lastTick = System.currentTimeMillis();
		while (true) {
			try {
				Thread.sleep(MILISEC / TICKS_PER_SEC);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long deltaMilis = System.currentTimeMillis() - lastTick;

			// TODO: perform input
			updateGame();

			gameTick((float) deltaMilis / 50f);

			// TODO: render
			gamePanel.updateGamePanel();
			gamePanel.repaint();
			if (Gamestate.getState() != 2) {
				repaint();
			}
			lastTick += deltaMilis;

		}
	}

	// getters and setters
	public Render getRender() {
		return render;
	}

	public Menu getMenu() {
		return menu;
	}

	public Playing getPlaying() {
		return playing;
	}

	public End getEnd() {
		return end;
	}

	public float getSpeed() {
		return speed;
	}

	public MyKeyAdapter getMyKey() {
		return myKey;
	}

	public void setRunning(boolean a) {
		this.running = a;
	}

	// create our game and start our thread
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		game.start();
	}

}
