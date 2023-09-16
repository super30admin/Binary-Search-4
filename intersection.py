class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        m = len(nums1)
        n = len(nums2)

        li = []

        if m > n:
            self.intersect(nums2,nums1)

        hmap = {}

        for num in nums1:
            if num not in hmap:
                hmap[num] = 1
            else:
                hmap[num] += 1
            print(hmap)
        for num in nums2:
            if num in hmap:
                li.append(num)
                hmap[num] -= 1
                if hmap[num] == 0:
                    del hmap[num]

        return li   
            
            


        
        