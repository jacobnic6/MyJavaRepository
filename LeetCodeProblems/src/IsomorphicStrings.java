import java.util.HashMap;
import java.util.Hashtable;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 26, 2023  
*/
public class IsomorphicStrings {
	/*
	 * Given two strings s and t, determine if they are isomorphic.
	 * 
	 * Two strings s and t are isomorphic if the characters in s can be replaced to
	 * get t.
	 * 
	 * All occurrences of a character must be replaced with another character while
	 * preserving the order of characters. No two characters may map to the same
	 * character, but a character may map to itself.
	 */
	
//	Example 1:
//
//		Input: s = "egg", t = "add"
//		Output: true
//	Example 2:
//
//		Input: s = "foo", t = "bar"
//		Output: false
//	Example 3:
//
//		Input: s = "paper", t = "title"
//		Output: true
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "egg", t1 = "add";
		String s2 = "foo", t2 = "bar";
		String s3 = "paper", t3 = "title";

		System.out.println(isIsomorphic(s1, t1));
		System.out.println(isIsomorphic(s2, t2));
		System.out.println(isIsomorphic(s3, t3));
	}
	public static boolean isIsomorphic(String s, String t) {			//
		 									//one way map from s -> t	e -> a
		    														//  g -> d
		    int[] arrS = new int[256];								//	g -> d
		    int[] arrT = new int[256];
		   
		    for(int i = 0; i < s.length(); i++)
		    {
		      char chS=s.charAt(i);
		      char chT=t.charAt(i);

		        if(arrS[chS] != arrT[chT]) //if not equal, then one char mapped to two different chars
		        {
		        	return false;
		        }
		        arrS[chS] = i+1;
		        arrT[chT] = i+1;
		        
		    }
		    return true; 
		
		
		
		
        
    }

}
