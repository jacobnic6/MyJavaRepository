
/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 24, 2023
 */
public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {2,2,1,1,1,2,2};
		System.out.println(majorityElement(nums));
		;

	}

	public static int majorityElement(int[] nums) {
		 int count = 0;
	        int candidate = 0;
	        
	        for (int num : nums) {
	            if (count == 0) {
	                candidate = num;
	            }
	            
	            if (num == candidate) {
	                count++;
	            } else {
	                count--;
	            }
	        }
	        
	        return candidate;


	}
}
