// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
set left to 0 and right to n
while l<r set mid element
if citations[mid] >= n-mid (valid) then check if mid is 0 or the element previous to it is invalid then return n-mid or else set r = mid
else set l = mid+1
*/
package main

import "fmt"

func hIndex(citations []int) int {
	n := len(citations)
	/*for i:=0;i<n;i++ {
	      diff := n - i
	      if diff <= citations[i] {
	          return diff
	      }
	  }
	  return 0*/
	l, r := 0, n
	for l < r {
		mid := l + (r - l) / 2
		if citations[mid] >= n - mid {
			if mid == 0 || citations[mid-1] < n - (mid - 1) {
				return n - mid
			}
			r = mid
		} else {
			l = mid + 1
		}
	}
	return 0
}

func MainHIndex() {
	fmt.Println(hIndex([]int{0,1,3,5,6})) //expected 3
}
