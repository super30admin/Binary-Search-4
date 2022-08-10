// Time Complexity: O(n1 log n1(for sorting Array 1) + n2 log n2(for sorting Array 2) + n1 * log n2(for binary search) )
// Space Complexity: O()
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: NO

// Your code here along with comments explaining your approach: Used Binary search to find the target and then again used binary search to get the first occurance

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int [] {};
        
        //Using Binary Search for Solution
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2 < n1) return intersect (nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        
        int low = 0;
        for(int i = 0;i <nums1.length; i++){
            int bIndex = binarySearch(nums2, low, n2 - 1, nums1[i]);
            if(bIndex != -1){
                result.add(nums1[i]);
                low = bIndex + 1;
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
    private int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                if(mid == low || nums[mid - 1] < nums[mid]){
                    return mid;
                }
                high = mid - 1;
            }
            else if(target > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }            
        }
        return -1;
    }
}