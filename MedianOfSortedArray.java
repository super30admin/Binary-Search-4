//TC: O(m+n) m is the length of first array and n is the length of second array
//SC: O(m+n) 

import java.util.Arrays;

public class MedianOfSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length+nums2.length];
        // Merging two arrays
        for(int i=0; i<nums1.length; i++){
            res[i] = nums1[i];
        }
        for(int i=0; i<nums2.length; i++){
            res[nums1.length+i] = nums2[i];
        }
        //Sorting the merrged array
        Arrays.sort(res);
        //Checking edge cases (even/ odd/ len == 2)
        if(res.length == 2)
            return (res[0]+res[1])/2.0;
        if(res.length % 2 != 0)
            return res[res.length/2];
        int n = res.length/2;
        return (res[n]+res[n-1])/2.0;
    }
}