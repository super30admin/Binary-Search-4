// HashMap Solution
// Time Complexity : O(m + n)
// Space Complexity : O(m + n)
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class IntersectionofTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        // null case
        if(nums1 == null || nums2 == null) return new int[0];
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        int m = nums1.length; int n = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for(int num: nums2) {
            if(map.containsKey(num)) {
                result.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
        int[] arr = new int[result.size()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}

// Binary Search Solution
// Time Complexity : O(mlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes



class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // null case
        if(nums1 == null || nums2 == null) return new int[0];
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        Arrays.sort(nums1); Arrays.sort(nums2);
        int m = nums1.length; int n = nums2.length;
        int p1 = 0; int p2 = 0;
        List<Integer> result = new ArrayList<>();
        int low = 0; int high = n - 1;
        for(int i = 0; i < nums1.length; i++) {
            int bsIndex = binarySearch(nums2, low, high, nums1[i]);
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

    private int binarySearch(int arr, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) {
                if(arr[mid] > arr[mid - 1]) return mid;
                else high = mid - 1;
            }
            else if(arr[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
    }
}