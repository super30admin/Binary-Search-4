# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


# // Your code here along with comments explaining your approach


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # Output that we want to return
            output = []
            
            # To keep the count of each element in nums2
            count = Counter(nums2)
            
            # Now for each element in first array
            for num in nums1:
                # If count of that element is > 0 we can include it
                if num in count and count[num] > 0:
                    output.append(num)
                    # Reduce its count by 1 as we included this element once in the output
                    count[num] -= 1
     
            return output