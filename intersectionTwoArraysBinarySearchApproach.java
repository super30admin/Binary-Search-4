/*
 * TIme complexity - O(mxlog(n))
 * Space complexity - O(min(m,n)) - constant
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return new int[]{};
        }
        int m = nums1.length;
        int n = nums2.length;
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(m<n){ // make sure nums1 is always smaller
            intersect(nums2, nums1);
        }
        int low = 0;
        int high = n - 1; // length of smaller array
        for(int i = 0; i< m; i++){
            int target = nums1[i];
            int bsIndex = binarySearch(nums2, low, high, target);
            if(bsIndex != -1){
                result.add(nums1[i]);
                low = bsIndex + 1;
            }
        }

        int[] finalResult = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }

    private int binarySearch(int[] nums, int low, int high, int target){
        while( low <= high){
            int mid = low + (high - low)/2; // to prevent integer overflow
            if(nums[mid] == target){
                if(mid == low || nums[mid - 1] != target){
                    return mid;
                }
                high = mid - 1;
            } else if(target > nums[mid]){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return -1;
    }
}