// Time Complexity : O(n log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class IntersectionOfTwoArrays {
    // Using Binary Search
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) {
            return new int[] {};
        }
        int m = nums1.length;
        int n = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(m < n) {
            intersect(nums2, nums1);
        }
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = n - 1;
        for(int i = 0; i < m; i++) {
            int target = nums1[i];
            int bsIndex = binarySearch(nums2, low, high, target);
            if(bsIndex != -1) {
                result.add(nums1[i]);
                low = bsIndex + 1;
            }
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == low || nums[mid - 1] != target) {
                    return mid;
                }
                high = mid - 1;
            } else if(target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}