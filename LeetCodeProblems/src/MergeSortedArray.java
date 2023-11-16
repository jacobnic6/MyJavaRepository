
/**  
* Nicholas Jacobs - ndjacobs2  
* CIS171 <11232>
* Oct 24, 2023  
*/
public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[] {1,2,3,0,0,0}; int m = 3;
		int[] nums2 = new int[] {2,5,6};int n = 3;
		merge(nums1, m, nums2, n);
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
	    
	   int i = m-1;
	   int j = n-1;
	   int k = m+n-1;

	   while(j>=0){
		   
		   if(i>=0 && nums1[i]>nums2[j]) {
			   nums1[k--]=nums1[i--];
		   }
		   else {
			   nums1[k--] = nums2[j--];
		   }
	   }

		
	}
	
}
