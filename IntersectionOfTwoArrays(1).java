// Time Complexity : O(m + n) --> where n & m are the lengths of input array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (350): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Two Pointer O(m + n) solution {considering arrays are sorted - according to follow up question}
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // edge case
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        if (nums1.length > nums2.length) return intersect(nums2, nums1); // to reduce space
        
        List<Integer> ls = new ArrayList<>();
        Arrays.sort(nums1); Arrays.sort(nums2);
        int p1 = 0; int p2 = 0;
        
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                ls.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if (nums1[p1] < nums2[p2]) p1++;
            else p2++;
        }
        
        int result[] = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) result[i] = ls.get(i);
        return result;
    }
}