package main;

import java.awt.Graphics;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 4, 2023
 */

//Render class that renders our game scenes
public class Render {
	private Game game;

	public Render(Game game) {
		this.game = game;
	}

	public void updateRender() {
		game.repaint();
	}

	public void render(Graphics g) {

		// switch checking the gamestate and renders the scene accordingly
		switch (Gamestate.state) {

		case MENU:
			game.getMenu().render(g);
			game.validate();
			break;

		case PLAYING:
			game.getPlaying().render(g);
			game.validate();
			game.repaint();
			break;

		case END:
			game.getEnd().render(g);
			game.validate();
			game.repaint();
			break;
		}
	}

}
