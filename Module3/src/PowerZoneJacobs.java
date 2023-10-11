import javax.swing.JOptionPane;

/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Sep 12, 2023
 */
public class PowerZoneJacobs {

	// create method for coverting the user input into our time values
	static String ConvertTime(int a) {
		double minutes = a % 60;
		double hours = (a / 60);

		// if else to handle the different values the user might enter and format them
		// to be displayed then return the formatted value to where it was called
		if ((a / 60) < 1) {
			hours = 0;
			minutes = a;
			String timeFormat = (String.format("%.0f", hours) + " hours and " + String.format("%.0f", minutes)
					+ " minutes");
			return timeFormat;
		}

		else if ((a / 60) == 1) {
			hours = 1;
			minutes = (a % 60);
			String timeFormat = (String.format("%.0f", hours) + " hour and " + String.format("%.0f", minutes)
					+ " minutes");
			return timeFormat;
		} else {
			hours = (a / 60);
			minutes = (a % 60);
			String timeFormat = (String.format("%.0f", hours) + " hours and " + String.format("%.0f", minutes)
					+ " minutes");
			return timeFormat;
		}
	}

	public static void main(String[] args) {

		// get user input through JOptionPane
		String memberId = JOptionPane.showInputDialog("Please enter your 5 character membership ID:");
		String massageLength = JOptionPane
				.showInputDialog("Please enter the length of your massage reservation: \n (In minutes.)");
		// parse to int so it can be used in method above
		int massageLengthFormatted = Integer.parseInt(massageLength);

		// format
		String idFormatted = memberId.substring(0, 1) + "-" + memberId.substring(1, 4) + "-" + memberId.substring(4, 5);
		String messageToUser = "Thank you, Member " + idFormatted.toUpperCase() + " for your massage reservation for "
				+ ConvertTime(massageLengthFormatted) + ".";
		// display confirmation message to user
		JOptionPane.showMessageDialog(null, messageToUser);

	}

}
