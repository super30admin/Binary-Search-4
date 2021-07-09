import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time Complexity : O(m log n)// m is the length of small array and n is other array length
//Space Complexity :O(log n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this :no

/*
* 1. It works only if arrays are sorted. two pointers also works with complexity O(m+n) 
* 2. loop through first array and run binary search on second array.
* 2. while binary search duplicate elements might exist so always find first index bound to low.
*/

public class ArrayIntersectionSorted {
	public int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> result = new ArrayList<>();

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		if(nums1.length>nums2.length) return intersect(nums2,nums1);
		
		int low=0;
		int high=nums2.length-1;
		for (int i = 0; i < nums1.length; i++) {
			int index=binarySearch(nums2,low,high,nums1[i]);
			if(index!=-1) {
				result.add(nums1[i]);
				low=index+1;
			}
		}

		return result.stream().mapToInt(i -> i).toArray();
	}
	private int binarySearch(int[] nums2,int low,int high,int target) {
		while(low<=high) {
			int mid=low+(high-low)/2;
			
			if(nums2[mid]==target) {
				if(mid==low||nums2[mid-1]!=nums2[mid]) {
					return mid;
				}else {
					high=mid-1;
				}
			}else if (nums2[mid]>target) {
				high=mid-1;
			}else {
				low=mid+1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new ArrayIntersectionSorted().intersect(new int[] {1,2,2,1}, new int[] {2,2})));
	}
}
