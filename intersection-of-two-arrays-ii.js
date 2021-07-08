// Time Complexity : O(NlogN + MlogM)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function(nums1, nums2) {
    if (!nums1 || !nums1.length) return [];
    if (!nums2 || !nums2.length) return [];
    
    // Sort both arrays
    nums1 = nums1.sort((a, b) => {return a - b});
    nums2 = nums2.sort((a, b) => {return a - b});

    // Loop thru both arrays using 2 pointers and populate results
    let result = [],
        p1 = 0,
        p2 = 0;
    
    while (p1 < nums1.length && p2 < nums2.length) {
        if (nums1[p1] == nums2[p2]) {
            result.push(nums1[p1]);
            p1++;
            p2++;
        }
        else if (nums1[p1] < nums2[p2]) p1++;
        else p2++;
    }
    return result;
};
