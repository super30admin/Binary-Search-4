//Time Complexity: O(log(n))
//we are finding y by constant time complexity
//Binary Search is over only one array

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //since we want to do the Binary search on the array having smaller size
        //compare the lengths and return swapped arrays
        if(n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        
        //consider array smaller in size
        //and fix low and high pointers
        int low = 0;
        int high = n1;
        
        while(low <= high){
            
            int partX = low+(high - low)/2;             //mid of nums1
            int partY = (n1 + n2 + 1)/2 - partX;        //calculating partition with the help of partX
            
            double l1 = partX == 0? Integer.MIN_VALUE: nums1[partX - 1];
            double r1 = partX == n1? Integer.MAX_VALUE: nums1[partX];
            double l2 = partY == 0? Integer.MIN_VALUE: nums2[partY - 1];
            double r2 = partY == n2? Integer.MAX_VALUE: nums2[partY];
            
            if(l1 <= r2 && l2 <= r1){                   //correct partition conditions
                if((n1+n2) % 2 == 0)                    //for even
                {                   
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }else                                   //for odd
                {
                    return Math.max(l1,l2);
                }
            }
            else if(l2 > r1){                           //for incorrect partitions
                low = partX + 1;
            }else{
                high = partX -1;
            }
        }
        return 0;
    }
}