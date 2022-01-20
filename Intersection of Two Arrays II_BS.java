//https://leetcode.com/submissions/detail/624031071/
// Time:O(m log n)
//Space: O(n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //
        if(nums1 == null || nums2 == null) {
            return new int[0];
        }
        
        List<Integer> li = new ArrayList<>();
        //Making sure the 2nd array is the largest one.
        if(nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0; int high = nums2.length - 1;
        for(int i=0; i < nums1.length; i++) {
            //binary search on longer array
            int bsIndex = binarySearch(nums2, low, high, nums1[i]);
            if(bsIndex != -1) {
                low = bsIndex + 1;
                li.add(nums1[i]);
            }
        }
        
        int[] result = new int[li.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = li.get(i);
        }       
        return result;
    }
    
    private int binarySearch(int[] arr, int low, int high, int target) {  //Leftmost index of the target
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] == target) {
                //leftmost index or this is the left most index
                if(mid == low || arr[mid] > arr[mid - 1]){
                    return mid;
                } else {
                    //keep moving left;
                    high = mid - 1;
                }
            } else if(arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}