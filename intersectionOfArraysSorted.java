//time complexity O(n) where n is the length of larger array
//space complexity O(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 ||
           nums2 == null || nums2.length == 0) return new int[0];
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums1); Arrays.sort(nums2);
        int p1 = 0; int p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                li.add(nums1[p1]); p1++; p2++;
            }else if(nums1[p1] < nums2[p2]){
                p1++;
            } else{
                p2++;
            }
        }
        int[] result = new int[li.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = li.get(i);
        }
        return result;
    }
}
