
/**
 * Nicholas Jacobs - ndjacobs2 CIS171 <11232> Oct 24, 2023
 */
public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;
		System.out.println(removeElement(nums, val));
		;
	}

	public static int removeElement(int[] nums, int val) {
		int ind = 0;
		int size = nums.length;
		for(int i = 0; i < size; i++) {
			if (nums[i]!= val) {
				nums[ind]= nums[i];
				ind++;
			}
		}
		return ind;
	}

}
