class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        """Time complexity-O(m+nlog(m+n))
        Space complexity-O(n)"""
        # for i in range(len(nums2)):
        #     nums1.append(nums2[i])
        # print(nums1)
        # nums1.sort()
        # if len(nums1)%2==0:
        #     return (nums1[int(len(nums1)/2)-1]+nums1[int(len(nums1)/2)])/2
        # else:
        #     return nums1[int(len(nums1)/2)]
        """2 pointer solution
        Time complexity-O(m+n)
        Space complexity-O(m+n)"""
        # p1=0
        # p2=0
        # result=[]
        # while p1<len(nums1) and p2<len(nums2):
        #     if nums1[p1]<nums2[p2]:
        #         result.append(nums1[p1])
        #         p1+=1
        #     elif nums1[p1]>nums2[p2]:
        #         result.append(nums2[p2])
        #         p2+=1
        #     elif nums1[p1]==nums2[p2]:
        #         result.append(nums1[p1])
        #         result.append(nums2[p2])
        #         p1+=1
        #         p2+=1
        # while p1<len(nums1):
        #     result.append(nums1[p1])
        #     p1+=1
        # while p2<len(nums2):
        #     result.append(nums2[p2])
        #     p2+=1
        # if len(result)%2==0:
        #     return (result[int(len(result)/2)-1]+result[int(len(result)/2)])/2
        # else:
        #     return result[int(len(result)/2)]
        
                
        """Modified Binary Search by partitioning
        Time complexity-O(log(n)) where n is the length of the smaller array
        Space complexity-O(1)"""
        n1=len(nums1)
        n2=len(nums2)
        if n1>n2:
            return self.findMedianSortedArrays(nums2, nums1)
#         take start and end indexes based on partitions
        start=0
        end=n1
        while start<=end:
            mid=start+(end-start)//2
            partx=mid
#           let first array be partitioned at mid, then second array partitioning would be as given below
            party=(int((n1+n2)/2))-partx
#           l1, r1 of smaller array and l2, r2 of bigger array
            if partx==0:
                l1=-999999999
            else:
                l1=nums1[partx-1]
            if n1==partx:
                r1=9999999999
            else:
                r1=nums1[partx]
                
                
            if party==0:
                l2=-999999999
            else:
                l2=nums2[party-1]
            if n2==party:
                r2=9999999999
            else:
                r2=nums2[party]
                
            if l1<=r2 and l2<=r1:
                if (n1+n2)%2==0:
                    return (max(l1,l2)+min(r1,r2))/2
                else:
                    return (min(r1, r2))
#             decrease mid pointer as l1 has larger value than r2
            elif l1>r2:
                end=mid-1
#             increase start pointer as l2 is larger than r1
            else:
                start=mid+1
        return 0
            
            
            
                
                
        
        