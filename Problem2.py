class Solution:
	def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
		# Sort both the arrays and use two pointers to find the intersection between both the lists
		# Time Complexity : O(nlogn) + O(mlogm) + O(m + n) - first two terms for sorting the arrays and then going through each element in the array
		# Accepted on leetcode
		p1 = 0
		p2 = 0
		res = []
		nums1.sort()
		nums2.sort()
		while p1 < len(nums1) and p2 < len(nums2):
			if nums1[p1] == nums2[p2]:
				res.append(nums1[p1])
				p1 += 1
				p2 += 1
			elif nums1[p1] > nums2[p2]:
				p2 += 1
			else:
				p1 += 1
		return res

	def intersect(self, nums1: 'List[int]', nums2: 'List[int]') -> 'List[int]':
		# For every element in nums1 array check if it exists in the nums2 array. If its exists remove that element from the nums2 array and add it to the result
		# Time Complexity : O(mn) where m is the length of the nums1 and n is the length of nums2.
		# To remove the element from nums2 is O(n) again.
		# Accepted on leetcode
        common = []
        for i in nums1:
            if i in nums2:
                common.append(i)
                nums2.remove(i)
        return common