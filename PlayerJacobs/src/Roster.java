import java.util.ArrayList;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 7, 2023  
*/
public class Roster {
	private String teamName;
	private String coachName;
	private ArrayList<Player> playersList;
	
	public Roster() {}
	
	//non default constructor taking our team name and coach name as param. Creates our ArrayList
	public Roster(String teamName, String coachName) 
	{
			setTeamName(teamName);
			setCoach(coachName);
			playersList = new ArrayList<Player>();
	}
	
	//method to add player to ArrayList, uses Player as param so that we can add both football or bball players
	public void addToTeam(Player p) {
		playersList.add(p);
	}
	
	//method to display our roster. Uses a String Builder to append the team name and coach name to the string then loops
		//through our ArrayList and appends the information of each Player
	public String displayRoster() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n" + this.getTeamName() + " - " + "Coached by " + this.coachName);
		
		for (Player player : playersList) {
			sb.append("\n" + player.formatPlayerInformation());
		}
		
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return "Roster [teamName=" + teamName + ", coach=" + coachName + ", playersList=" + playersList + "]";
	}
	
	
	public String getTeamName() {
		return teamName;
	}
	
	//set teamName after validating that the name isn't null
	public void setTeamName(String teamName) {
		if(teamName.isEmpty()|| teamName.isBlank()) {
			this.teamName = null;
		}
		else {
			this.teamName = teamName;
		}
		
	}
	
	public String getCoach() {
		return coachName;
	}
	
	//set coachName after validating that his name isn't null
	public void setCoach(String coachName) {
		if(coachName.isEmpty()|| coachName.isBlank()) {
			this.coachName = null;
		}
		else {
			this.coachName = coachName;
		}
	}
	
	public ArrayList<Player> getPlayersList() {
		return playersList;
	}
	
	public void setPlayersList(ArrayList<Player> playersList) {
		this.playersList = playersList;
	}
	
	
}
