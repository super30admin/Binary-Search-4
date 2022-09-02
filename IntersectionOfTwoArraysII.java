// Time Complexity : O(mlogn) where m = number of elements in nums1, n = number of elements in nums2 (Assuming the given 2 arrays are sorted)
// Space Complexity : O(k) where k = number of common elements in nums1 & nums2
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//350. Intersection of Two Arrays II (Easy) - https://leetcode.com/problems/intersection-of-two-arrays-ii/
class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		// HashMap solution
		// Time Complexity : O(m+n) where m = number of elements in array 1, n = number
		// of elements in array 2
		// Space Complexity : O(m) where m = number of elements in smallest array
//		if (nums1.length > nums2.length)
//			return intersect(nums2, nums1);
//
//		int n1 = nums1.length, n2 = nums2.length;
//		HashMap<Integer, Integer> map = new HashMap<>();
//
//		for (int i = 0; i < n1; i++) { // O(m)
//			map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
//		}
//
//		List<Integer> result = new ArrayList<>();
//
//		for (int i = 0; i < n2; i++) { // O(n)
//			if (map.containsKey(nums2[i])) {
//				result.add(nums2[i]);
//				map.put(nums2[i], map.get(nums2[i]) - 1);
//				map.remove(nums2[i], 0);
//			}
//		}
//
//		int[] res = new int[result.size()];
//
//		for (int i = 0; i < result.size(); i++) {
//			res[i] = result.get(i);
//		}
//
//		return res;
		
		// Two Pointer approach
		// Time Complexity : O(mlogm) + O(nlogn) where m = number of elements in nums1, n = number of elements in nums2
        // Space Complexity : O(k) where k = number of common elements in nums1 & nums2
//        int n1 = nums1.length, n2 = nums2.length, p1 = 0, p2 = 0;
//        List<Integer> result = new ArrayList<>();
//        
//        Arrays.sort(nums1); // O(mlogm) where m = number of elements in nums1
//        Arrays.sort(nums2); // O(nlogn) where n = number of elements in nums2
//        
//        while (p1 < n1 && p2 < n2) { // O(m) + O(n)
//            if (nums1[p1] == nums2[p2]) {
//                result.add(nums1[p1]);
//                p1++;
//                p2++;
//            } else if (nums1[p1] > nums2[p2]) {
//                p2++;
//            } else {
//                p1++;
//            }
//        }
//        
//        return result.stream().mapToInt(Integer::intValue).toArray();
		
		// Binary Search approach
        // Time Complexity : O(mlogn) where m = number of elements in nums1, n = number of elements in nums2
        // Space Complexity : O(k) where k = number of common elements in nums1 & nums2
        int start = 0, end = nums2.length-1;
        
        Arrays.sort(nums1); // O(mlogm)
        Arrays.sort(nums2); // O(nlogn)
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums1.length; i++) { // O(m)
            int startIndex = binarySearch(nums2, start, end, nums1[i]); // O(logn)
            
            if (startIndex != -1) {
                result.add(nums1[i]);
                start = startIndex + 1;
            }
        }
        
        int[] res = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) { // O(k) where k = number of common elements in nums1 & nums2
            res[i] = result.get(i);
        }
        
        return res; // return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int binarySearch(int[] nums2, int start, int end, int target) {
        
        while (start <= end) {
            int mid = start + (end-start)/2;
            
            if (nums2[mid] == target) {
                if (mid == start || nums2[mid] > nums2[mid-1]) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else if (nums2[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return -1;
	}
}