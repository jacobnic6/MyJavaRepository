import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Sep 24, 2023  
*/
class RockPaperScissorsJacobsTest {

	/**
	 * Test method for {@link RockPaperScissorsJacobs#getWinner(java.lang.String, java.lang.String)}.
	 */
	@Test//ensure our method doesn't fail without input
	void testGetWinnerNotNull() 
	{
		assertNotNull(RockPaperScissorsJacobs.getWinner("",""));
	}
	@Test//test all possible combinations of acceptable answers and ensure they match what we expect
	void testGetWinnerAssertSame() 
	{
		assertSame("rock", RockPaperScissorsJacobs.getWinner("ROCK","scissors"));
		assertSame("rock", RockPaperScissorsJacobs.getWinner("rock","lizard"));
		assertSame("rock", RockPaperScissorsJacobs.getWinner("scissors", "ROCK"));
		assertSame("rock", RockPaperScissorsJacobs.getWinner("lizard", "rock"));
		
		assertSame("spock", RockPaperScissorsJacobs.getWinner("SPOCK","SCISSORS"));
		assertSame("spock", RockPaperScissorsJacobs.getWinner("spock","rock"));
		assertSame("spock", RockPaperScissorsJacobs.getWinner("scissors", "spock"));
		assertSame("spock", RockPaperScissorsJacobs.getWinner("rock", "SPOCK"));
		
		assertSame("paper", RockPaperScissorsJacobs.getWinner("paper", "rock"));
		assertSame("paper", RockPaperScissorsJacobs.getWinner("PAPER", "spock"));
		assertSame("paper", RockPaperScissorsJacobs.getWinner("rock", "PAPER"));
		assertSame("paper", RockPaperScissorsJacobs.getWinner("spock", "paper"));
		
		assertSame("lizard", RockPaperScissorsJacobs.getWinner("lizard", "paper"));
		assertSame("lizard", RockPaperScissorsJacobs.getWinner("LIZARD", "spock"));
		assertSame("lizard", RockPaperScissorsJacobs.getWinner("paper", "LIZARD"));
		assertSame("lizard", RockPaperScissorsJacobs.getWinner("spock", "lizard"));
		
		assertSame("scissors", RockPaperScissorsJacobs.getWinner("SCISSORS", "paper"));
		assertSame("scissors", RockPaperScissorsJacobs.getWinner("scissors", "lizard"));
		assertSame("scissors", RockPaperScissorsJacobs.getWinner("paper", "scissors"));
		assertSame("scissors", RockPaperScissorsJacobs.getWinner("lizard", "scissors"));
	}
	@Test//ensure that we prompt user with our invalid input message if they enter it incorrectly
	void testGetWinnerCheckInputValidity() 
	{
		assertSame("Invalid input", RockPaperScissorsJacobs.getWinner(" rock","pap er"));
		assertSame("Invalid input", RockPaperScissorsJacobs.getWinner("sdfds"," lizard"));
		assertSame("Invalid input", RockPaperScissorsJacobs.getWinner("scissors", "123"));
		assertSame("Invalid input", RockPaperScissorsJacobs.getWinner("123", "ro@#$"));
	}

}
