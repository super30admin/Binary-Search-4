# O(N + M) TIME AND O(N) SPACE WHERE N IS LEN(NUMS1) AND M IS LEN(NUMS2)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        hashtable={}
        output=[]
        for i in nums1:
            if i not in hashtable:
                hashtable[i]=[True,0]
            hashtable[i][1]+=1
        for i in nums2:
            if i in hashtable:
                if hashtable[i][1]>=1:
                    output.append(i)
                    hashtable[i][1]-=1
        return output