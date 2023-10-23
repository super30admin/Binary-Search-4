// Time Complexity : O(nlogn) + O(mlogm) where n is the size of nums1 and m is the size of nums2
// Space Complexity : O(1) constant space as we did not use any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null){
            return new int[]{};
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        int m = nums1.length;
        int n = nums2.length;

        while(p1 < m && p2 < n){
            if(nums1[p1] == nums2[p2]){
                answer.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1] < nums2[p2]){
                p1++;
            }else if(nums1[p1] > nums2[p2]){
                p2++;
            }
        }

        int[] res = new int[answer.size()];

        for(int i = 0; i < answer.size(); i++){
            res[i] = answer.get(i);
        }

        return res;
    }
}
