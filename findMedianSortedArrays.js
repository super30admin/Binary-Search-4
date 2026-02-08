
/**
We binary-search on the smaller array to find a partition such that the left halves of both arrays contain half of the total elements.
At each step, we check whether the maximum element on the left side is less than or equal to the minimum element on the right side across both arrays.
Once this condition holds, the median is determined from the boundary elements of the two partitions, depending on whether the total length is even or odd.
T.C: O(log(min(m,n)))
S.C: O(1)
 */


var findMedianSortedArrays = function (nums1, nums2) {
    if (nums1.length > nums2.length) {
        return findMedianSortedArrays(nums2, nums1);
    }

    let left = 0, right = nums1.length;
    const totalLength = nums1.length + nums2.length;

    while (left <= right) {
        // finding mid(partition index) for nums1
        const partX = left + Math.floor((right - left) / 2);
        // find partition y using partx and total length
        const partY = Math.floor((totalLength + 1) / 2) - partX;
        // if partX is 0 then there is no sub array before 0, so set it to min val
        const l1 = partX === 0 ? -Infinity : nums1[partX - 1];
        // if partX is at the last index of nums1 then set it to Infinity 
        const r1 = partX === nums1.length ? Infinity : nums1[partX];
        // if partY is 0 then there is no sub array before 0, so set it to min val
        const l2 = partY === 0 ? -Infinity : nums2[partY - 1];
        // if partY is at the last index of nums1 then set it to Infinity 
        const r2 = partY === nums2.length ? Infinity : nums2[partY];

        if (l1 <= r2 && l2 <= r1) {
            if (totalLength % 2 === 0) {
                // if the length is even
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            } else {
                // if the length is odd
                return Math.max(l1, l2);
            }
        } else if (l1 > r2) {
            right = partX - 1;
        } else {
            left = partX + 1;
        }
    }
};
