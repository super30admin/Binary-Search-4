// approch 1
// Time Complexity : O(m+n)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2 
// Time Complexity : O(m+n)
// Space Complexity : O(min(m,n)) // to store result
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 3
// Time Complexity : O(mlogn)
// Space Complexity : O(min(m,n)) // to store result
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {

    // approch 1 using hashmap
    public static int[] intersect1(int[] nums1, int[] nums2) {
        // store smaller in hashmap and looping in bigger array
        if (nums2.length > nums1.length)
            return intersect1(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<>();
        // put element and its count in map
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // to store result
        List<Integer> li = new ArrayList<>();
        for (int num : nums1) {
            // if num is available in map that means it is available in array 1 so we add it
            // into the list and remove it from map
            // as we visited this element
            if (map.containsKey(num)) {
                li.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
        // System.out.println(li);
        // result array
        int[] result = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            result[i] = li.get(i);
        }
        return result;
    }

    // approch 2 using two pointers assuming array is sorted
    public static int[] intersect2(int[] nums1, int[] nums2) {
        // sorting both the arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // two pointers
        int p1 = 0;
        int p2 = 0;
        int m = nums1.length;
        int n = nums2.length;
        List<Integer> li = new ArrayList<>();
        // if both element are same at both pointer advance both pointer and add it into
        // result
        // else advance whichever is smaller element
        while (p1 < m && p2 < n) {
            if (nums1[p1] == nums2[p2]) {
                li.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                p1++;
            }
        }

        // result array
        int[] result = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            result[i] = li.get(i);
        }
        return result;

    }

    // approch 3 using binary search
    public static int[] intersect3(int[] nums1, int[] nums2) {
        // sorting both the arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // binary search on bigger array
        if (nums2.length > nums1.length)
            return intersect3(nums2, nums1);
        // bigger one
        int m = nums1.length;
        // smaller one
        int n = nums2.length;
        // left and right for binary search
        int l = 0;
        int r = m - 1;
        List<Integer> li = new ArrayList<>();

        // normal traverse in smaller array
        for (int i = 0; i < n; i++) {
            int bsIndex = binarySearch(nums1, l, r, nums2[i]);
            if (bsIndex != -1) {
                li.add(nums2[i]);
                // to handle same elements
                l = bsIndex + 1;
            }
        }

        // System.out.println(li);
        // result array
        int[] result = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            result[i] = li.get(i);
        }
        return result;

    }

    // to find first occurences of the character
    private static int binarySearch(int[] nums, int l, int r, int target) {

        // binary search
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                if (mid == l || nums[mid] != nums[mid - 1]) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 1, 2, 2 };
        int[] nums2 = new int[] { 2, 2 };
        System.out.println(Arrays.toString(intersect1(nums1, nums2)));
        System.out.println(Arrays.toString(intersect2(nums1, nums2)));
        System.out.println(Arrays.toString(intersect3(nums1, nums2)));

    }
}