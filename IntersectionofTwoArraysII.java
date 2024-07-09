// Time Complexity : O(m logm + nlogn + m logn)
// Space Complexity : o(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Sort and Swap if Needed: The arrays are sorted, and if the first array is longer, the arrays are swapped to minimize the search time.
//Binary Search for Intersection: For each element in the first array, a binary search is performed on the second array to find common elements.
//Collect and Return Results: Common elements are collected in a list, which is then converted to an array to return the intersection.

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return new int[] {};
        }
        int m = nums1.length;
        int n = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(m < n){
            intersect(nums2, nums1);
        }
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = n-1;
        for(int i =0; i< m; i++){
            int target = nums1[i];
            int bsIndex = binarySearch(nums2, low, high, target);
            if(bsIndex != -1){
                result.add(nums1[i]);
                low = bsIndex+1;
            }
        }
        int [] ans = new int[result.size()];
        for(int i =0; i< result.size(); i++){
            ans[i] = result.get(i);
        }
        return ans;
    }

    private int binarySearch(int[] nums2, int low, int high, int target){
        while(low <= high){
            int mid = low+(high -low)/2;
            if(nums2[mid] == target){
                if(mid == low || nums2[mid-1]!= target){
                    return mid;
                }
                high = mid - 1;
            }
            else if(target > nums2[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}