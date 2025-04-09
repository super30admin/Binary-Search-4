// TC: O(nlogn + mlogm)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int first = 0, second = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> result = new LinkedList<>();
        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] == nums2[second]) {
                result.add(nums1[first]);
                first++;
                second++;
            } else if (nums1[first] > nums2[second]) {
                second++;
            } else {
                first++;
            }
        }
        
        int[] intersection = new int[result.size()];
        int i = 0;
        for (int r : result) {
            intersection[i++] = r;
        }
        return intersection;
    }
}