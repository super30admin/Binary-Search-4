class Solution: 
    
    """
    
        Name : Shahreen Shahjahan Psyche
        
        # Assuming that the input is sorted
        Two Pointers:
            Time : O(M+N) [Sizee of Arrays]
            Space: O(1)
            
        # Assuming that the input is sorted
        Binary Search:
            Time : O(MlogN) [M is the Smaller Array Size and N is the bigger Array Size]
            Space: O(1)
            
        Hashmap:
            Time : O(M + N) [M is the Smaller Array Size and N is the bigger Array Size]
            Space: O(M)
        
        
    
    """
    # Sorted : Two- pointers
    def sortedTwo(self, nums1, nums2, res):
        if len(nums1) > len(nums2):
            self.sortedTwo(nums2, nums1, res)
        else:
            nums1.sort()
            nums2.sort()
            first = 0
            last = 0
            
            while(first<len(nums1) and last<len(nums2)):
                if nums1[first] == nums2[last]:
                    res.append(nums1[first])
                    first += 1
                    last += 1
                elif nums1[first] > nums2[last]:
                    last += 1
                else:
                    first += 1
                    
                    
    # Sorted : Binary Search               
    def sortedV(self, nums1, nums2, res):
        if len(nums2) < len(nums1):
            self.unsorted(nums2, nums1, res)
        else:
            nums1.sort()
            nums2.sort()
            low = 0
            high = len(nums2) - 1
            index = 0
            fmid = -1
            while(index < len(nums1)):
                target = nums1[index]
                while(low<=high):
                    mid = low + (high - low)//2
                    if nums2[mid] == target:
                        if mid == low or nums2[mid-1] < nums2[mid]:
                            res.append(target)
                            fmid = mid + 1
                            break
                        else:
                            high = mid - 1
                    elif target > nums2[mid]:
                        low = mid + 1
                    else:
                        high = mid - 1
                high = len(nums2) - 1
                if fmid != -1:
                    low = fmid
                    fmid = -1
                index += 1
            
            return res
            
    # Unsorted : Hashmap    
    def unsorted(self, nums1, nums2, res):
        if len(nums2) > len(nums1):
            self.unsorted(nums2, nums1, res)
        else:
            records = {}
            for i in nums1:
                if i not in records.keys():
                    records[i] = 1
                else:
                    records[i] += 1
            
            for j in nums2:
                if j in records.keys() and records[j] != 0:
                    res.append(j)
                    records[j] -= 1
            return res
        
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        if not nums1 or not nums2:
            return []
        
        res = []
        # self.unsorted(nums1, nums2, res)
        # self.sortedV(nums1, nums2, res)
        self.sortedTwo(nums1, nums2, res)
        return res
        
        
