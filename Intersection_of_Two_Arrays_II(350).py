class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # Hashmap Solution:
        # T.C. = O(m+n)
        # S.C = O(min(m,n))
        m = len(nums1)
        n = len(nums2)

        if n>m:
            self.intersect(nums2,nums1)

        hashmap = dict()
        for elem in nums2:
            if elem not in hashmap:
                hashmap[elem] = 1
            else:
                hashmap[elem] += 1

        res = list()

        for elem in nums1:
            if elem in hashmap:
                res.append(elem)
                hashmap[elem] -= 1
                if hashmap[elem]==0: # once we have exhausted the element remove from the dict so that duplicates dont occur
                    hashmap.pop(elem)

        return res

        #2pointer solution (better if the arrays are sorted)
        # T.C. = O(mlogm + nlogn) (for sorting) + O(m+n)
        # S.C = O(1) if result array is not counted as auxiliary space
        # nums1.sort()
        # nums2.sort()
        # m = len(nums1)
        # n = len(nums2)
        # first = 0
        # second = 0
        # res = list()

        # while((first<m) and (second<n)):
        #     if nums1[first]<nums2[second]:
        #         first+=1
        #     elif nums1[first]>nums2[second]:
        #         second+=1
        #     else:
        #         res.append(nums1[first])
        #         first+=1
        #         second+=1

        # return res

        #binary search solution
        # T.C. = O(nlogm)
        # S.C = O(1)
        # if nums1 is None or nums2 is None or len(nums1)==0 or len(nums2)==0:
        #     return []
        # m = len(nums1)
        # n = len(nums2)
        # if n>m:
        #     self.intersect(nums2,nums1)
        # nums1.sort()
        # nums2.sort()
        # left = 0
        # res = list()
        # low = 0
        # last = 0

        # def binarySearch(low,high,elem):
        #     while low<=high:
        #         mid = low + ((high-low)//2)
        #         if nums1[mid]>elem:
        #             high = mid-1
        #         elif nums1[mid]<elem:
        #             low = mid+1
        #         else:
        #             # Make sure it is the leftmost element
        #             if mid==low or nums1[mid-1]!=elem:
        #                 res.append(elem)
        #                 return mid
        #             high = mid-1
        #     return -1

        # for elem in nums2:
        #     high = m-1
        #     last = binarySearch(low,high,elem)
        #     # if last is -1 then the element was not found and no need to update low
        #     if last!=-1:
        #         low = last+1
        # return res

