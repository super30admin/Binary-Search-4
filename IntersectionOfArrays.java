class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
        return intersect(nums2, nums1);
    }
    HashMap<Integer, Integer> m = new HashMap<>();
    for(int i=0;i<nums1.length;i++) {
        m.put(nums1[i], m.getOrDefault(nums1[i], 0) + 1);
    }
    int k = 0;
    for (int i=0;i<nums2.length;i++) {
        int count = m.getOrDefault(nums2[i], 0);
        if (count > 0) {
            nums1[k++] = nums2[i];
            m.put(nums2[i], count - 1);
        }
    }
    return Arrays.copyOfRange(nums1, 0, k);
    }
}

//Time complexity : O(n+m) n is length of nums1 and m is length of nums2
//Space complexity : O(min(m,n))
