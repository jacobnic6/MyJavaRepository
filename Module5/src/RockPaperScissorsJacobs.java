import java.util.Scanner;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Sep 23, 2023  
*/
public class RockPaperScissorsJacobs {
	
	//public static String playerOne = "";
	//public static String playerTwo = "";
	public static String gameWinner = "";
	public static String playerOne = "";
	public static String playerTwo = "";
	public final static String ROCK = "rock";
	public final static String LIZARD = "lizard";
	public final static String SPOCK = "spock";
	public final static String SCISSORS = "scissors";
	public final static String PAPER = "paper";
	public static String invalidInputMessage ="Invalid input";
	
	public static void main(String[] args) 
	{
		
		Scanner in =  new Scanner(System.in);
		//get input from user and set our variables to it
		System.out.println("Player one, please enter your choice. (rock, paper, scissors, lizard, or spock)");
		playerOne = in.nextLine();
		System.out.println("Player two, please enter your choice. (rock, paper, scissors, lizard, or spock)");
		playerTwo = in.nextLine();
		//format output of the method
		String winnerFormatted = getWinner(playerOne, playerTwo).substring(0,1).toUpperCase() + 
				getWinner(playerOne, playerTwo).substring(1);
		System.out.println("Winner: " + winnerFormatted);
		in.close();	
	}
	
	//pass user input into our method to determine winner. Use equals Ignore case for a boolean comparison while also taking care of possible formatting issues.
	//return invalid input message if user enters the wrong data type
	public static String getWinner(String playerOne, String playerTwo) 
	{	invalidInputMessage ="Invalid input";
		if (playerOne.equalsIgnoreCase(ROCK) == true) 
		{
			if(playerTwo.equalsIgnoreCase(LIZARD) == true) 
			{
				gameWinner = ROCK;
			}
			else if (playerTwo.equalsIgnoreCase(PAPER) == true) 
			{
				gameWinner = PAPER;
			}
			else if (playerTwo.equalsIgnoreCase(SCISSORS) == true) 
			{
				gameWinner = ROCK;			
			}
			else  
			{
				if (playerTwo.equalsIgnoreCase(SPOCK) == true) 
				{
					gameWinner = SPOCK;
				}
				else 
				{
					return invalidInputMessage;
				}
			}
		}
		
		else if (playerOne.equalsIgnoreCase(LIZARD) == true) 
		{
			if(playerTwo.equalsIgnoreCase(ROCK) == true) 
			{
				gameWinner = ROCK;
			}
			else if (playerTwo.equalsIgnoreCase(SPOCK) == true) 
			{
				gameWinner = LIZARD;
			}
			else if (playerTwo.equalsIgnoreCase(PAPER) == true) 
			{
				gameWinner = LIZARD;
			}
			else  
			{
				if (playerTwo.equalsIgnoreCase(SCISSORS) == true) 
				{
					gameWinner = SCISSORS;
				}
				else 
				{
					return invalidInputMessage;
				}
				
			}
		}
		
		else if (playerOne.equalsIgnoreCase(SPOCK) == true) 
		{
			if(playerTwo.equalsIgnoreCase(LIZARD) == true) 
			{
				gameWinner = LIZARD;
			}
			else if (playerTwo.equalsIgnoreCase(SCISSORS) == true) 
			{
				gameWinner = SPOCK;
			}
			else if (playerTwo.equalsIgnoreCase(ROCK) == true) 
			{
				gameWinner = SPOCK;
			}
			else  
			{
				if (playerTwo.equalsIgnoreCase(PAPER) == true) 
				{
					gameWinner = PAPER;
				}
				else 
				{
					return invalidInputMessage;
				}
				
			}
		}
		
		else if (playerOne.equalsIgnoreCase(SCISSORS) == true) 
		{
			if(playerTwo.equalsIgnoreCase(ROCK) == true) 
			{
				gameWinner = ROCK;
			}
			else if (playerTwo.equalsIgnoreCase(SPOCK) == true) 
			{
				gameWinner = SPOCK;
			}
			else if (playerTwo.equalsIgnoreCase(PAPER) == true) 
			{
				gameWinner = SCISSORS;
			}
			else  
			{
				if (playerTwo.equalsIgnoreCase(LIZARD) == true) 
				{
					gameWinner = SCISSORS;
				}
				else 
				{
					return invalidInputMessage;
				}
			}
		}
		
		else  
		{
			if (playerOne.equalsIgnoreCase(PAPER) == true) 
			{
				if(playerTwo.equalsIgnoreCase(ROCK) == true)
				{
					gameWinner = PAPER;
				}
				else if (playerTwo.equalsIgnoreCase(SPOCK) == true) 
				{
					gameWinner = PAPER;
				}
				else if (playerTwo.equalsIgnoreCase(LIZARD) == true) 
				{
					gameWinner = LIZARD;
				}
				else  
				{
					if (playerTwo.equalsIgnoreCase(SCISSORS) == true) 
					{
						gameWinner = SCISSORS;
					}
					else 
					{
						return invalidInputMessage;
					}
				}
			}
			else 
			{
				return invalidInputMessage;
			}
			
		}

		return gameWinner;
	}
}
