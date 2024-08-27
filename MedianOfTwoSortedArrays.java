/*
    Approach: Binary Search

    Time Complexity: O(log m)
    Space Complexity: O(1)

 */

class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            return findMedianSortedArrays(arr2, arr1); // Ensure arr1 is the smaller array
        }

        int len1 = arr1.length, len2 = arr2.length;
        int left = 0, right = len1;

        while (left <= right) {
            int partition1 = left + (right - left) / 2;
            int partition2 = (len1 + len2) / 2 - partition1;

            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : arr1[partition1 - 1];
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : arr2[partition2 - 1];
            int minRight1 = (partition1 == len1) ? Integer.MAX_VALUE : arr1[partition1];
            int minRight2 = (partition2 == len2) ? Integer.MAX_VALUE : arr2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Correct partition
                if ((len1 + len2) % 2 == 1) {
                    return Math.min(minRight1, minRight2); // Odd length, return middle value
                } else {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0; // Even length, return average of two middle values
                }
            } else if (maxLeft1 > minRight2) {
                right = partition1 - 1; // Move left
            } else {
                left = partition1 + 1; // Move right
            }
        }

        return 200.00;
    }
}

