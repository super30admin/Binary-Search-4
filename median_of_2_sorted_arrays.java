//T.C- O(nlogn)
//S.C- O(1)

import java.util.Arrays;
class Solution {
    public void findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m= nums1.length;
        int n= nums2.length;
        int o= m+n;
        int nums3[]= new int[o];
        int i=0;
        int j=0;
        int k=0;
        while(i<m){
            nums3[k++]= nums1[i++];
        }
        while(j<n){
            nums3[k++]= nums1[j++];
        }
        Arrays.sort(nums3);
        
    }
}

