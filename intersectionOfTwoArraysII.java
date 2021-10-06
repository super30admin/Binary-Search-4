class intersectionOfTwoArrays {

    // TC: O(nlogn + mlogm) SC: O(log n + log m)
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                result.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                p1++;
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}