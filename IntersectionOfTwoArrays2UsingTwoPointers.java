// TC: O(min(mlogm, nlogn))
// SC: O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m, n;
        m = nums1.length;
        n = nums2.length;
        if(m > n) {
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        while(i < m && j < n) {
            if(nums1[i] == nums2[j]) {
                temp.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[temp.size()];
        for(i = 0; i < res.length; i++) {
            res[i] = temp.get(i);
        }
        return res;
    }
}