
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 26, 2023  
*/
public class IsSubsequenceJacobs {
	/*
	 * Given two strings s and t, return true if s is a subsequence of t, or false
	 * otherwise.
	 * 
	 * A subsequence of a string is a new string that is formed from the original
	 * string by deleting some (can be none) of the characters without disturbing
	 * the relative positions of the remaining characters. (i.e., "ace" is a
	 * subsequence of "abcde" while "aec" is not).
	 */
	
//	Example 1:
//
//		Input: s = "abc", t = "ahbgdc"
//		Output: true
//		
//	Example 2:
//
//		Input: s = "axc", t = "ahbgdc"
//		Output: false
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abc", t1 = "ahbgdc";
		String s2 = "axc",  t2 = "ahbgdc";
		System.out.println(isSubsequence(s1, t1));
		System.out.println(isSubsequence(s2, t2));
	}
	
	public static boolean isSubsequence(String s, String t) {
		//get indexes of s chars in t
		//index of each char should still be < the following in the t string else false
		int sLen = s.length();
		int tLen = t.length();
		int j = 0;
		if(sLen ==0) {	//if s is empty then adding nothing to t means that it is the same
			return true;
		}
		if(tLen == 0) {	//if t is empty s cant be a subsequence of it
			return false;
		}
		for(int i = 0; i< tLen; i++) {
			if(s.charAt(j)== t.charAt(i)) {//increment j only if char is same in both strings
				j++;
			}
			if(j==sLen) { //if j == length then we saw all characters, and we only see all if their order is the same
				return true;
			}
		}
		
		return false;
        
    }

}
