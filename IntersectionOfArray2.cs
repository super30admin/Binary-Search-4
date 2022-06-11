using System;
using System.Collections.Generic;

namespace Algorithms
{
    public class IntersectionOfArray2
    {
        /// Time Complexity : O(m + n)
        // Space Complexity :O(min among m and n)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No
        //using HashMap 
        public int[] Intersect(int[] nums1, int[] nums2)
        {
            List<int> result = new List<int>();
            if (nums1.Length == 0 || nums2.Length == 0) return new int[0];
            Dictionary<int, int> map = new Dictionary<int, int>();
            if (nums1.Length > nums2.Length) return Intersect(nums2, nums1);

            for (int i = 0; i < nums1.Length; i++)
            {
                if (!map.ContainsKey(nums1[i]))
                {
                    map.Add(nums1[i], 0);
                }
                map[nums1[i]] = map.GetValueOrDefault(nums1[i]) + 1;
            }

            for (int j = 0; j < nums2.Length; j++)
            {
                if (map.ContainsKey(nums2[j]))
                {
                    result.Add(nums2[j]);
                    map[nums2[j]] = map.GetValueOrDefault(nums2[j]) - 1;
                    if (map.GetValueOrDefault(nums2[j]) == 0)
                    {
                        map.Remove(nums2[j]);
                    }
                }

            }
            int[] arr = new int[result.Count];
            for (int k = 0; k < result.Count; k++)
            {
                arr[k] = result[k];
            }
            return arr;
        }

        //sorted
        /// Time Complexity : O(max of m and n)
        // Space Complexity :O(min among m and n)
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No
        public int[] Intersect_TwoPointers(int[] nums1, int[] nums2)
        {
            List<int> result = new List<int>();
            if (nums1.Length == 0 || nums2.Length == 0) return new int[0];
            if (nums1.Length > nums2.Length) return Intersect(nums2, nums1);
            int m = nums1.Length;
            int n = nums2.Length;
            int p1 = 0;
            int p2 = 0;
            Array.Sort(nums1);
            Array.Sort(nums2);
            while (p1 < m && p2 < n)
            {
                if (nums1[p1] == nums2[p2])
                {
                    result.Add(nums1[p1]);
                    p1++;
                    p2++;
                }
                else if (nums1[p1] > nums2[p2])
                {
                    p2++;
                }
                else
                {
                    p1++;
                }
            }

            int[] arr = new int[result.Count];
            for (int k = 0; k < result.Count; k++)
            {
                arr[k] = result[k];
            }
            return arr;
        }
    }
}
