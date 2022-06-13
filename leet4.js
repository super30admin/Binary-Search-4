TC - O(m+n)
SC - O(m+n)
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    var len = nums1.length+nums2.length-1;
    var m = nums1.length;
    var n = nums2.length;
    m--;
    n--;
    while(n>=0)
    {
        nums1[len--] = nums1[m]>nums2[n] ? nums1[m--]:nums2[n--];
    }
    return nums1.length%2===0? Math.floor(nums1[nums1.length/2]+nums1[(nums1.length/2)-1])/2 
       : nums1[Math.floor(nums1.length/2)];
};