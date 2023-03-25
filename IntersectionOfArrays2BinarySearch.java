class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int ind = 0;
        for(int i = 0; i < nums1.length; i++) {
            int pos = binarySearch(nums2, ind, nums1[i]);
            if(pos < nums2.length && nums2[pos] == nums1[i]) {
                list.add(nums1[i]);
                ind = pos + 1;
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for(int element : list) {
            res[i] = element;
            i++;
        }
        return res;
    }
    private int binarySearch(int[] nums, int i, int target) {
        int l, r;
        l = i;
        r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}