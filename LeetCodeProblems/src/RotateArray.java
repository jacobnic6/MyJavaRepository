
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 25, 2023  
*/
public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1,2,3,4,5,6,7};int k = 3;
		rotate(nums, k);
	}
	
	//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
	 public static void rotate(int[] nums, int k) {
		int temp [] = new int[nums.length];
		for(int i =0; i<nums.length;i++) {
			temp[(i+k)%nums.length]= nums[i];
		}
		for(int i =0; i< nums.length; i++) {
			nums[i]=temp[i];
		}
	        
	        System.out.println(nums[0]+ " "+ nums[1]+" "+ nums[2]+" "+ nums[3]+" "+ nums[4]+" "+ nums[5]+" "+ nums[6]);
	        
	 }
}
/*
 * Input: nums = [1,2,3,4,5,6,7], k = 3 
 * Output: [5,6,7,1,2,3,4] 
 * Explanation:rotate 1 steps to the right: [7,1,2,3,4,5,6] 
 * rotate 2 steps to the right:[6,7,1,2,3,4,5] 
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */