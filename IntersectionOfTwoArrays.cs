// time complexity - for Two pointers- m>n, nlogn+mlogm+m so total O(mlogm)
//                   for binary search - mlogm
// space complexity - O(1)
public class Solution
{
    public int[] Intersect(int[] nums1, int[] nums2)
    {

        int n = nums1.Length;
        int m = nums2.Length;
        Console.WriteLine($"m: {m} n: {n}");
        if (n > m)
        {
            return Intersect(nums2, nums1);
        }
        Array.Sort(nums1);
        Array.Sort(nums2);
        List<int> res = new List<int>();
        int index = 0;
        // binary search
        for (int i = 0; i < m; i++)
        {
            int loc = binarySearch(nums1, index, nums2[i]);
            if (loc != -1)
            {
                res.Add(nums2[i]);
                index = loc + 1;
            }
        }
        // using two pointers
        // int p1 =0;
        // int p2 =0;

        // while(p1<n && p2 <m)
        // {
        //     if(nums1[p1] == nums2[p2])
        //     {
        //         res.Add(nums1[p1]);
        //         p1++;
        //         p2++;
        //     }
        //     else if(nums1[p1] > nums2[p2])
        //     {
        //         p2++;
        //     }
        //     else
        //     {
        //         p1++;
        //     }
        // }

        int[] a = new int[res.Count()];
        int ind = 0;
        foreach (var ele in res)
        {
            a[ind] = ele;
            ind++;
        }
        return a;
    }

    private int binarySearch(int[] nums, int loc, int target)
    {
        int left = loc;
        int right = nums.Length - 1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
            {
                if (mid == left || nums[mid] > nums[mid - 1])
                {
                    return mid;
                }
                else
                {
                    right = mid - 1;
                }
            }
            else if (target > nums[mid])
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return -1;
    }
}