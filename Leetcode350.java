class Solution {
    // Solution - Binary Search on Bigger nums array and iterate over small nums
    // array
    // TC - nlog(m)
    // SC - O(k) just for the arraylist conversion to int[] result.
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length; // shorter
        int m = nums2.length; // longer
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();

        if (n > m) {
            return intersect(nums2, nums1);
        }
        int low = 0;
        int high = m - 1;
        for (int i = 0; i < n; i++) {
            int curr = nums1[i];
            int val = helper(nums2, curr, low, high);
            if (val != -1) {
                res.add(curr);
                low = val + 1;
            }

        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;

    }

    private int helper(int[] nums, int curr, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == curr) {
                if (mid == low || nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;

                }
            } else if (nums[mid] < curr) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}