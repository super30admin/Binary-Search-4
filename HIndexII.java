package com.ds.rani.bs;

/**
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * <p>
 * Example:
 * <p>
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 * received 0, 1, 3, 5, 6 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining
 * two with no more than 3 citations each, her h-index is 3.
 * Note:
 * <p>
 * If there are several possible values for h, the maximum one is taken as the h-index.
 * <p>
 * Follow up:
 * <p>
 * This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
 * Could you solve it in logarithmic time complexity?
 */

//Approach:Use binary search,calculate diff=n-mid, if that difference equals to nums[mid] then return diff.
//if diff is greater than nums[mid] then search in left part
//if diff is less than nums[mid] search in right part

//Time Complexity:log(n)
//space complexity:o(1)
public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;

        int n = citations.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int idxDiff = n - mid;

            if (idxDiff == citations[mid])
                return idxDiff;
            else if (idxDiff < citations[mid]) {//search on left
                right = mid - 1;
            } else {//when idxDiff>nums[mid] search at right
                left = mid + 1;
            }
        }
        return n - left;

    }
}
