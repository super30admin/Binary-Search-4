// Time Complexity: O(nlogn + mlogm + (m+n))
// Space Complexity: O(m + n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0, index2 = 0;

        List<Integer> set = new ArrayList<>();

        while(index1 < nums1.length && index2 <nums2.length) {
            if(nums1[index1] == nums2[index2]) {
                set.add(nums1[index1]);
                index1++;
                index2++;
            } else if(nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                index1++;
            }
        }

        int[] res = new int[set.size()];
        int i=0;
        for(int num:set) {
            res[i++] = num;
        }
        return res;
    }
}