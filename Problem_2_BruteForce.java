// Time complexity - O(mn)
// Space complexity - O(1)

// Only if values are positive

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];
        List<Integer> list = new ArrayList<>();
        if(nums1.length > nums2.length) 
            return intersect(nums2,nums1);
        for(int i = 0; i < nums2.length; i++){
            for(int j = 0; j < nums1.length; j++){
                if(nums2[i] == nums1[j]){
                    list.add(nums2[i]);
                    nums1[j] = -nums1[j];
                    break;
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
