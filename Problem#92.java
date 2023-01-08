// Intersection of Two Arrays II

// Time Complexity : O(n log m), where n is the length of the smaller array and n is the length of the larger array
// Space Complexity : O(k), where k is the size of the intermediate list (this is then converted to output array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return(intersect(nums2, nums1));
        int m = nums1.length;
        int n = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0;
        List<Integer> li = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int bsIndex = binarySearch(nums2, low, n-1, nums1[i]);
            if(bsIndex != -1){
                li.add(nums2[bsIndex]);
                low = bsIndex + 1;
            }
        }
        int[] result = new int[li.size()];
        for(int i = 0; i < li.size(); i++){
            result[i] = li.get(i);
        }
        return result;
    }

    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target){
                if(mid == low || arr[mid] != arr[mid-1])
                    return mid;
                else
                    high = mid - 1; 
            } else if(arr[mid] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}