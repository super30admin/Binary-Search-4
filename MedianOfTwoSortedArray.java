// TC : O(log(min(m,n))
// SC: O(1)
// Approach - Use the approach of paritioning and finding how many numbers to pick from left
// and right of each array to form a sorted array without actually traversing the entire arrays

public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = n1;
        int n = n1 + n2;

        while (low <= high) {
            int partX = low + (high - low)/2;
            int partY = n/2 - partX;

            double l1 = (partX == 0) ? Integer.MIN_VALUE : nums1[partX - 1];
            double r1 = (partX == n1) ? Integer.MAX_VALUE : nums1[partX];

            double l2 = (partY == 0) ? Integer.MIN_VALUE : nums2[partY - 1];
            double r2 = (partY == n2) ? Integer.MAX_VALUE : nums2[partY];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 != 0) {
                    return Math.min(r1, r2);
                }

                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            } else if (l1 > r2) {
                high = partX - 1;
            } else if (l2 > r1){
                low = partX + 1;
            }
        }

        return 12.0;
    }
