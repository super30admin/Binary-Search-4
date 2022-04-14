
// appraoch : freq map
// m = larger array
// n = smaller array
// time: o(n+m) - loop over n array and store in a map, then loop over m array to find in nMap
// space: o(n) - store the smaller array in map to keep space footprint small
// func intersect(nums1 []int, nums2 []int) []int {
//     m := map[int]int{}
//     out := []int{}
//     if len(nums1) < len(nums2) {
//         for _, ele := range nums1 {
//             m[ele]++
//         }
//         for i := 0; i < len(nums2); i++ {
//             if _, ok := m[nums2[i]]; ok {
//                 m[nums2[i]]--
//                 if freq := m[nums2[i]]; freq == 0 {
//                     delete(m, nums2[i])
//                 }
//                 out = append(out, nums2[i])
//             }
//         }
//     } else {
//         for _, ele := range nums2 {
//             m[ele]++
//         }
//         for i := 0; i < len(nums1); i++ {
//             if _, ok := m[nums1[i]]; ok {
//                 m[nums1[i]]--
//                 if freq := m[nums1[i]]; freq == 0 {
//                     delete(m, nums1[i])
//                 }
//                 out = append(out, nums1[i])
//             }
//         }
//     }
//     return out
// }

// approach sort + two pointers
// time: 
//     if we count sorting: o(n1logn1) + o(n2logn2) + o(n1+n2)
//      or else 2 ptrs on 2 arrays o(n1+n2)
// space: o(1) if we do not count output array as part of space
// func intersect(nums1 []int, nums2 []int) []int {
//     sort.Ints(nums1)
//     sort.Ints(nums2)
//     out := []int{}
//     n1 := 0
//     n2 := 0
    
//     for n1 < len(nums1) && n2 < len(nums2) {
//         if nums1[n1] == nums2[n2] {
//             out = append(out, nums1[n1])
//             n1++
//             n2++
//         } else if nums1[n1] < nums2[n2] {
//             n1++
//         } else {
//             n2++
//         }
//     }
//     return out
// }



// binary search
// m = larger array
// n = smaller array
// time: o(nlogm) -- IF we do not count the sorting of array
// time: (omlogm) + o(nlogn) + o(nlogm) -- IF we count sorting of both arrays
// space: o(1)
func intersect(nums1 []int, nums2 []int) []int {
    // to make sure nums1 is always bigger 
    if len(nums2) > len(nums1) {
        return intersect(nums2, nums1)
    }
    
    sort.Ints(nums1)
    sort.Ints(nums2)
    
    // so now we can imply nums1 is always bigger
    m := len(nums1)
    out := []int{}
    // we should do binary search on the larger array 
    // so we can get smaller time complx
    // for every n in smaller array, do binary search on bigger array
    left := 0
    right := m-1
    for i := 0; i < len(nums2); i++ {
        idx := binarySearch(left, right, nums2[i], nums1)
        if idx != -1 {
            out = append(out, nums2[i])
            // why idx+1 and not left++ ?
            // because we found the leftest idx of our target, which 
            // means that our left boundary ( in sorted array ) shrinked
            left = idx+1
        }
    }
    return out
}

// search for the leftest possible idx of target ( yes target can exist multiple times )
func binarySearch(left, right, target int, nums []int) int {
    for left <= right {
        mid := left + ((right-left))/2
        if nums[mid] == target {
            if mid == left || nums[mid-1] != target {
                return mid
            } else {
                right = mid-1
            }
        } else if nums[mid] > target {
            right = mid-1
        } else {
            left = mid+1
        }
    }
    return -1
}

