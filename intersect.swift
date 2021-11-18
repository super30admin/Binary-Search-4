

// Time Complexity : O(N logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :



    func intersect(_ nums1: [Int], _ nums2: [Int]) -> [Int] {
        if nums1.count == 0 || nums1 == nil || nums2.count == 0 || nums2 == nil {
            return []
        }
    var nums1 = nums1.sorted()
    var nums2 = nums2.sorted()
    var output = [Int]()
    var p1 = 0
    var p2 = 0     
    while p1 < nums1.count && p2 < nums2.count {
        if nums1[p1] == nums2[p2] {
          output.append(nums1[p1])
           p1 += 1
           p2 += 1
        } else if nums1[p1] < nums2[p2] {
            p1 += 1
        } else {
            p2 += 1
        }
    }
     return output
    }
