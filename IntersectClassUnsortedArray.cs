// TC => O(m + n)
// SC => O(m);
public class Solution
{
    public int[] Intersect(int[] nums1, int[] nums2)
    {
        if (nums1 == null || nums1.Length == 0 || nums2 == null || nums2.Length == 0)
        {
            return null;
        }

        Dictionary<int, int> lookup = new Dictionary<int, int>();
        List<int> result = new List<int>();
        foreach (var num in nums1)
        {
            lookup.TryAdd(num, 0);
            lookup[num]++;
        }

        foreach (var num in nums2)
        {
            if (!lookup.ContainsKey(num))
            {
                continue;
            }
            result.Add(num);
            lookup[num]--;
            if (lookup[num] == 0)
            {
                lookup.Remove(num);
            }
        }

        return result.ToArray();
    }
}