// 4.
//time - O(log min(nums1.length, nums2.length)) with constant space

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //ensure that 1st array in i/p argument has shorter length
        if(nums1.length > nums2.length)
        {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int n1 = nums1.length;
        int n2 = nums2.length;
    
        //possible places at which nums1 can be partioned are from o to nums1.length
        int low = 0;
        int high = nums1.length;
        
        while(low <= high)
        {
            //for partion in nums1, corresponding partion in nums2 is (n1 + n2 + 1) / 2 - nums1Partion
            int partNums1 = low + (high - low) / 2; //try partioning nums1 at the middle
            int partNums2 = ((n1 + n2 + 1) / 2) - partNums1; //find corresponding partion in nums2
            //find l1, l2, r1, r2 (updated with -inf and inf at the edges)
            int l1 = partNums1 != 0 ? nums1[partNums1 - 1] : Integer.MIN_VALUE;
            int l2 = partNums2 != 0 ? nums2[partNums2 - 1] : Integer.MIN_VALUE;
            int r1 = partNums1 != n1 ? nums1[partNums1] : Integer.MAX_VALUE;
            int r2 = partNums2 != n2 ? nums2[partNums2] : Integer.MAX_VALUE;
    
            //a valid partion is obtained if l1 <= r1, l2 <= r1, l2 <= r1 and l2 <= r2
            if(l2 <= r1 && l1 <= r2)
            {
                if((n1 + n2) % 2 != 0)
                {
                    return Math.max(l1, l2); //total 3 of elements is odd
                }
                else
                {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0; //total 3 of elements is even
                }
            }
            
            //l1 should be part of right side of partion in nums1
            else if(l1 > r2)
            {
                high = partNums1 - 1;
            }
            
            //r1 should be part of left half of nums1 partion
            else //l2 > r1
            {
                low = partNums1 + 1;
            }  
        }
        return -1.0;
    }
}
