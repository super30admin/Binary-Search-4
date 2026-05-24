# Using counter
# time: O(n+m) counter for A, iterate through B
# space: O(min(n,m))
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        if len(nums1) < len(nums2):
            numsA=nums1
            numsB=nums2
        else:
            numsA=nums2
            numsB=nums1

        res=[]
        c = Counter(numsA)
        for x in numsB:
            if x in c and c[x]>0:
                res.append(x)
                c[x]-=1
        
        return res
            

# Using binary search
# time: O(nlogn)+O(mlogm)
# space: O(1)
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        n1 = len(nums1)
        n2 = len(nums2)

        # Ensure nums1 is always the smaller array
        if n2 < n1:
            return self.intersect(nums2, nums1)
        
        # Sort both arrays as required for binary search
        # O(nlogn)
        nums1 = sorted(nums1)
        nums2 = sorted(nums2)
        
        li = []
        low = 0  # Initialize the dynamic lower bound for the binary search
        
        for i in range(len(nums1)):
            high = len(nums2) - 1  # Reset high to the end of the array each time
            
            # binary search: O(logn)
            bsIdx = self.binarySearch(nums2, low, high, nums1[i])
            
            if bsIdx != -1:
                li.append(nums1[i])
                # Shift our lower bound to the index right after the match 
                # so we don't accidentally match the same element twice
                low = bsIdx + 1
        
        return li  # In Python, we can just return the list directly

    def binarySearch(self, arr: List[int], low: int, high: int, target: int) -> int:
        first_match_idx = -1
        
        while low <= high:
            # Fixed: Added integer division '//' and parentheses to avoid floats
            mid = low + (high - low) // 2
            
            if arr[mid] == target:
                # We found the target, but since there could be duplicates,
                # we want to look as far left as possible *within our current low boundary*
                first_match_idx = mid
                high = mid - 1  # Keep looking left
            elif arr[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
                
        return first_match_idx



# [2,2]
# [1,1,2,2]
#      l h


