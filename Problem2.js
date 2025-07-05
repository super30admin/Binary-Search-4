// ## Problem2
// Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

var findMedianSortedArrays = function(x, y) {
    //O(log(min(m,n))) : TC
    // Sc : O(1)
    if (x.length > y.length) {
        return findMedianSortedArrays(y, x);
    }

    const n1 = x.length;
    const n2 = y.length;
    let left = 0, right = n1;

    while (left <= right) {
        const partX = Math.floor((left + right) / 2);
        const partY = Math.floor((n1 + n2 ) / 2) - partX;

        const L1 = partX === 0 ? -Infinity : x[partX - 1];
        const L2 = partY === 0 ? -Infinity : y[partY - 1];
        const R1 = partX === n1 ? Infinity : x[partX];
        const R2 = partY === n2 ? Infinity : y[partY];

        if (L1 <= R2 && L2 <= R1) {
            if ((n1 + n2) % 2 === 0) {
                return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
            } else {
                return Math.min(R1, R2);
            }
        } else if (L1 > R2) {
            right = partX - 1;
        } else {
            left = partX + 1;
        }
    }
};
// var findMedianSortedArrays = function(nums1, nums2) {
//     const merged = [...nums1, ...nums2].sort((a, b) => a - b);
//     const len = merged.length;
//     const mid = Math.floor(len / 2);
//     return len % 2 === 0 
//         ? (merged[mid - 1] + merged[mid]) / 2 
//         : merged[mid];
// };