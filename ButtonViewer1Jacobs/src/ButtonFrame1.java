import java.awt.Desktop.Action;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame1 extends JFrame{
	private static final int FRAME_WIDTH = 100;
	private static final int FRAME_HEIGHT = 100;
	
	public ButtonFrame1() {
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	private void createComponents() {
		JButton buttonA = new JButton("A");
		JButton buttonB = new JButton("B");
		JPanel panel = new JPanel();
		panel.add(buttonA);
		panel.add(buttonB);
		add(panel);
		ActionListener listenerA = new ClickListener();
		buttonA.addActionListener(listenerA);
		ActionListener listenerB = new ClickListener();
		buttonB.addActionListener(listenerB);
		
	}
}
