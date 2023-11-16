import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 26, 2023  
*/
public class RansomNote {

	/*
	 * Given two strings ransomNote and magazine, return true if ransomNote can be
	 * constructed by using the letters from magazine and false otherwise.
	 * 
	 * Each letter in magazine can only be used once in ransomNote.
	 * ransomNote and magazine consist of lowercase English letters.
	 * 1 <= ransomNote.length, magazine.length <= 10^5
	 */
	
//	Example 1:
//
//		Input: ransomNote = "a", magazine = "b"
//		Output: false
//	Example 2:
//
//		Input: ransomNote = "aa", magazine = "ab"
//		Output: false
//	Example 3:
//
//		Input: ransomNote = "aa", magazine = "aab"
//		Output: true
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ransomNote1 = "a", magazine1 = "b";
		String ransomNote2 = "aa", magazine2 = "ab";
		String ransomNote3 = "aa", magazine3 = "aab";
		System.out.println(canConstruct(ransomNote1, magazine1));
		System.out.println(canConstruct(ransomNote2, magazine2));
		System.out.println(canConstruct(ransomNote3, magazine3));
	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) return false;
        int[] alphabetsCounter = new int[26];	//init array to size of the alphabet
        
        for (char c : magazine.toCharArray())
            alphabetsCounter[c-'a']++;			//c- char == gives us our index of our character, then increment value

        for (char c : ransomNote.toCharArray()){
            if (alphabetsCounter[c-'a'] == 0) return false;		//if ==0 then we don't have that char in our array and thus cannot make the note
            alphabetsCounter[c-'a']--;							//decrement on use(can only use char once)
        }
        return true;
        
    }
}
