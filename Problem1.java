// Time Complexity : O(nlogm)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(nums2.length > nums1.length)
            return intersect(nums2,nums1);
        List<Integer> res = new ArrayList<>();
        int lo = 0; 
        for(int i = 0; i < nums2.length; i++){
            int num = nums2[i];
            int idx = binarySearch(num,nums1,lo);
            if(idx != -1){
                res.add(nums1[idx]);
                lo = idx+1;}
            
        }
        int[] ans = new int[res.size()];
        for(int i = 0; i < ans.length; i++)
            ans[i] = res.get(i);
        return ans;
    }
    private int binarySearch(int target, int[] arr,int lo){
        int hi = arr.length-1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid]==target){
                if(lo == mid || arr[mid]>arr[mid-1])
                    return mid;
                hi = mid - 1;
            }
            else if(arr[mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }
}