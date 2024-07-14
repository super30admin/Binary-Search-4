// Time Complexity : O(m log n)
// Space Complexity : O( min(m,n) )
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[] {};
        }
        int m = nums1.length;
        int n = nums2.length;
        if (m < n) {
            intersect(nums2, nums1); // call the function again and make sure nums1 is bigger
        }
        Arrays.sort(nums1); // sorting
        Arrays.sort(nums2); // sorting
        List<Integer> res = new ArrayList<>();
        int low = 0;
        int high = n - 1;
        for (int i = 0; i < m; i++) {
            int target = nums1[i];
            int bsIndex = binarySearch(nums2, low, high, target); // index of the new found element
            if (bsIndex != -1) {
                res.add(nums1[i]); // adding to the resultant list
                low = bsIndex + 1; // decrease search space
            }
        }
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        } // converting the list to int[]

        return answer;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) { // target hit
                if (mid == low || nums[mid - 1] != target) { // checking if first occurence
                    return mid;
                }
                high = mid - 1; // decreasing search space, move left.
            } else if (target > nums[mid]) {
                low = mid + 1; // move right
            } else {
                high = mid - 1; // move left
            }
        }
        return -1; // not found
    }
}