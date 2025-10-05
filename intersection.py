class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1=len(nums1)
        n2=len(nums2)

        if n1>n2:
            self.intersection(nums2,nums1)
        
        smap={}
        result=[]
        seen=set()

        for num in nums1:
            smap[num]=smap.get(num,0)+1
        
        for num in nums2:
            if num in smap and num not in seen:
                result.append(num)
                seen.add(num)
                smap[num]-=1
                if smap[num]==0:
                    del smap[num]
        return result

            
