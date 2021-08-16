class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m, n;
        m = nums1.length;
        n = nums2.length;
        if(m > n) {
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> temp = new ArrayList<>();
        int low, high;
        low = 0;
        high = n - 1;
        for(int i = 0; i < m; i++) {
            int found = binarySearch(nums2, nums1[i], low, high);
            if(found != -1) {
                temp.add(nums1[i]);
                low = found + 1;
            }
        }
        int[] res = new int[temp.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = temp.get(i);
        }
        return res;
    }
    private int binarySearch(int[] nums, int k, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == k) {
                if(mid == low || nums[mid] > nums[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if(nums[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}