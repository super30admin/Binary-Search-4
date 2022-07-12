// Time Complexity : O(mlogn)
// Space Complexity : O(min(m,n)) // to store result
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // binary search on bigger array
        if (nums2.length > nums1.length)
            return intersect(nums2, nums1);
        
        int m = nums1.length;
        
        int n = nums2.length;
    
        int l = 0;
        int r = m - 1;
        List<Integer> li = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int bsIndex = binarySearch(nums1, l, r, nums2[i]);
            if (bsIndex != -1) {
                li.add(nums2[i]);
                l = bsIndex + 1;
            }
        }
       
        int[] result = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            result[i] = li.get(i);
        }
        return result;

    }
    private static int binarySearch(int[] nums, int l, int r, int target) {

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                if (mid == l || nums[mid] != nums[mid - 1]) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
    
}