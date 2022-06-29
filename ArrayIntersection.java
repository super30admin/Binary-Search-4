/**
Time Complexity : O(NlogN) + O(MlogM) + O(M) + O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public int[] intersect(int[] nums1, int[] nums2) 
    {      
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int s1 = 0;
        int s2 = 0;
        
        int l1 = nums1.length;
        int l2 = nums2.length;
        
        List<Integer> result = new ArrayList<>();
        
        while(s1 < l1 && s2 < l2)
        {
            if(nums1[s1] == nums2[s2])
            {
                result.add(nums1[s1]);
                s1++;
                s2++;
            }
            else if(nums1[s1] > nums2[s2])
            {
                    s2++;
            }
            else
            {
                s1++;
            }
        }
        
        int output[] = new int[result.size()];
        
        for(int i = 0; i < result.size(); i++)
        {
            output[i] = result.get(i);
        }
        
        
        return output;
    }
}