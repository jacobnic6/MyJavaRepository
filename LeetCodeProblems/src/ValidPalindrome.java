
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 26, 2023  
*/
public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "A man, a plan, a canal: Panama";
		String s2 = "race a car";
		String s3 = "  ";
		System.out.println(isPalindrome(s1));;
		System.out.println(isPalindrome(s2));;
		System.out.println(isPalindrome("***"+ s3+"***"));
	}
	
	public static boolean isPalindrome(String s) {
		
		  if (s.isEmpty()) {//empty s reversed == s
	        	return true;
	        }
	        int start = 0;
	        int last = s.length() - 1;
	        while(start <= last) {//start from beginning and end working inward, comparing chars
	        	char currFirst = s.charAt(start);
	        	char currLast = s.charAt(last);
	        	if (!Character.isLetterOrDigit(currFirst )) {//remove non alphanumerics
	        		start++;
	        	} else if(!Character.isLetterOrDigit(currLast)) {
	        		last--;
	        	} else {
	        		if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {//if currFirst != currLast then false
	        			return false;
	        		}
	        		start++;
	        		last--;
	        	}
	        }
	        return true;
		
		/* To Complete: 
		 * remove all non-alphanumeric
		 * 		(loop through, letter or num) if true, remove
		 * after removing, store into 2 arrays, one regular, one rev and check if equal
		 * */

	
		
    }

}

//Example 1:
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//Example 2:
//
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
//Example 3:
//
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.

/*
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */