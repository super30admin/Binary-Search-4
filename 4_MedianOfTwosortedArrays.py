class Solution:
	def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
		# Time Complexity : O(m + n) where m in the length of nums1 and n is the length of nums2
        # Space complexity : O(1)
		res = []
		p1 = 0
		p2 = 0
        # Combine both arrays in sorted manner
		while p1 < len(nums1) and p2 < len(nums2):
			if nums1[p1] < nums2[p2]:
				res.append(nums1[p1])
				p1 += 1
			else:
				res.append(nums2[p2])
				p2 += 1
        
        
		if p1 < len(nums1):
			res.extend(nums1[p1:])
		if p2 < len(nums2):
			res.extend(nums2[p2:])
		mid = len(res)//2
		if len(res)%2 == 0:
			return (res[mid] + res[mid - 1])/2
		else:
			return res[mid]

