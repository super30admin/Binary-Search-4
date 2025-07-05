/*
  Time complexity: O(nlogn)
  Space complexity: O(m) as there can only be as many common elements as the smaller array and the list used to store the result will be at maximum of the same size

*/
public class Solution {
    public int[] Intersect(int[] nums1, int[] nums2) {
        int m = nums1.Length;
        int n = nums2.Length;
        List<int> result = new List<int>();

        if(m>n)
        {
            return Intersect(nums2, nums1);
        }
        Array.Sort(nums1);
        Array.Sort(nums2);

        int low = 0;
        int high = n-1;

        for(int i=0;i<m;i++)
        {
            int index = binarySearch(nums2, nums1[i], low, high);
            if(index!=-1)
            {
                result.Add(nums1[i]);
                low = index+1;
            }
        }

        return result.ToArray();
    }

    private int binarySearch(int[] nums, int target, int low , int high)
    {
        while(low<=high)
        {
            int mid = low+ (high-low)/2;
            if(nums[mid]==target)
            {
                if(mid==low || nums[mid]>nums[mid-1])
                    return mid;
                else
                {
                    high = mid-1;
                }
            
            }
            else
            {
                if(nums[mid]>target)
                    high = mid-1;
                else
                    low = mid+1;
            }
        }
        return -1;
    }
}
