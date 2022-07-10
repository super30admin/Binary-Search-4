class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
#         time complexity is o(m+n), where m,n is the size of the input
#         space complexity is o(m), where m is the sze of the input with less elements
        if(len(nums1) > len(nums2)):
            return self.intersect(nums2, nums1)
        d = dict()
        res = list()
        for i in nums1:
            if(i not in d):
                d[i] = 0
            d[i] += 1
        for i in nums2:
            if(i in d):
                res.append(i)
                d[i] -= 1
                if(d[i] == 0):
                    del d[i]
        return res
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
#         l = list()
#         d1 = dict()
#         d2 = dict()
#         for i in nums1:
#             if i not in d1:
#                 d1[i] = 1
#             else:
#                 d1[i] += 1
#         for i in nums2:
#             if i not in d2:
#                 d2[i] = 1
#             else:
#                 d2[i] += 1
#         for i in d1:
#             if(i in d2):
#                 if(d1[i] <= d2[i]):
#                     while d1[i]:
#                         # print("i = {0} and d2[i] = {1}".format(i, d2[i]))
#                         l.append(i)
#                         d1[i] -= 1
#                 else:
#                     while d2[i]:
#                         l.append(i)
#                         d2[i] -= 1
#         return l
                        
                
                