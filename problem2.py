# Solution 1
# compare each element in two arrays and replace the number once it is found.
# O(n*m) time  complexity | O(m) space complexity
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) > len(nums2):
            return self.intersect(nums2, nums1)
        
        answer = []
        for elem in nums1:
            for i in range(len(nums2)):
                if elem == nums2[i]:
                    nums2[i] = float('inf') # cannot multiply by -1 (this will fail in case the element is 0)
                    answer.append(elem)
                    break
                    
        return answer

# Solution 2
# using binary search
# time complexity O(n*logn) | space complexity O(m)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
    	n, m = len(nums1), len(nums2)
        if n>m:
            return self.intersect(nums2, nums1)
        
        # O(nlogn)
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        
        answer, low = [], 0
        # find element of the smaller array in the larger one.
        # binary search - O(mlogn) if n>m
        for elem in nums1:
            low, ret = self.bSearch(elem, nums2, low, m-1)
            if ret!=-1:
                answer.append(elem)
        
        return answer

 	def bSearch(self, elem, nums, low, high):
        while low <= high:
            mid = low + (high-low) // 2
            if elem == nums[mid] and (low==mid or (low<mid and mid!=0 and nums[mid-1]!=elem)):
                return mid+1, mid
            elif elem > nums[mid]:
                low = mid+1
            else:
                high = mid-1
            
        return low, -1


# Solution 3
# using pointers
# time complexity O(n*logn) | space complexity O(m)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n, m = len(nums1), len(nums2)
        if n>m:
            return self.intersect(nums2, nums1)
        
        # O(nlogn)
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        
        answer, low = [], 0
        # find element of the smaller array in the larger one.
        # O(n+m) = O(n) time complexity (n>m) 
        for elem in nums1:
            low, ret = self.lSearch(elem, nums2, low, m-1)
            if ret!=-1:
                answer.append(elem)
        
        return answer
    
    def lSearch(self, elem, nums, ptr1, ptr2):
        while ptr1 <= ptr2:
            if elem == nums[ptr1]:
                return ptr1+1, ptr1
            elif elem > nums[ptr1]:
                ptr1 += 1
            else:
                return ptr1, -1
            
        return ptr1, -1


# using hash maps
# space complexity - O(n) | time complexity - (m+n)=O(n)
class Solution:
	def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
	    n, m = len(nums1), len(nums2)
	    if n>m:
	        return self.intersect(nums2, nums1)

	    nums = defaultdict(lambda: 0)
        for elem in nums2:
            nums[elem] += 1
        
        answer = []
        for elem in nums1:
            if elem in nums:
                answer.append(elem)
                nums[elem] -= 1
                if nums[elem] == 0:
                    del nums[elem]
                
        return answer

