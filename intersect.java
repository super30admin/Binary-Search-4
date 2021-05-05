// Runtime complexity - O(nlogn+mlogm) where n is the length of the array nums1 and m is the length of the nums2 array
// Space complexity - O(logn + log m)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
     if(nums1==null|| nums2==null||nums1.length==0||nums2.length==0)
         return new int[0];
     Arrays.sort(nums1);
     Arrays.sort(nums2);
     int i=0;
     int j=0;
     List<Integer> result=new ArrayList<>();
     while(i<nums1.length && j<nums2.length)
     {
            if(nums1[i]==nums2[j])
            {
                result.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j])
                i++;
            else
                j++;
     }
     return converttoarray(result);
    }
    public int[] converttoarray(List<Integer> result)
    {
        int[] resultarray=new int[result.size()];
        for(int i=0;i<result.size();i++)
        {
            resultarray[i]=result.get(i);
        }
        return resultarray;
    }
}
