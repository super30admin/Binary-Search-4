//Time complexity : mlogm+nlogn
//Space complexity : O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[] {};
        }
        List<Integer> result = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        if(m>n){
            intersect(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        while(p1<m && p2< n){
            if(nums1[p1] == nums2[p2]){
                result.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1] < nums2[p2]){
                p1++;
            }else{
                p2++;
            }
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}