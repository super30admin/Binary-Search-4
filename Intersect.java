// Time Complexity : O(m*logn + nlogn + mlogm)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[] {};
        }
        int n1 = nums1.length, n2 = nums2.length;
        
        if(n1 < n2) {
            return intersect(nums2, nums1);
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> result = new ArrayList<>();
        
        int low = 0, high = n2-1;
        
        for(int num: nums1) {
            int position = binarySearch(nums2, low, high, num);
            if(position != -1) {
                result.add(num);
                low = position + 1;
            }
        }
        
        int[] answer = new int[result.size()];
        
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    private int binarySearch(int[] nums, int low, int high, int target) {
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(target == nums[mid]) {
                if(low == mid || nums[mid - 1] < nums[mid]) {
                    return mid;
                }
                else
                {
                    high = mid - 1;
                }
            }
            else if(target > nums[mid]) {
                low = mid + 1;
            }
            else 
            {
                high = mid - 1;
            }
        }
        return -1;
    }
}