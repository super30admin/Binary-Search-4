// Time Complexity: O( Min(m + log m, n + log n) m = length of nums1, n = length of nums2
// Space Complexity: O(min (m, n))
// Runs on LeetCode: YES
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> result = new ArrayList<Integer>();

        while (p1 < nums1.length && p2 < nums2.length) {

            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                result.add(nums1[p1]);
                p1++;
                p2++;
            }
        }

        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}