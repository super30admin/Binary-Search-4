// Time Complexity : O(log n) + O(m log n) where n is the length of the smaller array and m is the length of the larger array.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Sort both the arrays and perform binary search on larger array.
 * 2. Check if the element in the smaller array is present in the larger array using binary search and also reduce the search space by updating the low pointer.
 * 3. If the element is found, add it to the result list and return the result.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 > n2)
            intersect(nums2, nums1);
        
        int low = 0, high = n2-1;
        List<Integer> result = new ArrayList<>();

        for(int num : nums1){
            if(firstOccurance(nums2, num, low, high) != -1){
                int newLow = firstOccurance(nums2, num, low, high);
                low = newLow + 1;
                result.add(num);
            }
        }

        int[] res = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            res[i] = result.get(i);
        }

        return res;
    }

    private int firstOccurance(int[] nums, int target, int low, int high){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(low == mid || nums[mid-1] != target) 
                    return mid;
                high = mid-1;
            }else if(nums[mid] > target){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }
}