#time complexity: O(log(n))
#space complexity: O(1)
#ran on leetcode: Yes
#Binary search in the first array and set the partion in  the second array. Keep repeating the process until the partions sets splits both the arrays into 2 parts where the elements in the first part are less than elements in the second part.
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if(len(nums1)>len(nums2)):
            temp=nums2
            nums2=nums1
            nums1=temp
        n=len(nums1)
        m=len(nums2)
        low=0
        high=n
        while(low<=high):
            mid=(low+high)//2
            N=mid
            if(mid==0):
                left_border_A=-100000000
            else:
                left_border_A=nums1[mid-1]
            if(mid==len(nums1)):
                right_border_A= 10000000
            else:
                right_border_A=nums1[mid]

            M= (m+n)//2-N
            if(M==0):
                left_border_B=-100000000
            else:
                print(M-1)
                left_border_B=nums2[M-1]
            if(M==len(nums2)):
                right_border_B=100000000
            else:
              right_border_B=nums2[M]

            if(left_border_A>right_border_B):
                high=mid-1
            elif(right_border_A<left_border_B):
                low=mid+1
            else:
                if((n+m)%2==0):
                    return (max(left_border_A,left_border_B)+min(right_border_A,right_border_B))/2
                else:
                    return min(right_border_A,right_border_B)
        return -1.0



