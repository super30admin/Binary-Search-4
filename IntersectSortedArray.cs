// TC ==> O(mlogm + nlogn)
// SC ==> O(k) total number of intersecting elements

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

        int i = 0, j = 0;

        while (i < m && j < n)
        {
            if (nums1[i] == nums2[j])
            {
                result.Add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j])
            {
                i++;
            }
            else
            {
                j++;
            }
        }
        return result.ToArray();
    }
}