import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener{

	private int clickCount;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		++clickCount;
		System.out.println("I was clicked " + clickCount + " times!");
	}
	

}
