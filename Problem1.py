# Time Complexity : O(log n)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
# we have to find the h index. So total number of papers - the index shuold be less than or equals to the 
# citations number in the array. If it is equals then we found the exact index so return n - mid else
# keep moving low = mid + 1 or high = mid - 1. In the end if you come out of the loop then, just return the 
# n - low as low will end up with being the minimum in case there is no paper citation that equals, but might be 
# greater. so n - low. 
class Solution:
    # Method 1) Time = O(n) | Space = O(1)
    # def hIndex(self, citations):
    #     if not citations:
    #         return 0 
    #     count = 0
    #     n = len(citations)
    #     for indx in range(len(citations)):
    #         diff = n - indx
    #         if citations[indx] >= diff:
    #             count += 1 
    #     return count 
    
    # Method 2) Time = O(log n) | Space = O(1)
    def hIndex(self, citations):
        if not citations:
            return 0 
        n = len(citations)
        low = 0 
        high = n - 1
        
        while low <= high:
            mid = (low + high) // 2 
            diff = n - mid 
            
            if citations[mid] == diff:
                return n - mid 
            
            elif citations[mid] < diff:
                low = mid + 1 
            
            else:
                high  = mid - 1 
        
        return n - low 

if __name__ == "__main__":
    s = Solution()
    # Test case 1 
    res = s.hIndex([0,1,3,5,6])
    print(res)