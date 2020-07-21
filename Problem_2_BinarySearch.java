// Time complexity - O(mlogn)
// Space complexity - O(1)

// ApplyBinary search to find index of left most index.

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
     if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];
        List<Integer> list = new ArrayList<>();
        if(nums1.length > nums2.length) return intersect(nums2,nums1); 
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;
        for(int n : nums1){
            int bsIndex = binarySearch(nums2, n, index, nums2.length-1);
            if(bsIndex != -1){
                list.add(n);
                index = bsIndex + 1;
            }
        }
         int[] result = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            result[i] = list.get(i);
        }
        return result;
    }
    
    private int binarySearch(int[] nums, int num, int low, int high){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(num == nums[mid]){
                if( mid == low || nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if(nums[mid] > num){
                high = mid - 1;
            }else{
                low = mid + 1; 
            }
        }
        return -1;  
    }
}
