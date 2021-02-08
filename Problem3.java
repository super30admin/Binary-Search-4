/**
Leet Code Submitted : YES
Space Complexity : O(M + N)
Time Complexity : O(log(M + N))

The naive implementation is focus on sorting amd merging the two list and finding the median based on even and odd number of elements. 

**/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { 
        int l = nums1.length + nums2.length;
        int[] out = new int[l];
        
        int count;
        for(count = 0; count<nums1.length; count++){
            out[count] = nums1[count];
        }
        
        for(int j = count; j<nums2.length;j++){
            out[count] = nums2[j];
            count++;
        }
        
        Arrays.sort(out);
        
        if(l % 2 == 0){
            return (out[l/2] + out[l/2 - 1])/2d;
        }else
            return out[l/2];
        
    }
}
