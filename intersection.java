// TC : O(MlogM + NlogN) since we are sorting and iterating over M and N elements in both arrays
// SC: O(logM + logN) for sorting

// Sort both the arrays, now we can check if the elements in the array, if they are same, add them to the result, if the nums1 arrays is greater
// go to the right of the array in other array to check if any values are present, if values in nums1 is less, move the pointer to right to match it with
// value of second array

import java.util.*;

public class intersection {

	public List<Integer> intersect(int[] nums1, int[] nums2) {
		
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> res = new ArrayList<>();
		
		int n = nums1.length;
		int m = nums2.length;
		int i =0, j = 0;
		while(i < n && j < m) {
			
			if(nums1[i] == nums2[j]) {
				res.add(nums1[i]);
				i++;
				j++;
			}else if( nums1[i] > nums2[j]) {
				j++;
			}else {
				i++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		intersection it = new intersection();
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		List<Integer> res = it.intersect(nums1, nums2);
		System.out.println(res);
	}
}
