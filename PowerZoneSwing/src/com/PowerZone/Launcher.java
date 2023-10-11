package com.PowerZone;

import javax.swing.SwingUtilities;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Sep 12, 2023  
*/
public class Launcher {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				MainWindow main = new MainWindow();
				main.show();
			}
		});
	}

}
