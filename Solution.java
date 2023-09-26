import java.util.*;

class IntersectionofTwoArraysII {
    public static void main(String[] args) {
        int[] m = { 1, 2, 2, 1 };
        int[] n = { 2, 2 };
        IntersectionofTwoArraysII obj = new IntersectionofTwoArraysII();
        int[] obj1 = obj.intersect(m, n);
        System.out.println(Arrays.toString(obj1));
    }

    // TC: O(m+n) //SC: O(1)
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length;
        int n = nums2.length;
        if (m > n)
            intersect(nums2, nums1);
        List<Integer> li = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] == nums2[p2]) {
                li.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums2[p2] < nums1[p1]) {
                p2++;
            } else {
                p1++;
            }
        }
        int[] result = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            result[i] = li.get(i);
        }
        return result;
    }
}

class MedianofTwoSortedArrays {
    // TC: O(log(min(m,n1))) //SC: O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // null check
        if (nums1.length == 0 && nums2.length == 0)
            return 0.0;

        // partition in nums1
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0;
        int high = n1;// as for n elements partiction is n+1; so for n-1 elements partition is n
        while (low <= high) {
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2) / 2 - partX;// partition formula

            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            // if partition at 0 then l1 is - inf and r1 is nums[p]

            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 != 0) { // odd
                    return Math.min(r1, r2);

                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }
            } else if (l2 > r1) {
                low = partX + 1;
            } else if (l1 > r2) {
                high = partX - 1;
            }
        }
        return 2142.43223;
    }
}

public class Solution {
}