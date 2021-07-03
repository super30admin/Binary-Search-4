//time complexity O(nlog(m))
//space complexity O(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 ||
           nums2 == null || nums2.length == 0) return new int[0];
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums1); Arrays.sort(nums2);
        int index = 0;
        for(int i =0; i < nums1.length; i++){
            int bsIdx = binarySearch(nums2, index, nums1[i]);
            if(bsIdx != -1){
                li.add(nums1[i]);
                index = bsIdx+1;
            }
        }
        int[] result = new int[li.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = li.get(i);
        }
        return result;
    }

    private int binarySearch(int [] nums, int index, int target){
        int low = index;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == low || nums[mid] > nums[mid-1]) return mid;
                else{
                    high = mid -1;
                }
            } else if(nums[mid] > target){
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

