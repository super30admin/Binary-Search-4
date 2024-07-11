/*
 * TIme complexity - O(mxn)
 * Space complexity - O(1)
 */


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return new int[]{};
        }
        int m = nums1.length;
        int n = nums2.length;
        List<Integer> result = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;

        while( p1 < m && p2 < n){
            if(nums1[p1] == nums2[p2]){ // element found on both lists
                result.add(nums1[p1]);
                p1++;
                p2++;
            } else if(nums1[p1] > nums2[p2]){
                p2++;
            } else{
                p1++;
            }
        }

        int[] finalResult = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
}