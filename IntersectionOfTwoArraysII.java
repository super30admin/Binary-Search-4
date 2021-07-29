class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i=0; i<nums2.length; i++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }

        int[] array = list.toArray(new int[0]);

        return array;
    }
}