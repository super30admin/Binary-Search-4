/*
method 1 - brute force is to merge the arrays and sort and then find median, (m+n)log(m+n)
method 2 - merge using 2 pointers, O(m+n)

method 3: binary search approach to find the median
partition the short array such that after partiotion of both arars have equal no.og elts on both sides.
compare the l1,l2 and r1,r2 elements.

Time complexity :O(log m), m -length of shorted array

*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        
        int low = 0;
        int high = nums1.length;
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        
        
        while(low <= high){
            int partX =  low+(high - low)/2;
            int partY = (n1+n2)/2 - partX;
            
            double l1 = (partX == 0)? Integer.MIN_VALUE : nums1[partX-1];
            double r1 = (partX == n1)? Integer.MAX_VALUE : nums1[partX];
            
            double l2 = (partY == 0)? Integer.MIN_VALUE : nums2[partY-1];
            double r2 = (partY == n2)? Integer.MAX_VALUE : nums2[partY];
            
            
            if(l1 <= r2 && l2 <= r1){
                //median is found 
                if((n1+n2) % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }else{
                    return Math.min(r1,r2);
                }
            }
             else  if(l2 > r1){
                    low = partX+1;
            }
            else{
                    high = partX-1;
                }
          
        }
        return -1;    
    }
}