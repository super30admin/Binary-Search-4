import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {

    // 2 pointer solution
    // TC: O(m * log m + n * log n + m + n) = O(m * log m + n * log n)
        //  m - nums1.length   n - nums2.length
    // SC: O(1)
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[]{};

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        int p1 = 0, p2=0;

        while(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] == nums2[p2]){
                result.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1] < nums2[p2]){
                p1++;
            }else {
                p2++;
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue).toArray();
    }

    // Binary search solution
    // TC : O(n * log m)
        // n - length of nums2 or larger array
        // m - length of nums1 or smaller array
    public int[] intersect2(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[]{};

        // This is to make sure that nums1 is always a smaller array and nums2 is always the larger array
        // We'll do binary search on larger array and sequential iteration on the smaller array to iterate less elements
        if(nums2.length < nums1.length) return intersect(nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        int low = 0, high = nums2.length - 1;
        for(int i=0; i < nums1.length; i++) {
            int bIndex = binarySearch(nums2, low, high, nums1[i]);

            if(bIndex != -1) {
                result.add(nums1[i]);
                low = bIndex + 1;
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue).toArray();
    }

    // If a number is found, we need to find out its left most occurrence to handle duplicate elements
    private int binarySearch(int[] nums, int low, int high, int target) {

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) { // here we need to find the left most occurrence of the matched element
                if(mid == low || nums[mid - 1] < nums[mid]){
                    return mid;
                }
                high = mid - 1; // it will find the leftmost occurrence. So, we need to search in the left half
            }else if(nums[mid] < target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return -1;
    }
    // [1,2,3,4,4,5,7,9]
    // [3,4,4,7,9]

    // Wrong here
    // [1,2,2,1]
    // [2,2]
}
