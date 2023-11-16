import java.util.HashMap;
import java.util.Stack;

/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 25, 2023  
*/
public class RemoveDuplicatesII {
	/*
	 * Example 1:
	 * 
	 * Input: nums = [1,1,1,2,2,3] Output: 5, nums = [1,1,2,2,3,_] Explanation: Your
	 * function should return k = 5, with the first five elements of nums being 1,
	 * 1, 2, 2 and 3 respectively. It does not matter what you leave beyond the
	 * returned k (hence they are underscores).
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {0,0,1,1,1,1,2,3,3};
		System.out.println(removeDuplicates(nums));;
	}

	
	public static int removeDuplicates(int[] nums) {
	
		 int left=2, right; 
	        for(right=2; right<nums.length; right++){
	                if(nums[left-1]==nums[right]){
	                    if(nums[left-1]==nums[left-2]) continue;
	                    nums[left++]=nums[right]; continue;
	                }
	                if(nums[left-1]!=nums[right])
	                    nums[left++]=nums[right];
	            }
	        return left;  
		
        
    }
}
/*
 * Given an integer array nums sorted in non-decreasing order, remove some
 * duplicates in-place such that each unique element appears at most twice. The
 * relative order of the elements should be kept the same.
 * 
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array
 * nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not
 * matter what you leave beyond the first k elements.
 * 
 * Return k after placing the final result in the first k slots of nums.
 * 
 * 
 */