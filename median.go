// Time Complexity : O(log(m+n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
recall function so that nums1 is shorter array and nums2 is longer
set low to 0 and high to len(nums1)

while low<=high
set midArr1 is mid of 1st array and midArr2 to (m + n + 1)/2 - midArr1

set min Left & Right for arr1 and max left &right for arr2
maxLArr1 <= minRArr2 && maxLArr2 <= minRArr1 (correct location for partition)
if even no of elements then avg of biggest of left side and smallest of right side of partition
if odd then biggest of left side as there is 1 extra element on left side
else if maxLArr1 > minRArr2 then high is midArr1 - 1
else low is midArr1 + 1
*/
package main

import "fmt"

const MaxInt = int(^uint(0) >> 1)
const MinInt = -MaxInt - 1

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	if len(nums1) > len(nums2) {
		return findMedianSortedArrays(nums2, nums1)
	}
	m := len(nums1)
	n := len(nums2)
	low := 0
	high := m

	for low <= high {
		midArr1 := low + (high - low)/2
		midArr2 := (m + n + 1)/2 - midArr1

		maxLArr1 := MinInt
		if midArr1 != 0 {
			maxLArr1 = nums1[midArr1 - 1]
		}
		minRArr1 := MaxInt
		if midArr1 != m {
			minRArr1 = nums1[midArr1]
		}

		maxLArr2 := MinInt
		if midArr2 != 0 {
			maxLArr2 = nums2[midArr2 - 1]
		}
		minRArr2 := MaxInt
		if midArr2 != n {
			minRArr2 = nums2[midArr2]
		}

		if maxLArr1 <= minRArr2 && maxLArr2 <= minRArr1 {
			if (m+n)%2 == 0 {
				return (float64(max(maxLArr1, maxLArr2)) + float64(min(minRArr1, minRArr2)))/2
			} else {
				return float64(max(maxLArr1, maxLArr2))
			}
		} else if maxLArr1 > minRArr2 {
			high = midArr1 - 1
		} else {
			low = midArr1 + 1
		}

	}
	return -1.0
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func MainMedian() {
	fmt.Println(findMedianSortedArrays([]int{1,2}, []int {3,4})) //expected 2.5
}
