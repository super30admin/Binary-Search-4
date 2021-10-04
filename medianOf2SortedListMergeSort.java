class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0; int j = 0;
        double[] arr = new double[nums1.length+nums2.length];
        int k = 0;
        while(k < arr.length) {
            while(i<nums1.length && j< nums2.length) {
                if(nums1[i]<=nums2[j]) {
                    arr[k] = nums1[i];
                    i++; k++;
                } else {
                    arr[k] = nums2[j];
                    j++; k++;
                }
            }
            while(i<nums1.length) {
                arr[k] = nums1[i];
                i++; k++;
            }
            while(j< nums2.length) {
                arr[k] = nums2[j];
                j++; k++;
            }
        }
        if(arr.length%2!=0) return arr[(arr.length-1)/2];
        return (arr[(arr.length-1)/2] + arr[((arr.length-1)/2) +1])/2;
    }
}