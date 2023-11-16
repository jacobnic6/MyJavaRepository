

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 26, 2023  
*/
public class RomanToIntegerLeet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "III";
		String s2 = "LVIII";
		String s3 = "MCMXCIV";
		romanToInt(s3);
	}
	
	public static int romanToInt(String s) {
		
//		Symbol       Value
//		I             1
//		V             5
//		X             10
//		L             50
//		C             100
//		D             500
//		M             1000
		//int length = s.length();
		
		//loop for chars in s. look at last char and next char
		
		//add temp val to total
		char[] arr = s.toCharArray();
		int tempVal = 0;
		int i = 0;
		
		//loop through array 
		for (char c : arr) {
			switch(c) {
			
				case 'I':
					if(i !=arr.length-1 && (arr[i+1]=='V' ||  arr[i+1]=='X'  )) {//check that i isn't last pos then if next int is V or X subtract 1
						tempVal -= 1;
					}
					else {
						tempVal += 1;	//if not, then add
					}
					i++;
					break;
					
				case 'V':
					
					tempVal += 5;
					i++;
					break;
					
				case'X':
					if(i !=arr.length-1 && (arr[i+1]=='L' ||  arr[i+1]=='C')) {	//check that i isn't last pos then if next int is L or C subtract 10
						tempVal -= 10;
					}
					else {
						tempVal += 10;	//if not, then add
					}
					i++;
					break;
					
				case 'L':
					tempVal += 50;
					i++;
					break;
					
				case'C':
					if(i !=arr.length-1 && (arr[i+1]=='D' || arr[i+1]=='M')) {	//check that i isn't last pos then if next int is D or M subtract 100
						tempVal -= 100;
					}
					else {
						tempVal += 100;	//if not, then add
					}
					i++;
					break;
					
				case 'D':
					tempVal += 500;
					i++;
					break;
					
				case 'M':
					tempVal += 1000;
					i++;
					break;		
			}	
		}
		
		return tempVal;
        
   
    }

}
/*
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 For example, 2 is written
 * as II in Roman numeral, just two ones added together. 12 is written as XII,
 * which is simply X + II. The number 27 is written as XXVII, which is XX + V +
 * II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
 * and M (1000) to make 400 and 900. Given a roman numeral, convert it to an
 * integer.
 */