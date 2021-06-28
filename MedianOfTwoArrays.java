package BinarySearch4;

/*
    -------------------------------------------------------------------------------------------------------
    Time complexity : o(log N) 
    space complexity: o(1)
    Did this code run successfully in leetcode : yes
    problems faces : no
    Approach : create partition on two arrays such that , total number of elements in left partition of array1 and array2
    is equal to total number of elements at right side of the partition in array1 and array2.
    at the right partition the elements on the left side of partition will be lessthan the elements at right side of partition 
    */
    


public class MedianOfTwoArrays {

   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       
       int n1 = nums1.length;
       int n2 = nums2.length;
       
       if(n1>n2) return findMedianSortedArrays(nums2, nums1);
       
       int low =0;
       int high = n1;
       
       while(low <= high)
       {
           int partX = low + (high-low) / 2;
           
           int partY = (n1+n2)/2 - partX;
           
           double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
           double r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
           double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
           double r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
           
           if(l1<=r2 && l2<=r1) // correct partition
           {
               //findMedian
               //if combined array contains even number of elements
               if((n1+n2)%2 == 0)
               {
                   return (Math.max(l1, l2) +Math.min(r1, r2))/2;
               }else  //if combined array contains odd number of elements
               {
                   return Math.min(r1,r2);
               }
           }
           else if(l2>r1)
           {
               
               low = partX+1;
           }
           else {
               high = partX-1;
           }
           
           
           
       }
       
       return 1.0;
        
    }
}
