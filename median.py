# Time Complexity :partition= O(logN), Merging O(N)
# Space Complexity :partition= O(1), merging O(N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


# using partitions
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n1=len(nums1)
        n2=len(nums2)
        if(n1>n2):
            return self.findMedianSortedArrays(nums2, nums1)

        l=0
        h=n1

        while(l<=h):
            x_partition=l+(h-l)//2
            y_partition=((n1+n2)//2)-x_partition

            l1= float('-inf') if x_partition==0 else nums1[x_partition-1]
            r2= float('inf') if y_partition==n2 else nums2[y_partition]
            l2= float('-inf') if y_partition==0 else nums2[y_partition-1]
            r1= float('inf') if x_partition==n1 else nums1[x_partition]

            if(l1<=r2 and l2<=r1):
                if((n1+n2)%2):
                    return min(r1,r2)
                else:
                    return (min(r1,r2)+max(l1,l2))/2
            else:
                if(l2>r1):
                    l=x_partition+1
                else:
                    h=x_partition-1
        # return -1
        
# merging 2 sorted arrays then finding median
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        n=len(nums1)
        m=len(nums2)
        i=0
        j=0
        k=0
        l=m+n
        l_=l//2
        com=[0]*(l)
        while(i<n and j<m):
            if(nums1[i]<=nums2[j]):
                com[k]=nums1[i]
                k+=1
                i+=1
            else:
                com[k]=nums2[j]
                j+=1
                k+=1
        while(i<n):
            com[k]=nums1[i]
            i+=1
            k+=1
        while(j<m):
            com[k]=nums2[j]
            j+=1
            k+=1

        if(l%2):
            return (com[(l_)])
        else:
            return(com[l_-1]+com[(l_)])/2