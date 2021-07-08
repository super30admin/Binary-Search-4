// Time Complexity : O(log(Min(M, N)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, this is hard

/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    let xLen = nums1.length,
        yLen = nums2.length;
    
    if (xLen > yLen) return findMedianSortedArrays(nums2, nums1);
    
    let left = 0,
        right = xLen,
        partitionX,
        partitionY,
        maxLeftX,
        minRightX,
        maxLeftY,
        minRightY;
    
    while (left <= right) {
        partitionX = Math.floor((left + right) / 2);
        partitionY = Math.floor((xLen + yLen + 1) / 2) - partitionX;
        
        maxLeftX = partitionX == 0 ? -Infinity : nums1[partitionX - 1];
        
        minRightX = partitionX == xLen ? Infinity : nums1[partitionX];
        
        maxLeftY = partitionY == 0 ? -Infinity : nums2[partitionY - 1];
        
        minRightY = partitionY == yLen ? Infinity : nums2[partitionY];
        
        if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
            if ((xLen + yLen) % 2 == 0) return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
            else return Math.max(maxLeftX, maxLeftY);
        } else if (maxLeftX > minRightY) {
            right = partitionX - 1;
        } else {
            left = partitionX + 1;
        }
    }
    
    return 0;
};
