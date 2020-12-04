// Time Complexity : O(nlog(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
sort both arrays
while both indexes are valid
if both have same value then append it to result and increment both indices
if nums1[i]<nums2[j] increment i
else if nums1[i]>nums2[j] do j++
return res
*/
package main

import (
	"fmt"
	"sort"
)

func intersect(nums1 []int, nums2 []int) []int {
	sort.Ints(nums1)
	sort.Ints(nums2)

	res := []int{}
	i, j := 0, 0

	for i < len(nums1) && j < len(nums2) {
		if nums1[i] == nums2[j] {
			res = append(res, nums1[i])
			i++
			j++
			continue
		}

		if nums1[i] < nums2[j] {
			i++
		} else if nums1[i] > nums2[j] {
			j++
		}
	}

	return res
}

func MainIntersection() {
	fmt.Println(intersect([]int{4,9,5}, []int{9,4,9,8,4})) //expected [4, 9]
}
