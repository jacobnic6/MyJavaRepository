
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 7, 2023  
*/
public class PlayerTesterJacobs {

	public static void main(String[] args) {
		// Create basketball players and pass in their parameters
		BasketballPlayer basketballPlayer1 = new BasketballPlayer(7, "Mo", "Bamba", "Center", "Canaan", "NH", 68.3);
		BasketballPlayer basketballPlayer2 = new BasketballPlayer(21, "Joel", "Embiid", "Forward-Center", "Gainesville", "FL", 81.9);
		BasketballPlayer basketballPlayer3 = new BasketballPlayer(33, "Robert", "Covington", "Forward", "Hilside", "IL", 81.1);
		
		// Create football players and pass in their parameters
		FootballPlayer footballPlayer1 = new FootballPlayer(34, "Walter", "Payton", "Running Back", "Columbia", "MS", 16726);
		FootballPlayer footballPlayer2 = new FootballPlayer(20, "Barry", "Sanders", "Running Back", "Witchita", "KS", 15269);
		FootballPlayer footballPlayer3 = new FootballPlayer(36, "Jerome", "Bettis", "Running Back", "Detroit", "MI", 13662);

		//Create roster and pass in team name and coach name
		Roster basketballRoster = new Roster("Philadelphia 76ers", "Nick Nurse");
		basketballRoster.addToTeam(basketballPlayer1);
		basketballRoster.addToTeam(basketballPlayer2);
		basketballRoster.addToTeam(basketballPlayer3);
		
		//Create roster and pass in team name and coach name
		Roster footballRoster = new Roster("All Time Rushers", "John Madden");
		footballRoster.addToTeam(footballPlayer1);
		footballRoster.addToTeam(footballPlayer2);
		footballRoster.addToTeam(footballPlayer3);
		
		//Display our rosters 
		System.out.println(basketballRoster.displayRoster());
		System.out.println(footballRoster.displayRoster());;
		
	}

}
