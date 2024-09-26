// Time Complexity : O(m+n) and O(mlogn)
// Space Complexity : O(m+n) considering the list used to capture result
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
class Solution {
    
    //O((n+m)) solution for already sorted arrays
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        
        int m = nums1.length-1; int n = nums2.length-1;
        
        int low = 0, high = 0;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        while(low <= m && high <= n) {
            if(nums1[low] == nums2[high]) {
                res.add(nums1[low]);
                low++;
                high++;
            }else if(nums1[low] < nums2[high]) {
                low++;
            }else {
                high++;
            }
        }
        
        int[] resArr = new int[res.size()];
        
        int i = 0;
        for(int num: res){
            resArr[i++] = num;
        }
        
        return resArr;
    }
    
    //O(m logn) solution for sorted arrays using binary search
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        
        int m = nums1.length-1; int n = nums2.length-1;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int low = 0;
        for(int num:nums1) {
            int index = bSearch(nums2, low, n, num);
            
            if(index != -1) {
                res.add(nums2[index]);
                low = index+1;
            }
        }
        
        int[] resArr = new int[res.size()];
        
        int i=0;
        for(int num:res){
            resArr[i++] = num;
        }
        
        return resArr;
    }
    
    private int bSearch(int[] arr, int low, int high, int target) {
        
        while(low <= high) {
            
            int mid = low + (high - low) /2;
            
            //extra condition to give preferrence to left element in case of duplicates
            if(arr[mid] == target && (mid == low || arr[mid-1] < arr[mid])){ 
                    return mid;
               
            }else if(target > arr[mid]){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        
        return -1;
    }
}