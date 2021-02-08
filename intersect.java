/*
 binary Search
time complexity: O(log n)
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums2.length < nums1.length){
            return intersect(nums2, nums1);
        }
              

        
        Arrays.sort(nums1);
        Arrays.sort(nums2);    
        int low = 0;
        int high = nums2.length-1;
        for(int i = 0; i < nums1.length;i++){
            int bsIndex = BinarySearch(nums2,nums1[i],low,high);
            if(bsIndex != -1){
                list.add(nums1[i]);
                low = bsIndex+1;
            }
        }
        
        int[]ans = new int[list.size()];
        for(int i = 0;i < ans.length;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    
    private int BinarySearch(int[]nums,int target, int low, int high){
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                if(mid == low || nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                    high = mid-1; //keep moving left until find first index, to eliminate duplicates
                }
            }
            else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
            
                
        }
        return -1;
    }
}
