class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        List<Integer> result = new ArrayList<>();
        int left = 0;

        for (int num : nums1) {
            int index = binarySearch(nums2, num, left);
            if (index != -1) {
                result.add(num);
                left = index + 1;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int binarySearch(int[] arr, int target, int left) {
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                if (mid == left || arr[mid - 1] != target) {
                    return mid;
                }
                right = mid - 1; 
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; 
    }
}
