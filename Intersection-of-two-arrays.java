// In this problem, we are trying to put the smaller array in hashmap along with the count of occurences of each value. Then iterating
// through the second array and looking in hashmap, if found adding in result and decreasing its frequency by 1. 

// Time Complexity : O(m+n)
// Space Complexity : O(min(m,n)) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Base Case
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[] {};
        }
        int m = nums1.length;
        int n = nums2.length;
        // This will make sure that nums1 is having the smaller number of elements
        if (m > n) {
            intersect(nums2, nums1);
        }
        // Declare frequency map
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        // Iterate through smaller(first) array and put it in hashmap
        for (int i = 0; i < m; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        // Iterate through second
        for (int i = 0; i < n; i++) {
            // Look in hashmap
            if (map.containsKey(nums2[i])) {
                // If found add to the result
                result.add(nums2[i]);
                // Decrease its freq by 1
                int val = map.get(nums2[i]);
                val--;
                // Put the updated value
                map.put(nums2[i], val);
                // If freq is 0, remove from hashmap
                map.remove(nums2[i], 0);

            }
        }
        // We have to return integer array, so iterate through result list and put it in
        // array
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;

    }
}

// By sorting and two pointers
// Time Complexity : O(mlogm) + O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[] {};
        }
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            intersect(nums2, nums1);
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] == nums2[p2]) {
                result.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;

    }
}

// By sorting and binary search - Sorting both arrays. Iterating through smaller
// array and doing a BS on larger array, if found
// the first occurence match, return the position and add to result and for the
// next element do a BS on index one more than the
// current index.
// Time Complexity : O(mlogm) + O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Base Case
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[] {};
        }
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            intersect(nums2, nums1);
        }
        List<Integer> result = new ArrayList<>();
        // Sorting both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0;
        // Iterate through smaller array
        for (int i = 0; i < m; i++) {
            // Perform the BS on larger array and look for the nums1[i] element
            int BSindex = BinarySearch(nums2, low, n - 1, nums1[i]);
            // If found add to the result and change low to one index more, for the next
            // binary search
            if (BSindex != -1) {
                result.add(nums1[i]);
                low = BSindex + 1;
            }
        }

        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;

    }

    private int BinarySearch(int[] nums2, int low, int high, int target) {
        // Do till low <=high
        while (low <= high) {
            // Calculate mid
            int mid = low + (high - low) / 2;
            // If the mid value is equal to the target
            if (nums2[mid] == target) {
                // Check if its the first occurence
                if (mid == low || nums2[mid - 1] != target) {
                    // Then return mid
                    return mid;
                }
                // If not first occurence, we will find first in the left part since the array
                // is sorted
                high = mid - 1;
            }
            // If the target value is greater than the mid, than move to the right
            else if (nums2[mid] < target) {
                low = mid + 1;
            } else {
                // Else left
                high = mid - 1;
            }
        }
        // If not found, return -1
        return -1;
    }
}