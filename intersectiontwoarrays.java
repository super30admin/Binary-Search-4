
# Time complexity:O(mlog(m) + nlog(n))
# Space complexity: 0(m+n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int first = 0, second = 0;
        // sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // result
        List<Integer> result = new LinkedList<>();

        while(first < nums1.length && second < nums2.length) {
            // same values, add to result
            if(nums1[first] == nums2[second]) {
                result.add(nums1[first]);
                first++;
                second++;
            } else if(nums1[first] > nums2[second]) {
                second++;
            } else {
                first++;
            }
        }

        int[] intersection = new int[result.size()];
        int i = 0;
        for(int r: result) {
            intersection[i++] = r;
        }
        return intersection;
    }
}