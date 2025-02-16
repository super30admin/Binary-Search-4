//TC ==> O(mlogm + nlogn) for sorting both arrays and O(mlogn) for finding the intersect
//SC ==> O(k)


public class Solution
{
    public int[] Intersect(int[] nums1, int[] nums2)
    {
        if (nums1 == null || nums1.Length == 0 || nums2 == null || nums2.Length == 0)
        {
            return null;
        }

        List<int> result = new List<int>();

        Array.Sort(nums1);
        Array.Sort(nums2);

        int m = nums1.Length;
        int n = nums2.Length;
        if (m > n)
        {
            return Intersect(nums2, nums1);
        }

        int low = 0;
        for (int i = 0; i < n; i++)
        {
            var index = BinarySearch(nums1, low, m - 1, nums2[i]);
            if (index != -1)
            {
                result.Add(nums2[i]);
                low = index + 1;
            }
        }
        return result.ToArray();
    }

    public int BinarySearch(int[] nums, int low, int high, int target)
    {
        while (low <= high)
        {
            var mid = low + (high - low) / 2;
            if (nums[mid] == target)
            {
                if (mid == low || nums[mid - 1] != target)
                {
                    return mid;
                }
                high = mid - 1;
            }
            else if (nums[mid] > target)
            {
                high = mid - 1;

            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }
}