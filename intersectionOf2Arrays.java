//TC : O(nlogm) n = length of nums1; m= length of nums2; also assuming we are given 2 sorted arrays
//SC : O(r) r = number of common elements between the two list which we are adding in a temporary list
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0||nums2.length==0) return (new int[]{});

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> l = new ArrayList<>();

        int low = 0;
        int high = nums2.length-1;
        for(int i=0;i<nums1.length;i++)
        {
            int ans = BS(nums2,nums1[i],low,high);
            if(ans != -1)
            {
                l.add(nums2[ans]);
                low = ans+1;
            }
        }

        int[] result = new int[l.size()];

        for(int i=0;i<l.size();i++)
            result[i] = l.get(i);

        return result;
    }

    private int BS(int[] nums2,int num, int low, int high){
        while(high>=low)
        {
            int mid = low +(high-low)/2;
            if(nums2[mid] == num)
            {
                if(mid==low||nums2[mid]>nums2[mid-1])
                    return mid;
                else
                    high=mid-1;
            }
            else if(nums2[mid] > num)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
}