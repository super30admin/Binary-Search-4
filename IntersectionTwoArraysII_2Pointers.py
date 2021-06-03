# TC: O(max(M logM, N logN)) where M = length of nums1 and N is lebgth of nums2. MlogM and NlogN because we are sorting the arrays before using the 2 pointer approach. 
# SC: O(1) since we are not using any extra space. 

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if not nums1 or not nums2 or len(nums1) == 0 or len(nums2) == 0: 
            return
        
        self.final = []
        nums1.sort()
        nums2.sort()
        
        first = 0
        second = 0
        
        while first < len(nums1) and second < len(nums2): 
            if nums1[first] == nums2[second]:
                self.final.append(nums1[first])
                first += 1
                second += 1
            
            elif nums1[first] < nums2[second]: 
                first += 1
            
            else: 
                second += 1
        
        return self.final
