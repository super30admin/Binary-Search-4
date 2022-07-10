//Space O(1)
// Time O(log(m)) where m is the length of the shorter array
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        //We are always taking cuts from the smaller array and then checking for corresponding complementary cuts in the larger array.
        
        int m = nums1.length;
        int n = nums2.length;
        double res = 0.000;
        
        int low =0, high = m;
        while(low<=high) 
        { 
            int cut =low+(high-low)/2 , othercut = ((m+n)/2)-cut; // Since median is the middle element(s) of the combined array, if we take a cut in the first array at position i,then the cut in the second array should be at position (m+n)/2 -i so that on the left side of the cut and on the right side of the cut, we have i + (m+n/2) -i =  (m+n)/2 elements.
        
          int l1 = cut>0?nums1[cut-1]:Integer.MIN_VALUE; 
          int l2 = othercut>0?nums2[othercut-1]:Integer.MIN_VALUE;
          int r1= cut!=m?nums1[cut]:Integer.MAX_VALUE;
          int r2 = othercut!=n?nums2[othercut]:Integer.MAX_VALUE;  
      //l1 will be the first element to the left of the cut in the first array. if the cut is at the very first position , then l1 will be negative infinity. Similar logic for l2 . r1 will be the first element to the right of the cut in nums1. if the cut is at the very last position, then r1 will be infinity. Similar logic for r2.
        
         if( l1<=r2 && l2<=r1) // Means this is the correct cut position for median
         {
             if((m+n)%2==0) // even sized array so median will be avg of the element to left of cut and right of cut
             {   
                 double a = Math.max(l1,l2); 
                 double b =  Math.min(r1,r2);
                 return (a+b)/2;
             }
             else
             {
                 res = Math.min(r1,r2) *1.000;
                 return res;
             }
  
         }
       else if(l1>r2)
       {
           high=cut-1;
       }
       else
       {
           low =cut+1;
       }
            
        }
        return res;
        
    }
}