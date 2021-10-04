 // Time Complexity: O(log(min(m,n))) ; O(LOG(MN) - WORST CASE.
    // Space Complexity: O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*Approach:
1) we use most efficient approach with binary search 
2) we first start with finding the partitions in the array and calculate the median depending on odd and even elements
3) eg: we have 
-> num1: 1,7,8,10,11
-> num2: 2,3,4,5,6,12,13
4) In the above 2 arrays we find the partitions using l1,l2, r1 and r2 respectively.
in the above example we will partition using 
 int low =0;
 int high=n1; 
 int partX = low+(high-low)/2; // number of elemets we pick from nums1
 int partY = (n1+n2)/2- partX;
5) rest whole procedure according to the code
            else if(l1>r2)
            {
                high= partX-1;
            }
            else
            {
                low = partX+1;
            }
    if l1>r2 we need to search for smaller elememnt
    -> Thus we need to shift our high thus we can shift the partition to left to find the smaller element (array is sorted)
    -> else we just need to find the larger element and we increment our low
*/



class MedianOfTwoSortedArrays {
    
   
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        
        // If the first array is greater than the second one - then we treat second array as the first one
        // because we always consider smaller array --> n and greater --> m
        if(n > m)
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0;
        int high = n;
        
        /*
        To find and fix the correct position of partX → we do a binary search and every time we partition the arrays and see if it’s a valid partition or not.
        Valid partition condition: the elements on the left side of the partition of both the arrays should be less than the elements on the right side of the partition of both the arrays
        L1 <= R2 and L2 <= R1
        */
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (n+m)/2 - partX;        // Formula to find partY in the second array
            
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r1 = partX == n ? Integer.MAX_VALUE : nums1[partX];
            double r2 = partY == m ? Integer.MAX_VALUE : nums2[partY];
            
            if(l1 <= r2 && l2 <= r1){
                /*
                Now after a valid partition, we take the Max(L1, L2) and Min(R1, R2) → to decide the two elements in the center. Now if the length of (m+n) is odd → then directly the median is Min(R1,R2) otherwise it is the average of Max(L1, L2) and Min(R1, R2).
                */
                if((n+m) % 2 == 0){
                    double left = Math.max(l1, l2);
                    double right = Math.min(r1,r2);
                    return (left + right) / 2;
                }else{
                    return Math.min(r1,r2);
                }
            }else if(l2 > r1)
                low = partX + 1;
            else
                high = partX - 1;
        }
        return -1;
    }
}