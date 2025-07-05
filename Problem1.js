// ## Problem1 
// Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)


var intersect = function(nums1, nums2) {
    //!Follow up if the array is sorted
    //TC : O(m+n)
    //SC : O(1)
    nums1 = nums1.sort((a,b)=>a-b)
    nums2 = nums2.sort((a,b)=>a-b)
    console.log(nums1)
    console.log(nums2)
    //
    let res = []
    let p1 = 0
    let p2 = 0
    while(p1 < nums1.length && p2 < nums2.length){
        if(nums1[p1]==nums2[p2]){
            res.push(nums1[p1])
            p1++
            p2++
        }
        if(nums1[p1] < nums2[p2]){
            p1++
        }
        else if(nums2[p2] < nums1[p1]){
            p2++
        }
    }
    return res
};

// var intersect = function(nums1, nums2) {
//     //Time complexity : O(m+n) (maximum of m and n)
//     //Space Complexity : O(min(m,n)) becasue we always make hashmap of smalllarray
//     let res = [];
    
//     // Always use the shorter array to build the hashmap
//     if (nums2.length > nums1.length) {
//         return intersect(nums2, nums1);
//     }

//     let hashMap = new Map();

//     for (let i = 0; i < nums1.length; i++) {
//         if (hashMap.has(nums1[i])) {
//             hashMap.set(nums1[i], hashMap.get(nums1[i]) + 1);
//         } else {
//             hashMap.set(nums1[i], 1);
//         }
//     }

//     for (let i = 0; i < nums2.length; i++) {
//         if (hashMap.has(nums2[i])) {
//             res.push(nums2[i]);
//             hashMap.set(nums2[i], hashMap.get(nums2[i]) - 1);
//             if (hashMap.get(nums2[i]) === 0) {
//                 hashMap.delete(nums2[i]);
//             }
//         }
//     }

//     return res;
// };
