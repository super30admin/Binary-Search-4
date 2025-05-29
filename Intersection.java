// Time complexity :O(log(n))
// Space Complexity :O(1);
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0)
            return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            int BS = binarySearch(nums2, index, nums1[i]);
            if (BS < nums2.length && nums2[BS] == nums1[i]) {
                list.add(nums1[i]);
                index = BS + 1;
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int element : list) {
            res[i++] = element;
        }
        return res;
    }

    public int binarySearch(int[] nums, int index, int target) {
        int left = index, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

}