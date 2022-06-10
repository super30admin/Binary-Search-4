using System;
namespace Algorithms
{
    public class MedianOfSortedArray
    {
        /// Time Complexity : O(Log n1)
        // Space Complexity :O(1)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No
        public double FindMedianSortedArrays(int[] nums1, int[] nums2)
        {
            if (nums1.Length == 0 && nums2.Length == 0)
                return 0.00;
            if (nums1.Length > nums2.Length) return FindMedianSortedArrays(nums2, nums1);
            int n1 = nums1.Length;
            int n2 = nums2.Length;
            int low = 0;
            int high = nums1.Length;

            while (low <= high)
            {
                int partX = low + (high - low) / 2;
                int partY = (n1 + n2) / 2 - partX;
                double l1 = partX == 0 ? int.MinValue : nums1[partX - 1];
                double r1 = partX == n1 ? int.MaxValue : nums1[partX];
                double l2 = partY == 0 ? int.MinValue : nums2[partY - 1];
                double r2 = partY == n2 ? int.MaxValue : nums2[partY];
                if (l1 <= r2 && l2 <= r1)
                {
                    //found the partition
                    if ((n1 + n2) % 2 == 0)
                    {
                        return (Math.Min(r1, r2) + Math.Max(l1, l2)) / 2;
                    }
                    else
                    {
                        return Math.Min(r1, r2);
                    }
                }
                else if (l2 > r1)
                {
                    low = partX + 1;
                }
                else
                {
                    high = partX - 1;
                }
            }
            return 8.99;
        }
    }
}
