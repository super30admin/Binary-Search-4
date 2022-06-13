TC - O(N)
SC - O(1)

/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
 var intersect = function(nums1, nums2){
const map = new Map();
    for (const n of nums1) {
        map.set(n, map.get(n) + 1 || 1);
    }
    const result = [];
    for (const n of nums2) {
        if (map.has(n) && map.get(n) > 0) {
            result.push(n);
            map.set(n, map.get(n) - 1);
        }
    }
    return result;
}