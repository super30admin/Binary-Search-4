// Time Complexity : O(m*n) where m and n are the lengths of nums1 and nums2 respectively
// Space Complexity : O(n) where n is the length of the arraylist used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class intersectionOfArraysBruteForce {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[] {};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                    nums2[j] = -1;
                    break;
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}