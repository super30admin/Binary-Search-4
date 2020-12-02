package Nov29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        /*
        Time complexity: O(m log n) because O(log n) time complexity for binary search on the larger array of n length. And we do this for each of the m elements in the smaller array.
       
       Space complexity: O(1) because no additional space used.
       
       Approach: 
       Elements of smaller array are picked up one by one for binary search in the larger array. When an element is found in larger array, then binary search range for next element gets reduced from current range to (start=pos found for prev element) TO (end=end of longer string).
       
        */
        List<Integer> res = new ArrayList<>();
        
        // edge
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        int nums1len = nums1.length;
        int nums2len = nums2.length;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        // this ques is solved assuming that nums1 is smaller in length compared to nums2
        // so if that is not the case, call the function with params reversed
        if (nums1len > nums2len) {
            return intersect(nums2, nums1);
        }
        
        int index = 0;
        
        for (int i = 0; i < nums1.length; i++) {
            int bsIndex = binarySearch(nums2, index, nums2len-1, nums1[i]);
            if (bsIndex == -1) {
                continue;
            }
            res.add(nums1[i]);
            index = bsIndex + 1; 
        }
        
        int[] result = new int[res.size()];
        
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        
        return result;
        
    }
    
    private int binarySearch(int[] arr, int start, int end, int target) {
        
        int mid = 0;
        
        while (start <= end) {
            mid = start + (end-start)/2;
            if (arr[mid] == target) {
                if (mid == start || arr[mid-1] < arr[mid]) {
                    return mid;
                } else {
                    end = mid-1;
                }
            }
            else if (arr[mid] < target) {
                start = mid+1;
            } 
            else {
                end = mid-1;
            }
        }
        
        return -1;
    }
}