import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> li = new ArrayList<>();
        int low  = 0;
        int high = n2-1;

        for(int i =0; i< n1; i++)
        {
            int bsIdx = binarySearch(nums2, low, high, nums1[i]);

            if(bsIdx != -1)
            {
                li.add(nums1[i]);
                low = bsIdx + 1;
            }
        }

        int[] result = new int[li.size()];
        for(int i=0; i<li.size(); i++)
        {
            result[i] = li.get(i);
        }
        return result;
    }

    private int binarySearch(int[] nums, int low, int high, int target)
    {
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid] == target)
            {
                if(mid == low || nums[mid] > nums[mid-1])
                {
                    return mid;
                }
                else
                {
                    high = mid-1;
                }
            }
            else if(nums[mid] > target)
            {
                high = mid -1;
            }
            else
            {
                low = mid+1;
            }
        }
        return -1;
    }
}