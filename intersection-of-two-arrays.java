// Time - O(NLgN+MLgM)
// Space - O(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int index = 0;
        int[] ans = new int[res.size()];
        
        for (int num : res) {
            ans[index++] = num;
        }
        
        return ans;
    }
}
