// Time Complexity : O(log n1) n1 is the length of the smaller array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will create a partition in nums1. Number of partitions will always be equal to the number of elements+1. To find the partition in nums 2 we will find the compliment of patition of nums1 from total number of elements. 
// Many such combinations of partitions can be found, but we need to find the correct partition amongst all the combinations. A correct partition is done when all the elements on the left side of nums1 and nums 2 are smaller 
// than all elements on the right side of nums1 and nums2. Once that is done, if the total number of elements are odd, then we return the smallest element from the right side, otherwise we return the average of the largest element from the left side and the smallest element from the right side. 

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0 && nums2.length==0) return 0.0;
        int n1=nums1.length;
        int n2=nums2.length;
        
        //we need to keep the first array the smaller one, since the binary search is performed on it, so we will compare the length and swap the arrays in the call
        if(n2<n1) return findMedianSortedArrays(nums2, nums1);
        int low=0; int high=n1; //partition is always n+1, hence high is n1 and not n1-1;

        while(low<=high)
        {
            int PartX=low+(high-low)/2; //mid is the partition for nums1
            int PartY=(n1+n2)/2-PartX; //(total no. of elements)/2 - Partition at xPart
            System.out.println("n1=" + n1);
            System.out.println("n2=" + n2);

            //if partition x is 0 then we take L1 as infinity, otherwise we take the value at index in nums1
            double L1=PartX==0? Integer.MIN_VALUE:nums1[PartX-1]; 
            double R1=PartX==n1? Integer.MAX_VALUE:nums1[PartX];
            double L2=PartY==0? Integer.MIN_VALUE:nums2[PartY-1];
            double R2=PartY==n2? Integer.MAX_VALUE:nums2[PartY];

            System.out.println("L1=" + L1);
            System.out.println("L2=" + L2);
            System.out.println("R1=" + R1);
            System.out.println("R2=" + R2);

            if(L1<=R2 && L2<=R1)
            {
                //get median

                //if the total no. of elements is odd
                if((n1+n2)%2!=0)
                {
                    return Math.min(R1,R2);
                }
                else
                {
                    return (Math.max(L1,L2)+Math.min(R1,R2))/2;
                }
            }

            else if(L2>R1)
                {
                    low=PartX+1;
                }
                else
                {
                    high=PartX-1;
                }
            
            
        }

return 222.2;
    }
}