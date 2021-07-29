class MedianOfTwoArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums = new int[nums1.length + nums2.length];

        int counter1 = 0;
        int counter2 = 0;
        int i =0;
        while (i < nums.length) {

            if (nums1[counter1] > nums2[counter2]) {
                nums[i] = nums1[counter1];
                counter1++;
                i++;
            } else if (nums1[counter1] < nums2[counter2]) {
                nums[i] = nums2[counter2];
                counter2++;
                i++;
            } else {
                nums[i] = nums1[counter1];
                i++;
                nums[i] = nums2[counter2];
                i++;
            }

        }
        int result = 0;
        int half = nums.length / 2;
        if (nums.length % 2 == 0) {
            result = (nums[half] + nums[half + 1]) / 2;
        } else {
            result = nums[half];
        }

        return result;

    }
}