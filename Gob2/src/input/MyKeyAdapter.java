package input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Game;
import main.Gamestate;
import scenes.Playing;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 1, 2023
 */
public class MyKeyAdapter implements KeyListener {
	char direction = 'R';
	private Game game;
	private Playing playing;

	// take game as input so our key adapter can communicate where to move our snake
	public MyKeyAdapter(Game game) {
		this.game = game;
	}

	// consume events other than pressed
	@Override
	public void keyTyped(KeyEvent e) {
		e.consume();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// if the gamestate is playing then we execute our switch
		if (Gamestate.getState() == 2) {
			switch (e.getKeyCode()) {

			// left arrow
			case KeyEvent.VK_LEFT:
				/*
				 * if statement ensuring that the snake isn't trying to go opposite way which
				 * would make it collide with self
				 */
				if (direction != 'R') {

					direction = 'L';
					Playing.setDirection(direction);
				}
				break;
			case KeyEvent.VK_RIGHT:
				/*
				 * if statement ensuring that the snake isn't trying to go opposite way which
				 * would make it collide with self
				 */
				if (direction != 'L') {
					direction = 'R';
					Playing.setDirection(direction);

				}
				break;
			case KeyEvent.VK_UP:
				/*
				 * if statement ensuring that the snake isn't trying to go opposite way which
				 * would make it collide with self
				 */
				if (direction != 'D') {
					direction = 'U';
					Playing.setDirection(direction);
				}
				break;
			case KeyEvent.VK_DOWN:
				/*
				 * if statement ensuring that the snake isn't trying to go opposite way which
				 * would make it collide with self
				 */
				if (direction != 'U') {
					direction = 'D';
					Playing.setDirection(direction);
				}
				break;
			}
		}
	}

	//ensures the the key adapter has focus when we are playing
	public void resetKey() {
		game.requestFocus();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		e.consume();
	}

}
