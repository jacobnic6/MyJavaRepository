
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Nov 7, 2023  
*/
public class FootballPlayer extends Player{
	private int careerRushingYards;

	
	public FootballPlayer() {
		super();
	}
	
	/**
	 * @param playerNumber
	 * @param firstName
	 * @param lastName
	 * @param position
	 * @param homeTown
	 * @param homeState
	 */
	public FootballPlayer(int playerNumber, String firstName, String lastName, String position, String homeTown,
			String homeState, int careerRushingYards) 
	{
		super(playerNumber, firstName, lastName, position, homeTown, homeState);
		if(playerNumber>0 && !firstName.isEmpty() && !lastName.isEmpty()) {
			setCareerRushingYards(careerRushingYards);
		}
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String formatPlayerInformation() {
		// TODO Auto-generated method stub
		String playerInfo = super.formatPlayerInformation() + ", Career Rushing Yards: " + careerRushingYards ;
		return playerInfo;
	}
	
	/**
	 * @return the careerRushingYards
	 */
	public int getCareerRushingYards() {
		return careerRushingYards;
	}

	/**
	 * @param careerRushingYards the careerRushingYards to set
	 */
	public void setCareerRushingYards(int careerRushingYards) {
			this.careerRushingYards = careerRushingYards;
	}
}
