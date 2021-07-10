// Time Complexity :  O(min(n,m)) if both the arrays are sorted else O(logn+logm)
// Space Complexity : O(1) since it is iterative binary search.
// Did this code successfully run on Leetcode : Yes Its working
// Any problem you faced while coding this : understanding the problem iteself.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> out = new ArrayList<>();
        int i = 0 ; int j = 0;
        while(i<nums1.length && j <nums2.length)
        {
            if(nums1[i]==nums2[j])
            {
                out.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j])
            {
                i++;
            }
            else
            {
                j++;
            }
        }

    int[] result = new int[out.size()];
    for(int x = 0 ; x <result.length;x++)
    {
        result[x] = out.get(x);
    }
    return result;
        
    }
}