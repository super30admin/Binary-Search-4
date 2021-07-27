class Solution {
    //Time O(NlogN)
    //Space O(1)
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)
        {
            return new int[] {};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0 , j = 0;
        List<Integer> list = new ArrayList<>();
        while(i < nums1.length && j < nums2.length)
        {
            if(nums1[i] == nums2[j])
            {
                list.add(nums1[i]);
                i++;j++;
            }
            else if(nums1[i] > nums2[j])
            {
                j++;
            }
            else
            {
                i++;
            }
        }
        return list.stream().mapToInt(k -> k).toArray();
    }
}