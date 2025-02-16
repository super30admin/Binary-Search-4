// TC -> O(log m+n)
// SC -> O(1)

public class Solution
{
    public double FindMedianSortedArrays(int[] nums1, int[] nums2)
    {
        // if(nums1 == null || nums1.Length == 0 || nums2 == null || nums2.Length == 0){
        //     return 0;
        // }

        int m = nums1.Length;
        int n = nums2.Length;
        if (m > n)
        {
            return FindMedianSortedArrays(nums2, nums1);
        }

        int median = (m + n) / 2;
        int low = 0, high = m;

        int partX = 0, partY = 0;
        while (low <= high)
        {
            partX = low + (high - low) / 2;
            partY = median - partX;

            double l1 = partX == 0 ? Int32.MinValue : nums1[partX - 1];
            double r1 = partX == m ? Int32.MaxValue : nums1[partX];

            double l2 = partY == 0 ? Int32.MinValue : nums2[partY - 1];
            double r2 = partY == n ? Int32.MaxValue : nums2[partY];
            if (l1 <= r2 && l2 <= r1)
            {
                if ((m + n) % 2 == 0)
                {
                    return ((Math.Max(l1, l2) + Math.Min(r1, r2)) / 2);
                }
                return Math.Min(r1, r2);
            }
            if (l1 > r2)
            {
                high = partX - 1;
            }
            else if (l2 > r1)
            {
                low = partX + 1;
            }
        }

        return 0;
    }
}