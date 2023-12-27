/*
approach -1
1. combine both arrays
2. sort array , or just add the pointers and compare and add it to the COMB array!
3. find median
tc: O(m+n)
sc: O(m+n)
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // base case
        if (nums1 == null && nums2 == null)
            return 0.00;

        int n1 = nums1.length;
        int n2 = nums2.length;
        int n3 = n1 + n2;
        int[] comb = new int[nums1.length + nums2.length];

        int p1 = 0, p2 = 0, i = 0;
        while (p1 < n1 && p2 < n2) {
            if (nums1[p1] < nums2[p2]) {
                comb[i++] = nums1[p1];
                p1++;
            } else {
                comb[i++] = nums2[p2];
                p2++;
            }
        }

        while (p1 < n1) {
            comb[i++] = nums1[p1];
            p1++;
        }

        while (p2 < n2) {
            comb[i++] = nums2[p2];
            p2++;
        }

        // we have comb as sorted array with O(m+n) sorting

        if (n3 % 2 == 0) {
            double median = (comb[n3 / 2 - 1] + comb[n3 / 2]) / 2.0;
            // System.out.println("n3/2-1 : "+comb[n3/2 -1] + " n3/2 : "+comb[n3/2]+ "\n
            // median : "+median);
            return median;
        }

        return comb[n3 / 2];
    }
}

/**
 * //approach -2
 * //take half part from one array and second half part from second array.
 * //decide the partition based on the first array, so if we take x elements
 * from 1st array, it will be M-x elements from second aray.
 * //where M= sum of the length of both array/2
 * // we also check if partitions are valid, for that we have condition check
 * for this two sorted array's partition,
 * //first array hold l1 and r1, while second holds l2 and r2.
 * //l1<=r2 && l2 <=r1; if this satisfy means partition is valid
 * //now check if m+n is odd ? then answer is min of (r1,r2) else (P+Q)/2; P =
 * Max of (l1,l2); Q = Min of (r1,r2);
 * //apply binary search on the Minimum array for partition !
 * //if while partitioning, any time if l1 or l2 becoms out of bound, then
 * assign it -infinity
 * //and for r1 and r2 assign them +infinity.
 * //for nums1 = [1,2,3,4,5,6,7] , nums2 =[5,6,7,8,9], let say partition is like
 * in box pattern, when we define the partition on the vertical line
 * //if we make partition aafter 3, then l1 =3 and r1 =4,
 * //because we took the 3 elemnt from the first array and m+n/2 = 6; we will
 * take 6-3 =3 element from second array.
 * //so l2 = 7 nd r2 = 8.
 * //now we check the condition, if all satisfy then good to go for answer , if
 * not then just update the high.
 * //so , if l1 <= r2 is false, that mean l1 has higher alue and so we should
 * move partition of nums1 left, which will ultimately move the nums2's
 * partition to the right.
 * //if l2<=r1 is false; then l2 is greater then r1, so we move right and
 * partition will extend on right side more for nums, whih will ultimately
 * result in less partition / less number of element from nums2.
 * //we use binary search here to get the correct partition.
 * sc: O(1)
 * tc: O(log (m+n))
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // base case
        if (nums1 == null && nums2 == null)
            return 0.00;

        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = n1;

        while (low <= high) {
            // calculate mid
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2) / 2 - partX;

            /// calculate l1,r1 && l2, r2

            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];

            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            // update the high and low pointer based on l1,r1 and l2, r2 comparisions
            if (L2 <= R1 && L1 <= R2) {
                // correct partition , calculate median
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else
                    return Math.min(R1, R2);
            } else if (L1 > R2) // Move Left
            {
                high = partX - 1;
            } else // Move Right
            {
                low = partX + 1;
            }
        }
        return 83581;
    }
}