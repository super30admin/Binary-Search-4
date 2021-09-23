using System;
using System.Collections.Generic;
using System.Text;

namespace Binary_Search
{
    class IntersectionofTwoArrays
    {
        //TC: O(m+n)
        //SC: O(n)
        public int[] Intersect(int[] nums1, int[] nums2)
        {
            if (nums1 == null || nums1.Length == 0 || nums2 == null || nums2.Length == 0)
            {
                return new int[] { };
            }
            int n1 = nums1.Length;
            int n2 = nums2.Length;
            if (n1 > n2)
            {
                return Intersect(nums2, nums1);
            }
            Dictionary<int, int> map = new Dictionary<int, int>();
            foreach (int num in nums1)
            {
                map.Add(num, map.GetValueOrDefault(num, 0) + 1);
            }
            List<int> result = new List<int>();
            for (int i = 0; i < n2; i++)
            {
                if (map.ContainsKey(nums2[i]))
                {
                    result.Add(nums2[i]);
                    map.Add(nums2[i], map[nums2[i]] - 1);
                    if(map[nums2[i]] ==0)
                      map.Remove(nums2[i]);
                }
                if (map.Count == 0)
                {
                    break;
                }
            }
            int[] array = new int[result.Count];
            for (int i = 0; i < result.Count; i++)
            {
                array[i] = result[i];
            }
            return array;
        }

        public int[] IntersectPointer(int[] nums1, int[] nums2)
        {
            if (nums1 == null || nums1.Length == 0 || nums2 == null || nums2.Length == 0)
            {
                return new int[] { };
            }
            int n1 = nums1.Length;
            int n2 = nums2.Length;
            if (n1 > n2)
            {
                return IntersectPointer(nums2, nums1);
            }
            //2 pointer approach
            Array.Sort(nums1);
            Array.Sort(nums2);
            int p1 = 0, p2 = 0;
            List<int> result = new List<int>();
            while (p1 < n1 && p2 < n2)
            {
                if (nums1[p1] == nums2[p2])
                {
                    result.Add(nums1[p1]);
                    p1++;
                    p2++;
                }
                else if (nums1[p1] < nums2[p2])
                {
                    p1++;
                }
                else
                {
                    p2++;
                }
            }
            int[] array = new int[result.Count];
            for (int i = 0; i < result.Count; i++)
            {
                array[i] = result[i];
            }
            return array;
        }
        //TC: nlogn for sorting
        //After sort n * log m
        //SC: O(1)
        public int[] IntersectBinarySearch(int[] nums1, int[] nums2)
        {
            if (nums1 == null || nums1.Length == 0 || nums2 == null || nums2.Length == 0)
            {
                return new int[] { };
            }
            int n1 = nums1.Length;
            int n2 = nums2.Length;
            if (n1 > n2)
            {
                return IntersectBinarySearch(nums2, nums1);
            }
            //Binary Search approach
            Array.Sort(nums1);
            Array.Sort(nums2);
            List<int> result = new List<int>();
            int low = 0, high = n2 - 1;
            for (int i = 0; i < n1; i++)
            {
                int target = nums1[i];
                int bsIndex = binarySearch(nums2, low, high, target);
                if (bsIndex != -1)
                {
                    result.Add(target);
                    low = bsIndex + 1;
                }
            }
            int[] array = new int[result.Count];
            for (int i = 0; i < result.Count; i++)
            {
                array[i] = result[i];
            }
            return array;
        }

        private int binarySearch(int[] nums, int low, int high, int target)
        {
            while (low <= high)
            {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target)
                {
                    if (mid == low || nums[mid] > nums[mid - 1])
                    {
                        return mid;
                    }
                    high = mid - 1;
                }
                else if (target > nums[mid])
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 1;
                }
            }
            return -1;
        }
    }
}
