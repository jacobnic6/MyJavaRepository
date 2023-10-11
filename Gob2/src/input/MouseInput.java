package input;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import main.GamePanel;
import main.Gamestate;



/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 1, 2023  
*/
public class MouseInput implements MouseListener{



	private GamePanel gamePanel;
	
	//take game panel as a parameter since the panel is where our button is being drawn
	public MouseInput(GamePanel gamePanel) {
		this.gamePanel = gamePanel;	
	}

	//since our button is not an actual button we use the x and y location of the mouse event
		//to determine whether or not they clicked the button
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getPoint().x>430&&e.getPoint().x<750) {
			if(e.getPoint().y>250&&e.getPoint().y<390) {
				//if state isn't playing or end then set the state to playing
				if(Gamestate.getState()!=2&&Gamestate.getState()!=3) {
					System.out.println("click");
					Gamestate.setState(2);		
				}
				//if not playing and not menu then set the state to playing.
					// this is so we don't have to render the menu again which is basically the same screen
						//without the text and a different button
				if(Gamestate.getState()!=2&&Gamestate.getState()!=1){
					System.out.println(Gamestate.state);
					Gamestate.setState(2);
					gamePanel.repaint();
				}
				
				
			}
			
		}
		
		
	}

//consume all of our events that aren't clicked so they don't bog up our event queue
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		e.consume();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		e.consume();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		e.consume();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		e.consume();
	}

}
