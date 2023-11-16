import java.text.CharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 23, 2023  
*/
public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = new String[]{"flower","flow","flight"};
		
		String[] strs2 = new String[] {"dog","dacecar","dar"};
		System.out.println(longestCommonPrefix(strs2));
	}
public static String longestCommonPrefix(String[] strs) {
	 if (strs == null || strs.length == 0) return "";
     String prefix = strs[0];
     for (String s : strs)
         while (s.indexOf(prefix) != 0)
             prefix = prefix.substring(0, prefix.length() - 1);
     return prefix;
}   
    

}
