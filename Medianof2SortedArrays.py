class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        # Time Complexity: O(log(n))
        # Binary Search solution
        # We will create 2 partitions combining nums1 and nums2 such that number of elements in nums1 is equal to number of elements in nums2
        
        
        # By partitioning, what we want is everything on the left hand side is lesser than everything on right        hand side. nums1 has 6 partitions: 0, 1, 2, 3, 4, 5. Therefore we take end as len(nums1)
        # that means, eg:   
        # nums1 =   1 5         9 10 15 
        # nums2 =. 2 11 12      13 14 16
        # we want  5 must be less than 9 and 12 less than 13 (will always be as array is sorted)
        # so we need to compare 5 and 13, 12 and 9.
        # We see 12 is greater than 9, so we will be moving our partition_x towards right, so part_y will come towards left
        # l1<=r2 and l2<=r1, we will perform binary search till we get to this condition
        
        if(len(nums1)>len(nums2)):
            nums1,nums2 = nums2,nums1
        beg = 0
        end = len(nums1)
        while(beg<=end):
            mid = (beg+end)//2
            part_x = mid
            part_y = (len(nums1)+len(nums2))//2 - part_x
            if(part_x==0):
                l1 = -1*float("inf")
            else:
                l1 = nums1[part_x-1]
            if(part_y==0):
                l2 = -1*float("inf")
            else:
                l2 = nums2[part_y-1]
            if(part_x==len(nums1)):
                r1 = float("inf")
            else:
                r1 = nums1[part_x]
            if(part_y==len(nums2)):
                r2 = float("inf")
            else:
                r2 = nums2[part_y]
            
            if(l1<=r2 and l2<=r1):
                if(len(nums1)+len(nums2))%2==0:
                    return (max(l1,l2)+min(r1,r2))/2
                else:
                    return min(r1,r2)
            elif(l2>r1):
                beg = mid + 1
            else:
                end = mid - 1
            
