import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 24, 2023  
*/
public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()";
		String s2 = "()[]{}";
		String s3 = "(]";
		System.out.println(isValid(s));
	}

	
	    public static boolean isValid(String s) {
	    	Stack<Character> stack = new Stack<Character>();
	    	
	    
	    	int i  = 0;
	    	for (char c: s.toCharArray()) {
	    		if(c == '(')
	    		{
	    			stack.push(')');
	    		}
	    		else if(c =='{')
	    		{
	    			stack.push('}');
	    		}
	    		else if(c =='[')
	    		{
	    			stack.push(']');
	    		}
	    		else if(stack.isEmpty() || stack.pop() != c)
	    		{
	    			return false;
	    		}
	    	}
	    	

			return stack.isEmpty();
	        
	    }
	
}
