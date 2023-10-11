package main;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Graphics;

import javax.swing.JPanel;

import input.MouseInput;
import input.MyKeyAdapter;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 1, 2023
 */
public class GamePanel extends JPanel {

	private MouseInput mouseInput;
	MyKeyAdapter myKey;
	private Game game;
	public static final int SCREEN_WIDTH = 1200;
	public static final int SCREEN_HEIGHT = 1200;

	public GamePanel(Game game) {
		this.game = game;
		//double buffer our game panel since our images are moving
		this.setDoubleBuffered(true);
		setPanelSize();
		initMouse();
	}

	//initialize mouse listener for our button
	public void initMouse() {
		mouseInput = new MouseInput(this);
		addMouseListener(mouseInput);
		requestFocus();
	}

	//set panel to preferred size
	private void setPanelSize() {

		Dimension size = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT );
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
	}
	//update method calling repaint of our panel
	public void updateGamePanel() {

		repaint();

	}
	//get and paint our rendered classes
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.getRender().render(g);
	}
	//getter of game for our other classes
	public Game getGame() {
		return game;
	}

}
