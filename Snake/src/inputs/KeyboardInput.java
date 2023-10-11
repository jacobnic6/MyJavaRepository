package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 1, 2023  
*/
public class KeyboardInput implements KeyListener{

	char direction = 'R';
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) 
		{
			case KeyEvent.VK_LEFT:
				if (direction != 'R') 
				{
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (direction != 'L') 
				{
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if (direction != 'D') 
				{
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if (direction != 'U') 
				{
					direction = 'D';
				}
				break;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
