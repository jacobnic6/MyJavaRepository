
/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 26, 2023
 */
public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Hello World";
		String s2 = "   fly me   to   the moon  ";
		String s3 = "luffy is still joyboy";
		String s4 = "a";
		String s5 = "a ";
		String s6 = "day";
		System.out.println(lengthOfLastWord(s1));
		System.out.println(lengthOfLastWord(s2));
		System.out.println(lengthOfLastWord(s3));
		System.out.println(lengthOfLastWord(s4));
		System.out.println(lengthOfLastWord(s5));
		System.out.println(lengthOfLastWord(s6));
	}

	/*
	 * Given a string s consisting of words and spaces, return the length of the
	 * last word in the string.
	 * 
	 * A word is a maximal substring consisting of non-space characters only.
	 */
	public static int lengthOfLastWord(String s) {

		/*
		 * To complete:
		 * 
		 * get length of s : s.length find last word : find last space that has letters
		 * after find length of last word : substring
		 */
		
		int endInd = 0; // mark end of our word
		boolean wordFound = false;
		//loop through string starting at end so we find last word faster
		for (int i = s.length() - 1; i >= 0; i--) {
			
			if (s.charAt(i) != ' ' && !wordFound) {	//if next char isn't a space and we havent found word yet, then we found the end of the word.
				endInd = i;//mark end
				wordFound = true;//set found to true
				
			} 
			if (s.charAt(i) == ' ' && wordFound) {//if next char is a space and bool is true, then we found the beginning
				return endInd - i;	//return here to end loop faster
			}
			else if(i==0 && wordFound) {//if we reached the beginning without hitting another space, return end +1 for the length
				return endInd+1;	
			}
			
		}
		return 0;

	}

}
//Example 1:
//
//Input: s = "Hello World"
//Output: 5
//Explanation: The last word is "World" with length 5.
//Example 2:
//
//Input: s = "   fly me   to   the moon  "
//Output: 4
//Explanation: The last word is "moon" with length 4.
//Example 3:
//
//Input: s = "luffy is still joyboy"
//Output: 6
//Explanation: The last word is "joyboy" with length 6.