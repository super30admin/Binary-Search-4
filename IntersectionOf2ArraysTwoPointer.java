// Time Complexity : O(mlogm) + O(nlogn) where m is the length of nums1[] and n is the length of nums2[], since we are sorting.
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Using 2-pointer technique. First sort both arrrays, then keep p1 for nums1[] & p2 for nums2[]. Iterate until both p1 & p2 are in bound, check if both the elements at p1 & p2 are equal add in the list and move both the pointers, if element at p2 is smaller than element at p1 the move p2 as we might have greater elements on the RHS or else move p1.
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null){
            return new int[]{};
        }

        int m = nums1.length;
        int n = nums2.length;
        int p1 = 0;
        int p2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> answer = new ArrayList<>();

        while(p1< m && p2 <n){

            if(nums1[p1] == nums2[p2]){
                answer.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1] > nums2[p2]){
                p2++;
            }
            else{
                p1++;
            }
        }

        int[] result = new int[answer.size()];

        for(int i =0; i<result.length; i++){
            result[i] = answer.get(i);
        }

        return result;
    }
}