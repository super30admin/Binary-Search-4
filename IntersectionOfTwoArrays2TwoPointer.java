class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        //int[] result = new int[]
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                nums1[k] = nums1[i];
                k++;
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOf(nums1, k);
    }
}