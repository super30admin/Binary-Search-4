// Time Complexity : O(nlogm) (assuming both lists are sorted, for each present in smaller list of size n, I perform binary search to find their occurrences in the larger list of size m)
// Space Complexity : O(n) - where n is the size of smaller list - space occupied by frequency map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
    I maintain frequency map for the smaller array. For each element present in the smaller array, I perform binary search and look for the first occurrence of that element in the larger list.
    If element is present, in my subsequent binary search, I set my first pointer to the position where previous element was found + 1 (reducing the search space to avoid duplicates)
*/

public class Solution
{
    public int[] Intersect(int[] nums1, int[] nums2)
    {
        if (nums2.Length < nums1.Length)
        {
            return Intersect(nums2, nums1);
        }

        Array.Sort(nums1);

        Array.Sort(nums2);

        Dictionary<int, int> frequencyMap = new();

        for (int i = 0; i < nums1.Length; i++)
        {
            frequencyMap[nums1[i]] = frequencyMap.GetValueOrDefault(nums1[i], 0) + 1;
        }

        List<int> resultList = new();

        int first = 0;

        for (int i = 0; i < nums1.Length; i++)
        {
            int index = FirstOccurrence(nums1[i], nums2, first);

            if (index != -1)
            {
                first = index + 1;
                frequencyMap[nums1[i]] -= 1;
                resultList.Add(nums1[i]);

                if (frequencyMap[nums1[i]] == 0)
                {
                    frequencyMap.Remove(nums1[i]);
                }

            }
        }

        int[] result = new int[resultList.Count];

        for (int i = 0; i < resultList.Count; i++)
        {
            result[i] = resultList[i];
        }

        return result;
    }

    public int FirstOccurrence(int target, int[] arr, int first)
    {
        int last = arr.Length - 1;
        int result = -1;

        while (first <= last)
        {
            int mid = first + (last - first) / 2;

            if (arr[mid] == target)
            {
                result = mid;
                last = mid - 1;
            }

            else if (arr[mid] < target)
            {
                first = mid + 1;
            }

            else
            {
                last = mid - 1;
            }
        }

        return result;
    }
}