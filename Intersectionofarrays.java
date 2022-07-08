//Time : O(mlogn)
//Space : O(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> li = new ArrayList<>();
        int low = 0;
        int high = nums2.length - 1;
        for (int i = 0; i < nums1.length; i++) {
            int bsin = binarySearch(nums2, low, high, nums1[i]);
            if (bsin != -1) {
                li.add(nums1[i]);
                low = bsin + 1;
            }
        }
        int[] result = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            result[i] = li.get(i);
        }
        return result;

    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (low != mid && nums[mid] == nums[mid - 1]) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }
}