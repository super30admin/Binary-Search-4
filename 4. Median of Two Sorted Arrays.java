// Time Complexity : log(min(n1,n2))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes     
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// l1 is the imm left element of the frst partition, r1 is the imm right element of the partition
// l2 is the imm left element of the frst partition, r2 is the imm right element of the partition
// our aim is to find out the correct partition such that the l1 is less than r2 and l2 is less than r1.
// if l2 > r1 then low = mid+1 here mid is part x ;
// else high = partx-1;
// part y is n1+n2/2 - partx;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length; 
        int n2 = nums2.length;
        if(n1==0 && n2==0) return 0.0;
        if(n1>n2)
        {
            return findMedianSortedArrays(nums2,nums1);
        }
        int low=0;
        int high = n1;
        while(low<=high)
        {
            int partx = low + (high - low)/2;
            int party = (n1+n2)/2 - partx;
            double l1 = partx == 0 ? Integer.MIN_VALUE : nums1[partx-1];
            double r1 = partx == n1 ? Integer.MAX_VALUE : nums1[partx];
            double l2 = party == 0 ? Integer.MIN_VALUE : nums2[party-1];
            double r2= party == n2 ? Integer.MAX_VALUE : nums2[party];
            //correct partition
            if(l1<=r2 && l2<=r1)
            {
                if((n1+n2)%2==0)
                {
                    return (Math.max(l1,l2)+ Math.min(r1,r2))/2;
                }
                else
                {
                    return Math.min(r1,r2);
                }
            }
            else if(l2>r1)
            {
                low = partx+1;
            }
            else 
            {
                high = partx-1;
            }
        }
        return 1.80;
    }
}