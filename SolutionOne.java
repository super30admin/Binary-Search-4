// Time Complexity :O(n log n + m log m)
// Space Complexity :O(log n + log m )
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


class SolutionOne {
    public int[] intersect(int[] nums1, int[] nums2) {

        int[] arr=new int[0];

        if(nums1==null || nums2==null)
            return arr;

        List<Integer> list = new ArrayList<>();

        int n1 = nums1.length;

        int n2 = nums2.length;

        if(n1>n2)
            return intersect(nums2,nums1);

        Arrays.sort(nums1);

        Arrays.sort(nums2);

        for(int i=0,j=0;i<nums1.length&&j<nums2.length;)
        {
            if(nums1[i]==nums2[j])
            {
                list.add(nums1[i]);
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

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);

        return result;

    }