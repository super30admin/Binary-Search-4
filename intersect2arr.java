class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i=0, j=0;
        ArrayList<Integer> list= new ArrayList<>();
        
        while(i< nums1.length && j< nums2.length)
        {
            if(nums1[i]==nums2[j])
            {
                list.add(nums1[i]);
                i++; j++;
            }
            else if(nums1[i]>nums2[j])
                j++;
            else
                i++;
        }
        
        int result[]= new int[list.size()];
        for(i=0; i<result.length; i++)
            result[i]= list.get(i);
        
        return result;
    }
}
