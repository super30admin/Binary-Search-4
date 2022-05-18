using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    /*
     * T.C: O(log(min(m,n)) since we are using the partition binary search on min array
     * 
     */
    public class MedianOfArray
    {
        public double FindMedianSortedArrays(int[] nums1, int[] nums2)
        {

            int m = nums1.Length;
            int n = nums2.Length;

            if (nums2.Length < nums1.Length)
            {
                return FindMedianSortedArrays(nums2, nums1);
            }

            int low = 0;
            int high = m;

            while (low <= high)
            {
                int midx = low + (high - low) / 2;
                int PartY = (m + n) / 2 - midx;

                double l1 = midx == 0 ? int.MinValue : nums1[midx - 1];
                double l2 = PartY == 0 ? int.MinValue : nums2[PartY - 1];
                double r1 = midx == m ? int.MaxValue : nums1[midx];
                double r2 = PartY == n ? int.MaxValue : nums2[PartY];

                Console.WriteLine("l1 : " + l1 + " l2: " + l2 + "R1: " + r1 + "R2: " + r2);

                if (l1 <= r2 && l2 <= r1)
                {
                    if ((m + n) % 2 != 0)
                    {
                        return Math.Min(r1, r2);
                    }
                    else
                    {
                        return (Math.Max(l1, l2) + Math.Min(r1, r2)) / 2.0;
                    }
                }
                else if (l1 > r2)
                {
                    high = midx - 1;
                }
                else
                {
                    low = midx + 1;
                }
            }

            return 34534.3;

        }
    }
}
