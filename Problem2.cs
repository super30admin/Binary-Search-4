// Time Complexity : O(logn) where n is the size of the smaller array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I break down both arrays into partitions of 0 to size of array + 1. I perform binary search on the smaller array and find the equivalent partition on the larger array such that the elements on
both sides of the partition or equal (for equal number of elements) or elements on right half of the partitions are 1 greater than the left half(for total odd number of elements. 
The correct partition is the one in which the element of the first array on the left side of the partition is smaller than the element of the second array that is just right to the partition as well as
the element of the second array to the left of it's partition should be less than the element of the first array to the right of it's parition. At the end, for even total number of elements, 
median is the average of max of elements to the left side of partitions of both arrays and min of elements to the right side of paritions of both arrays. In case of odd total number of elements, 
the median is the min of elements to the right side of paritions of both arrays.
*/

public class Solution {
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.Length, n2 = nums2.Length;
        
        if(n1 > n2)
        {
            return FindMedianSortedArrays(nums2, nums1);
        }


        int low = 0, high = nums1.Length;

        while(low <= high)
        {
            int partX = low + (high - low)/2;
            int partY = (n1 + n2)/2 - partX;

            double l1 = (partX == 0) ? Int32.MinValue : nums1[partX - 1];
            double r1 = (partX == n1) ? Int32.MaxValue : nums1[partX]; 
            double l2 = (partY == 0) ? Int32.MinValue : nums2[partY - 1];
            double r2 = (partY == n2) ? Int32.MaxValue : nums2[partY];

            if(l1 <= r2 && l2 <= r1)
            {
                if((n1 + n2)%2 == 0)
                {
                    return (Math.Max(l1,l2) + Math.Min(r1,r2))/2.0;
                }

                else
                {
                    return Math.Min(r1,r2);
                }
            }

            else if(l2>r1)
            {
                low = partX + 1;
            }

            else
            {
                high = partX - 1;
            }
        }

        return -1;
    }
}