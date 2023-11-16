import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 24, 2023  
*/
public class FindFirstIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "sadbutsad";
		String	needle = "sad";
		System.out.println(strStr(haystack,needle));;
	}
		public static int strStr(String haystack, String needle) {
		
			int hLen = haystack.length();
			int nLen = needle.length();
			int nInd = 0; //save needle ind
			//loop through haystack 
			for (int i = 0; i < hLen; i++) {
				if (haystack.charAt(i)== needle.charAt(nInd)) {
					nInd++;
					
				}
				else {
					//start from the next index of prev start index
					i = i- nInd;
					//needle starts from ind 0
					nInd = 0;
				}
				if (nInd==nLen) {
					return i-nLen+1;
				}
			}
			
			return -1;
        
    }

}
