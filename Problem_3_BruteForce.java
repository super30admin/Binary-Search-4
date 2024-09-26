// Time complexity - O(m+n)
// Space complexity - O(m+n)

// Merge and sort

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+nums2.length];
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] <= nums2[p2]){
                arr[i] = nums1[p1];
                p1++;
            }else{
                arr[i] = nums2[p2];
                p2++;
            }
            i++;
        }
        while(p1 < nums1.length){
            arr[i] = nums1[p1];
            i++;
            p1++;
        }
        while(p2 < nums2.length){
            arr[i] = nums2[p2];
            i++;
            p2++;
        }
        double r;
        int size = arr.length;
        if(size%2 != 0){
            r = arr[size/2];
        }else{
            System.out.print(arr[size/2] +"-" + arr[((size/2)-1)]);
            r = (arr[size/2]+arr[(size/2)-1])/2;
        }
        int mid = size/2;
        if (size%2 != 0) {
            return (double) arr[mid];
        } else {
            return ((double) arr[mid] + (double) arr[mid - 1]) / 2;
        }
    }
}
