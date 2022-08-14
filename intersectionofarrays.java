// TC : O(mlogn)
// SC : O(1)

// BINARY SEARCH SOLUTION

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length ==0) return new int[] {};
        
        List<Integer> result = new ArrayList<>();
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2<n1){
            return intersect(nums2,nums1);
        }
        
       Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int low=0;
      
        for(int i=0;i<nums1.length;i++){
            int binaryidx = binarysearch(nums2,low,n2-1,nums1[i]);
            if(binaryidx != -1){
                result.add(nums1[i]);
                low = binaryidx + 1;
            }
        }
        
        int[] answer = new int [result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    private int binarysearch(int[] nums ,int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid-1]<nums[mid]){
                    return mid;
                }
                else{
                    high=mid-1;
                }
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        
            return -1;
    }
}