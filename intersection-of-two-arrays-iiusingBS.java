class Solution {
    //TC: O(mlog(n))
    //SC : O(1)
    //Binary search solution
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return intersect(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int low = 0; int high = n2 -1;
        for(int i = 0; i < n1; i++){
            int bsIdx = binarysearch(nums2,low,high,nums1[i]);
            if(bsIdx != -1) 
            {
                res.add(nums1[i]);
                low = bsIdx + 1;
            }
        }
        
        int [] result = new int[res.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = res.get(i);
        }
        return result;
    }

    private int binarysearch(int [] nums, int low , int high, int target){
        while(low <= high){
            int mid = low + (high -low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid] > nums[mid -1]){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if(nums[mid] > target){
                high = mid - 1;
            }else low = mid + 1;
            
        }
        return -1;
    }
}