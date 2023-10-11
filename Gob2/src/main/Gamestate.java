package main;

import scenes.*;
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 1, 2023  
*/
public enum Gamestate {
	MENU, PLAYING, END;
	//gamestate class so game knows what to render with get and set methods
	public static Gamestate state = MENU;
	public static void setState(int a) {
		switch (a) {
		case 1:
			state = MENU;
			
			break;
		case 2:
			state = PLAYING;
			break;
		case 3:
			state = END;
			break;
		}
	}
	public static int getState() {
		int a = 0;
		switch (state) {
		case MENU:
			a=1;
			
			break;
		case PLAYING:
			a=2;
			break;
		case END:
			a=3;
			break;
		
	}
		return a;
	}
		
}
