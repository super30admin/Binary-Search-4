import java.util.*;

/**
 * Leetcode 350. Intersection of Two Arrays II
 * Link: https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 */
public class IntersectionTwoArraysII {
    /**
     * This is a classic nested iteration problem. To reduce the n^2 TC, we can instead lookup the frequency of the outer
     * loop inside the second list in constant time by preparing a frequency map of their elements.
     *
     * TC: O(max(m,n))
     * SC: O(min(m,n))
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num: nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num: nums2) {
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) - 1);
                result.add(num);
                freq.remove(num, 0);

                if (freq.isEmpty()) {
                    return result.stream().mapToInt(i -> i).toArray();
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}

// ----------------------------- FOLLOWUP - If arrays are sorted --------------------------------
//------------------------------------ Solution 1 -----------------------------------
class IntersectionTwoArraysII1 {
    /**
     * If given arrays were sorted we could solve given problem using 2 pointers each at the start of the list
     * if both elements are same we found one intersection add that element to result, in case they are not same
     * move one of the pointers towards the other by comparing their values. Keep doing this until one of the pointer
     * reaches end of the list
     *
     * TC: O(m + n)
     * SC: O(min(m,n)) this is the space used by intermediate list used as result
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return result.stream().mapToInt(k -> k).toArray();
    }
}

//------------------------------------ Solution 2 -----------------------------------
class IntersectionTwoArraysII2 {
    /**
     * Binary search solution in which we will iterate over smaller array linearly. For each element
     * in smaller array find the first occurrence of same number in second array using binary search
     * To handle repeats reduce the search space of subsequent binary search once an element is found
     * from that point onwards in the second array
     *
     * TC: O(mlogn) m -> length of smaller array, n -> length of longer array
     * SC: O(min(m,n)) this is the space used by intermediate list used as result
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int low = 0, high = nums2.length - 1;

        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];

            int idx = binarySearch(nums2, low, high, num);
            if (idx != -1) {
                result.add(num);
                low = idx + 1;
            }

        }
        return result.stream().mapToInt(k -> k).toArray();
    }

    private int binarySearch(int[] nums2, int low, int high, int num) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums2[mid] == num) {
                if (mid == low || nums2[mid] != nums2[mid - 1]) {
                    return mid;
                }
                high = mid - 1;
            } else if (nums2[mid] > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}