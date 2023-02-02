// Time Complexity : O(max(m,n)), m and n are the length of nums1 and nums2
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
/*
 * create a hashmap to store the elemeents of the smaller array.
 * iterate over the larger array and check if the element is present in the map, if so remove the count from the map.
 * if there are common elements, add it to the result array.
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n)
            return intersect(nums2, nums1);

        List<Integer> li = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            if (map.containsKey(num)) {
                li.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }

        int[] result = new int[li.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = li.get(i);
        }

        return result;
    }
}

// Binary Search

// Time Complexity : O(mlogn), m and n are the length of nums1 and nums2,
// assuming the arrays are sorted.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three
// sentences only
/*
 * sort the arrays. and check every element in the smaller array and do binary
 * search in the larger array to find the element in it.
 * store the list in the result array.
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n)
            return intersect(nums2, nums1);

        List<Integer> li = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int low = 0, high = n - 1;

        for (int i = 0; i < m; i++) {
            int target = nums1[i];
            int bsIdx = binarySearch(nums2, low, high, target);
            if (bsIdx != -1) {
                li.add(target);
                low = bsIdx + 1;
            }
        }

        int[] result = new int[li.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = li.get(i);
        }

        return result;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                if (mid == low || arr[mid] != arr[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}