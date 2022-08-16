public class IntersectionOfTwoArray {
}
//0(mlogn)
// 0(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0 || nums1 == null || nums2.length==0 || nums2== null)
        {
            return new int[]{};
        }
        int n1 = nums1.length;
        int n2 =nums2.length;
        if(n2<n1)
        {
            return intersect(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();

        int low=0;
        int high =nums2.length-1;

        for(int i=0;i<nums1.length;i++)
        {
            high=nums2.length-1;
            while(low<=high)
            {
                int mid=low+(high-low)/2;
                if(nums2[mid] == nums1[i])
                {
                    if(mid == low || nums2[mid] >nums2[mid-1])
                    {
                        result.add(nums1[i]);
                        low=mid+1;
                        break;
                    }
                    high =mid-1;
                }
                else if(nums1[i]> nums2[mid])
                {
                    low=mid+1;
                }
                else
                {
                    high= mid-1;
                }
            }
        }
        int [] ans = new int[result.size()];
        for(int i=0;i<result.size();i++)
        {
            ans[i]=result.get(i);
        }
        return ans;





    }
}