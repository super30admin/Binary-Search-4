class Solution:
	#Time complexity - O(max(m,n))
    #Space complexity - O(max(m,n))
    #Works on leetcode - yes
    #Approach - First we iterate through one array and keep the frequency in a dictionary. Then we iterate through the second array and check
    #if the element exists in dictionary. If it is, we add it to the answer and decrement it's frequency
    def intersect1(self, nums1: List[int], nums2: List[int]) -> List[int]:
        mapp, ans = {}, []
        for n1 in nums1:
            mapp[n1] = mapp[n1]+1 if n1 in mapp else 1
        for n2 in nums2:
            if n2 in mapp and mapp[n2]>0:
                ans.append(n2)
                mapp[n2]-=1
        return ans

    #Time complexity - O(nlogn+mlogm)
    #Space complexity - O(1)
    #Works on leetcode - yes
    #Approach - We first sort both arrays and use two pointers to iterate through both arrays. If both elements are equal, we add it to the result
    #else increment the respective pointer if its less than other element. 
    def intersect2(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        pt1 = pt2 = 0
        res = []

        while True:
            try:
                if nums1[pt1] > nums2[pt2]:
                    pt2 += 1
                elif nums1[pt1] < nums2[pt2]:
                    pt1 += 1
                else:
                    res.append(nums1[pt1])
                    pt1 += 1
                    pt2 += 1
            except IndexError:
                break

        return res

    #Time complexity - O(min(m,n)*log max(m,n)), for the follow up that if both are sorted
    #Space complexity - O(1)
    #Works on leetcode - yes
    #Approach - We first figure out which is the shorter array and loop through it, for every element, we binary search it on the other array.
    #  when we binary search, we need to find the left-most matching number. Since the inputs are sorted, next time we perform a binary search, 
    # the low should start the previously found index+1.
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        if len(nums1) > len(nums2): 
            nums1, nums2 = nums2, nums1
        
        def binarySearch(nums, low, high, target): 
            while low < high: 
                mid = (low+high)//2 
                if nums[mid] >= target: 
                    high = mid
                else: 
                    low = mid+1 
            if 0 <= low < len(nums) and nums[low] == target: 
                return low 
            else: 
                return -1
            
        res = []
        l,h = 0, len(nums2)
        for i in range(len(nums1)):
            index = binarySearch(nums2,l,h,nums1[i])
            if index!=-1:
                l = index+1
                res.append(nums2[index])
        return res