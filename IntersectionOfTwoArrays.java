// Time Complexity : O(n log(m)) --> where n & m are the lengths of input array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (350): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Binary search O(n log(m)) solution {considering arrays are sorted - according to follow up question}
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        // edge case
        if (nums1 == null || nums2 == null || n1 == 0 || n2 == 0) return new int[0];
        if (n1 > n2) return intersect(nums2, nums1); // to reduce space
        
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(nums1); Arrays.sort(nums2);
        int index = 0; // initial low of second array
        
        for (int num : nums1) {
            // binary search index in second array
            int bsIndex = binarySearch(nums2, num, index, nums2.length-1);
            if (bsIndex != -1) {
                ls.add(num);
                index = bsIndex + 1;
            }
        }
        
        int result[] = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) result[i] = ls.get(i);
        return result;
    }
    
    private int binarySearch(int nums[], int target, int low, int high) {
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                if (mid == low || nums[mid] > nums[mid - 1]) return mid;
                else high = mid - 1;
            }
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}