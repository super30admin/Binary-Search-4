class Solution:
    def arraysIntersection(self, arr1: List[int], arr2: List[int], arr3: List[int]) -> List[int]:

        """Solution 1 three pointer solution"""
        # tc: O(n) total length of all input arrays
        #     and sc is 1
        p1 = p2 = p3 = 0
        result = []
        while p1 < len(arr1) and p2 < len(arr2) and p3 < len(arr3):
            if arr1[p1] == arr2[p2] == arr3[p3]:
                result.append(arr1[p1])
                p1 += 1
                p2 += 1
                p3 += 1
            else:
                if arr1[p1] < arr2[p2]:
                    p1 += 1
                elif arr2[p2] < arr3[p3]:
                    p2 += 1
                else:
                    p3 += 1
        return result

#         """Solution 2 hashmap solution"""
#         ###below tc On and sc on
#         result=[]
#         hashmap={}
#         for e in arr1:
#             if e in hashmap:
#                 hashmap[e]+=1
#             else:
#                 hashmap[e]=1

#         for e in arr2:
#             if e in hashmap:
#                 hashmap[e]+=1
#             else:
#                 hashmap[e]=1

#         for e in arr3:
#             if e in hashmap:
#                 hashmap[e]+=1
#             else:
#                 hashmap[e]=1


#         for k, v in hashmap.items():
#             if v==3:
#                 result.append(k)

#         return result


