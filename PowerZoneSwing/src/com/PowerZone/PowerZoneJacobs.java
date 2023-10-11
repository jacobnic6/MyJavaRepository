package com.PowerZone;
import javax.swing.JOptionPane;
import java.util.Scanner;
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Sep 11, 2023  
*/
public class PowerZoneJacobs {

	
	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
		
		
		String memberId = JOptionPane.showInputDialog("Please enter your membership ID:");
		String massageLength = JOptionPane.showInputDialog("Please enter the length of your massage reservation: ");
		String idFormatted = memberId.toUpperCase(); 
		
		JOptionPane.showMessageDialog(null, "Thank you, Member " + memberId + "for your massage reservation for " + massageLength +".");
		
	}

}
