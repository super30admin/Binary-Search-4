"""
Approach: Binary Search

Lets understand using an example
nums1 = [1,5,9,10,11]
nums2 = [2,11,12,13,14,16]

Now lets create partitions here

         0   1   2   3    4    5
nums1 => | 1 | 5 | 9 | 10 | 11 |

         0   1    2    3    4    5    6
nums2 => | 2 | 11 | 12 | 13 | 14 | 16 |


We will maintain a low and high pointer on nums1, intially pointing to first and last element respectively. We will now get index of middle element from nums1 between low and high
We will get another middle element from nums2 using (n1 + n2) / 2 - (index of middle element from nums1)

Now we will partition accordingly
mid of nums1 = 2
mid of nums2 = 3

          L       |       R
nums1    1, 5     |   9,10,11
nums2   2,11,12   |   13,14,15
  
Now lets call 5 as l1, 12 as l2, 9 as r1 and 13 as r2

Now we will check for the following conditions
1) l1 <= r2 and l2 <= r1
    - Total number of elements are even then answer is (max(l1,l2) + min(r1,r2)) / 2
    - Total number of elements are odd then answer is min(r1,r2)
    
2) l1 > r2: We need to find a smaller number in nums1
    - high = mid of nums1 - 1
    
3) l2 > r1: We need to find a larger number in nums1
    - low = mid of nums1 + 1
    
In above example condition 3 is fulfilled that means our new values are
low = 3 and high = 5
mid of nums1 = 4
mid of nums2 = 1

          L              |       R
nums1    1, 5, 9, 10     |   11
nums2         2          |   11,12,13,14,15

Now the condition 1 is satisfied  total elements are odd. Means our answer is 11


TC: O(log(n))
SC: O(1)

where n = size of nums1
"""

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if nums1 == None and nums2 == None:
            return 0
        
        n1 = len(nums1)
        n2 = len(nums2)
        
        # To make sure nums1 is the smaller array
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        
        low = 0
        high = n1
        
        while low <= high:
            partX = low + (high - low) // 2
            partY = (n1 + n2) // 2 - partX
            
            l1 = float('-inf') if partX - 1 < 0 else nums1[partX - 1]
            l2 = float('-inf') if partY - 1 < 0 else nums2[partY - 1]
            r1 = float('inf') if partX == n1 else nums1[partX]
            r2 = float('inf') if partY == n2 else nums2[partY]
            
            if l1 <= r2 and l2 <= r1:
                # even
                if (n1+n2) % 2 == 0:
                    return (max(l1,l2) + min(r1,r2)) / 2
                
                # odd
                else:
                    return min(r1,r2) 
            
            elif l1 > r2:
                high = partX - 1
            else:
                low = partX + 1
                