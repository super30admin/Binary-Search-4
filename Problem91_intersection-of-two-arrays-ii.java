// TC : O(m log n), where m = smaller array size, n = larger array size
// SC : O(m)
import java.util.*;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[]{};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(nums1.length > nums2.length)
            return intersect(nums2, nums1);
        int low = 0;
        int high = nums2.length - 1;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            int bsIndex = binarySearch(nums2, low, high, nums1[i]);
            // -1 or an index
            if(bsIndex != -1) {
                result.add(nums1[i]);
                low = bsIndex + 1;
            }
        }
        int[] arr = new int[result.size()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
    
    private int binarySearch(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + ((high - low) / 2);
            if(nums[mid] == target) {
                if(low == mid || nums[mid] > nums[mid - 1])
                    return mid;
                else
                    high = mid - 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}