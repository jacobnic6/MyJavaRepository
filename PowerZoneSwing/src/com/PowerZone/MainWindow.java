package com.PowerZone;

import javax.swing.JFrame;
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Sep 12, 2023  
*/
public class MainWindow {
	
	private JFrame window;
	
	public MainWindow() {
		window = new JFrame();
		window.setTitle("Power Zone");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(800, 500);
		window.setLocationRelativeTo(null);
	}
	
	public void show() {
		window.setVisible(true);
	}
}