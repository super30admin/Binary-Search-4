Time Complexity: o(m log n)
Space Complexity: o(1)
class Solution {
    List<Integer> res;
    int value = 0;
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length> nums2.length) return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        res = new ArrayList<>();
        int[] result;
        for(int i = 0; i<nums1.length; i++)
        {
            binarySearch(nums2, value, nums2.length - 1, nums1[i]);
        }
        result = new int[res.size()];
        for(int i = 0; i<res.size(); i++)
        {
            result[i] =  res.get(i);
        }
        return result;
    }
    private void binarySearch(int[] nums, int low, int high, int tar)
    {
        while(low <= high)
        {
            int mid = low +(high - low)/2;
            if(nums[mid] == tar)
            {
                if(mid ==0 || mid == low || nums[mid] > nums[mid-1]){
                    res.add(tar);
                    value = mid+1;
                    return;
                }
                else
                    high = mid -1;
            }
            else if(nums[mid] >  tar)
            {
                high = mid -1;
            }
            else
            {
                low = mid + 1;
            }
        }
    }
}