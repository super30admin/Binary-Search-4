/**
Intuition:
We first store how many times each number appears in the smaller array, so we know exactly how many matches are allowed.
Then we iterate through the second array and, whenever a number exists in the map, we add it to the result and decrease its count.
Once a number’s count reaches zero, we remove it to prevent extra duplicates.

T.C: O(m+n)
S.C: O(min(m,n))
 */

var intersect = function (nums1, nums2) {
    if (nums1.length > nums2.length) {
        return intersect(nums2, nums1);
    }
    let map = new Map();
    // iteration over nums1
    for (let num of nums1) {
        map.set(num, (map.get(num) || 0) + 1);
    }
    const result = [];

    // iteration over nums2
    for (let num of nums2) {
        if (map.has(num)) {
            let count = map.get(num);
            count--;
            result.push(num);
            if (count === 0) {
                map.delete(num);
            } else {
                map.set(num, count);
            }
        }
    }

    return result;
};