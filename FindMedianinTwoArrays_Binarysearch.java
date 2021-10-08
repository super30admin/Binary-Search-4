// Time Complexity :O(logn1) n1 = length of smaller array 
// Space Complexity : 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach

// note : make sure to have small array first
// if we partition each array such that last element (lets call it l1) of  first half of first array is smaller than the first element(lets call it r2)  of second half of second array , and the last element(i.e l2) of first half of second array is smaller than the first element (r1) of second half of first array. then if total elements in both the array is even then median would be  (max(l1,l2) + min(r1,r2))/2  and if total elements of both the array is odd then median will be min(r1,r2)
// so we need to find correct place for partions

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
   
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int l =0;
        int h = n1;
     
        while(l<=h)
        {
           int  partx = l + (h-l)/2;
           int  party = (n1+n2)/2 - partx;
            double l1 = partx==0? Integer.MIN_VALUE : nums1[partx-1];
            double r1 = partx==n1? Integer.MAX_VALUE:nums1[partx];
            double l2 = party==0? Integer.MIN_VALUE: nums2[party-1];
            double r2 = party == n2? Integer.MAX_VALUE:nums2[party];
            
            if(l1<= r2 && l2<=r1)
            {
                 double median = 0 ;
                if((n1+n2)%2 ==0)
                {
                    //even case
                  return  median = (Math.max(l1,l2)+Math.min(r1,r2) )/2;
                }
                else // odd case
                  return  median = Math.min(r1,r2);
            }
            else if(l1 >r2)
                h = partx-1;
           else if(l2>r1)
                l = partx+ 1;
            
             
       
        }
       
        
        return 0.0;
    }
}