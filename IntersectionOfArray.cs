using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    public class IntersectionOfArray
    {

        // Hash map approch
        //T.C: O(m+n) 
        //S.C: O(k) where n is number of element in mininum num array

        public int[] Intersect(int[] nums1, int[] nums2)
        {

            if (nums1 == null || nums2 == null || nums1.Length == 0 || nums2.Length == 0)
                return null;

            List<int> lst = new List<int>();

            if (nums2.Length < nums1.Length)
            {
                Intersect(nums2, nums1);
            }

            Dictionary<int, int> hashmap = new Dictionary<int, int>();

            for (int i = 0; i < nums1.Length; i++)
            {
                if (!hashmap.ContainsKey(nums1[i]))
                {
                    hashmap.Add(nums1[i], 0);
                }

                hashmap[nums1[i]] = hashmap[nums1[i]] + 1;
            }

            for (int i = 0; i < nums2.Length; i++)
            {
                if (hashmap.ContainsKey(nums2[i]))
                {
                    lst.Add(nums2[i]);
                    hashmap[nums2[i]] = hashmap[nums2[i]] - 1;
                    if (hashmap[nums2[i]] == 0)
                    {
                        hashmap.Remove(nums2[i]);
                    }
                }
            }

            int[] result = new int[lst.Count];

            for (int j = 0; j < lst.Count; j++)
            {
                result[j] = lst[j];
            }

            return result;


        }


        //two pointer approch
        //T.C: O(mlog(m)+nlog(n)) where m is number of element in nums1 array and n is no of element in nums2 array
        //S.C: O(1)

        public int[] Intersect1(int[] nums1, int[] nums2)
        {

            if (nums1 == null || nums2 == null || nums1.Length == 0 || nums2.Length == 0)
                return null;

            List<int> lst = new List<int>();

            int p1 = 0, p2 = 0;

            Array.Sort(nums1);
            Array.Sort(nums2);

            while (p1 < nums1.Length && p2 < nums2.Length)
            {

                if (nums1[p1] == nums2[p2])
                {
                    lst.Add(nums1[p1]);
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

            int[] result = new int[lst.Count];

            for (int j = 0; j < lst.Count; j++)
            {
                result[j] = lst[j];
            }

            return result;


        }


        //Binary Searh Approch
        //T.C: O(mlog(m)+nlog(n)) where m is number of element in nums1 array and n is no of element in nums2 array
        //S.C: O(1)
        public int[] Intersect2(int[] nums1, int[] nums2)
        {
            if (nums1 == null || nums2 == null || nums1.Length == 0 || nums2.Length == 0)
                return null;

            if (nums2.Length < nums1.Length)
            {
                Intersect2(nums2, nums1);
            }

            List<int> lst = new List<int>();

            Array.Sort(nums1);
            Array.Sort(nums2);
            int low = 0;
            int high = nums2.Length - 1;
            for (int i = 0; i < nums1.Length; i++)
            {
                int index = BinarySearch(nums2, low, high, nums1[i]);
                Console.WriteLine(index);
                if (index != -1)
                {
                    low = index + 1;
                    lst.Add(nums1[i]);
                }
            }

            int[] result = new int[lst.Count];

            for (int j = 0; j < lst.Count; j++)
            {
                result[j] = lst[j];
            }
            return result;
        }

        private int BinarySearch(int[] nums, int low, int high, int num)
        {
            int mid = low + (high - low) / 2;

            while (low < high)
            {
                if (nums[mid] == num)
                {
                    if (mid == low || nums[mid - 1] < nums[mid])
                    {
                        return mid;
                    }
                   
                    high = mid - 1;
                    
                }
                else
                {
                    if (nums[mid] > num)
                    {
                        high = mid - 1;
                    }
                    else
                    {
                        low = mid + 1;
                    }
                }
            }
            return -1;
        }

    }
}
