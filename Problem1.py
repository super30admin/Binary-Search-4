#I implemented a method to find the intersection of two lists, nums1 and nums2, where the result is a list of elements that appear in both lists. The approach involves iterating through each element in nums1 and checking if it is present in nums2. If an element is found in nums2, it is added to the result list ans, and that element is then removed from nums2 to handle duplicate occurrences correctly. This ensures that each element in the intersection is added only as many times as it appears in both lists. The time complexity of this solution is O(n * m), where n is the length of nums1 and m is the length of nums2, due to the repeated in checks and remove operations in nums2. The space complexity is O(min(n, m)) for the result list ans, as it holds the intersection elements and the auxiliary space used by the intermediate operations.

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        ans=[]
        for i in nums1:
            if i in nums2:
                ans.append(i)
                nums2.remove(i)
        return ans