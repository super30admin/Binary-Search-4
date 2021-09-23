using System;
using System.Collections.Generic;
using System.Text;

namespace Binary_Search
{
    class MedianOfSortedArray
    {
        //TC  O(n)
        //SC: O(1)
        public double FindMedianSortedArrays(int[] nums1, int[] nums2)
        {
            if (nums1.Length == 0 && nums2.Length == 0)
            {
                return 0.0;
            }
            int n1 = nums1.Length;
            int n2 = nums2.Length;
            if (n1 > n2)
            {
                return FindMedianSortedArrays(nums2, nums1);
            }
            int low = 0, high = n1;
            while (low <= high)
            {
                int partX = low + (high - low) / 2;
                int partY = (n1 + n2) / 2 - partX;
                double l1 = partX == 0 ? Int32.MinValue : nums1[partX - 1];
                double l2 = partX == n1 ? Int32.MaxValue : nums1[partX];
                double r1 = partY == 0 ? Int32.MinValue : nums2[partY - 1];
                double r2 = partY == n2 ? Int32.MaxValue : nums2[partY];
                if (l1 <= r2 && r1 < l2)
                {
                    if ((n1 + n2) % 2 != 0)
                    {
                        return Math.Min(l2, r2);
                    }
                    return (Math.Max(l1, r1) + Math.Min(l2, r2)) / 2;
                }
                else if (l1 > r2)
                {
                    high = partX - 1;
                }
                else
                {
                    low = partX + 1;
                }
            }
            return 0.0;
        }
    }
}
