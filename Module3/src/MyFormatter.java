import java.text.DecimalFormat;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Sep 11, 2023  
*/
public class MyFormatter {

	public static void customFormat(String pattern, Double value) {
		DecimalFormat myFormat = new DecimalFormat(pattern);
		String output = myFormat.format(value);
		System.out.println(output);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 customFormat("###,###,###", 123456789.00);
		
		 
	}

}
