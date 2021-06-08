/*
Running Time Complexity: O(n(logm))
Space complexity: O(m) Result list is being used 
Successfully Run and Compiled on leetcode 

*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if( nums1==null || nums2==null) return null;
        int n1 = nums1.length; int n2 = nums2.length;
        if(n2>n1){
            intersect(nums2,nums1);
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);        
        Arrays.sort(nums2);
        
        int low = 0; int high = nums2.length-1;
        for(int num:nums1){
            int temp = Binary(num, nums2, low, high);
            if(temp != -1){
                result.add(num);
                low = temp + 1;
            }
        }
        int[] resultarr = new int[result.size()];
        for(int i = 0;i<resultarr.length;i++){
            resultarr[i] = result.get(i);
        }
        return resultarr;
    }
    private int Binary(int n, int[] nums, int low, int high){
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == n){
                if(mid==low || nums[mid]>nums[mid-1]){
                    return mid;    
                }else{
                    high = mid -1;
                }
            }
            else if(nums[mid]>n){
                high = mid - 1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}