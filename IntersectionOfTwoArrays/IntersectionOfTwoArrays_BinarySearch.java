/* Time Complexity : O(m log n)  - provided we consider both arrays to be sorted
*   m - len of array - smaller array
*   n - len of array - larger array */
/* Space Complexity : O(k) 
*   k - len of result stored in the list - li */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Binary Search solution

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // To create hashmap of the smaller array
        if(m > n) return intersect(nums2, nums1);
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums1); //m log m
        Arrays.sort(nums2); //n log n
        int low = 0;
        int high = n - 1;
        //Iterate over the smaller array
        for(int i = 0; i < m; i++){
            int target = nums1[i];
            int idx = binarySearch(nums2, low, high, target);
            if(idx != -1){//ele found in larger array
                low = idx + 1;
                li.add(target);
            }
        }
        //Iterate over list and add to result
        int[] result = new int[li.size()];
        for(int i = 0; i < li.size(); i ++){
            result[i] = li.get(i);
        }
        return result;
    }

    private int binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                //find the left most ele
                if(mid == low || nums[mid - 1] < nums[mid]){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}