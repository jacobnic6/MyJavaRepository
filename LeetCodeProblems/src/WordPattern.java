import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 26, 2023  
*/
public class WordPattern {
	/*
	 * Given a pattern and a string s, find if s follows the same pattern.
	 * 
	 * Here follow means a full match, such that there is a bijection between a
	 * letter in pattern and a non-empty word in s.
	 */
	/*
	 * Constraints:
	 * 
	 * 1 <= pattern.length <= 300 pattern contains only lower-case English letters.
	 * 1 <= s.length <= 3000 s contains only lowercase English letters and spaces '
	 * '. s does not contain any leading or trailing spaces. All the words in s are
	 * separated by a single space.
	 */
	
//	Example 1:
//
//		Input: pattern = "abba", s = "dog cat cat dog"
//		Output: true
//	Example 2:
//
//		Input: pattern = "abba", s = "dog cat cat fish"
//		Output: false
//	Example 3:
//
//		Input: pattern = "aaaa", s = "dog cat cat dog"
//		Output: false
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern1 = "abba", s1 = "dog cat cat dog";
		String pattern2 = "abba", s2 = "dog cat cat fish";
		String pattern3 = "aaaa", s3 = "dog cat cat dog";
		String pattern4 = "aba", s4 = "dog cat cat";
		String pattern5 = "abba", s5 = "dog dog dog dog";
		System.out.println(wordPattern(pattern1, s1));
		System.out.println(wordPattern(pattern2, s2));
		System.out.println(wordPattern(pattern3, s3));
		System.out.println(wordPattern(pattern4, s4));
		System.out.println(wordPattern(pattern5, s5));
	}
	public static boolean wordPattern(String pattern, String s) {
		//to be bijective(one to one correspondence), must be injective(one to one) 
			//&& surjective(maps one(one in this case) or more elements A to same element of B)
			//	 True		  False
			//a	->	dog 	a	->	dog 
			//b	->	cat 	b	->	cat 
			//b	->	cat 	b	->	cat
			//a	->	dog		a	->	fish	a cant map with both dog and fish
		
		 HashMap<Character,String> charToStr = new HashMap<Character,String>();
	        HashMap<String,Character> strToChar = new HashMap<String,Character>();

	        int strLen = pattern.length();
	        String[] sArr = s.split(" ");
	        int sArrLen = sArr.length;
	        if(strLen != sArrLen)
	        {
	            return false;
	        }
	        for(int i=0;i<sArrLen;i++){
	           if(charToStr.containsKey(pattern.charAt(i)))
	           {
	               if(!charToStr.get(pattern.charAt(i)).equals(sArr[i])){
	                    return false;
	               }
	               if(strToChar.get(sArr[i]) != pattern.charAt(i))
	               {
	                   return false;
	               }
	           }
	            else{
	                   charToStr.put(pattern.charAt(i),sArr[i]);
	                   if(strToChar.containsKey(sArr[i]))
	                   return false;
	                   else
	                   strToChar.put(sArr[i],pattern.charAt(i));
	               }
	        }

	        return true;
        
    }

}
