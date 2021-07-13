// TC - O(nlog(m)) n = smaller array, m - larger array
// SC - O(n)

class Solution {
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
    
  // Binary Search to find the first index of a target element
	private int binarySearch(int[] nums2,int low,int high,int target) {
        int first_pos =-1;
		while(low<=high) {
			int mid=low+(high-low)/2;

			if(nums2[mid]==target) {
				first_pos = mid;
                high=mid-1;
			}else if (nums2[mid]>target) {
				high=mid-1;
			}else {
				low=mid+1;
			}
		}
		return first_pos;
	}
}
