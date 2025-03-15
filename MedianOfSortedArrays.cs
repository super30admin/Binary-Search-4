// time complexity O(log(min(m,n)))
// space complexity  O(1)
// Approach - check the correct partition for two arrays without actually merging it
// to get the partition for one array do binary search on smaller array and set the partition 
// for other array. When we get correct partition find out the median
public class Solution
{
    public double FindMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int m = nums1.Length;
        int n = nums2.Length;

        if (m > n)
        {
            return FindMedianSortedArrays(nums2, nums1);
        }

        // do binary search for smaller array
        int low = 0;
        int high = m;
        while (low <= high)
        {
            int partX = low + (high - low) / 2;
            int partY = (n + m) / 2 - partX;

            int l1 = partX == 0 ? Int32.MinValue : nums1[partX - 1];
            int r1 = partX == m ? Int32.MaxValue : nums1[partX];
            int l2 = partY == 0 ? Int32.MinValue : nums2[partY - 1];
            int r2 = partY == n ? Int32.MaxValue : nums2[partY];


            if (l1 <= r2 && l2 <= r1)
            {
                if ((m + n) % 2 != 0)
                {
                    return Math.Min(r1, r2);
                }
                else
                {
                    return (Math.Min(r1, r2) + Math.Max(l1, l2)) / 2.0;
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
        return -1;
    }
}