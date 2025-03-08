// Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

// Time Complexity : O(mlog(n)) i.e., m is smaller array n is larger array
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, traverse along the smaller array linearly and do binary search on 2nd array. For each element in 1st array do binary search
 * on 2nd from low to high and if found return index and increase low to index+1. Add all elements at indices returned to a list. 
 * Add all elements of list to integer array and finally return the integer array.
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m>n) return intersect(nums2, nums1);
        int p1 = nums1[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0;
        int high = n-1;
        List<Integer> li = new ArrayList<>();
        for(int i = 0; i< m;i++){
            int target = nums1[i];
            int index = binarySearch(nums2, low, high, target);
            if(index != -1){
                li.add(target);
                low = index + 1;
            }
        }
        int []re = new int[li.size()];
        for(int i = 0; i<li.size();i++){
            re[i] = li.get(i);
        }
        return re;
    }
    //to find the starting index
    private int binarySearch(int[] nums2, int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums2[mid] == target){
                if(mid == low || nums2[mid]>nums2[mid-1]){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }
            else if (nums2[mid]>target){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
