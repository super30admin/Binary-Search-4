class Solution(object):
    # tc : O(log(min(m,n))) as we are dng parttions-> binary search on the smaller arr only,, sc : O(1)
    def findMedianSortedArrays(self, nums1, nums2):
        # brute force : add elements into a new array while adding add in a sorted manner by checking the values, and return the median based on the size if odd midd element if even average of 2 middle elements

        # optimal approach : median means we should have same number of elemenst left and right [ odd case] in even case same numbr of elemnst left and rigth the middle two elements average
        # first we need to make partitions on the indexes of arrays such that both the arrary are divided in suhc a way that number of elements of L1 + number of elemenst of L2 = number of elements or R1, number of elements in R2
        # when total number of elemenst are even we will have same number of elemnst in left and rigth , in odd case we will have 1 extra on the right side 

        # 1- lest say we are dividing our nums1 with a partX, we will be using binary search to find the partX, starting low form sart and high from end of the arrx, then we should divide our partY = (n1+n2)//2 - partX 
        # L1 = 0-partX numbers, L2 = 0-partY numbers, R1 = partX+1 to end of nums1, R2 = partY+1 to end of nums2
        # now we have made a partitions but to make sure that we are at rigth parition, these L numbers should be less than the R numbers 
        # i.e we are in a sorted partition then  based on odd and even we can find the median

        # 2- to check if sorted we can simply check if the last element in L1 < R2 or not and also L2 < R1 then they are sorted, since our L1 and R1 will obv be sorted as our arrs are sorted arr we dont need to check those things just chekc with the other arr 

        # 3- if its not sorted and we have like L1 > R2 means its not a correct parttion and L1 element is larger then we have to do our partx in left of arr such that our left elemenst will be smaller than R , so in the binary search we reduce our search to left of the arr by moving our high = partX 
        # in opther case we move our low = partX +1

        n1 = len(nums1)
        n2 = len(nums2)
        low = 0
        high = n1

        if n1>n2:
            return self.findMedianSortedArrays(nums2,nums1) # always having my smaller arr in the begining

        while low <= high:
            partX  = low + (high-low)/2
            partY = (n1+n2)//2 - partX

            # boundary cases take the extreme values 
            L1 = float('-inf') if partX == 0 else nums1[partX - 1] 
            R1 = float('inf') if partX == n1 else nums1[partX]
            L2 = float('-inf') if partY == 0 else nums2[partY - 1]
            R2 = float('inf') if partY == n2 else nums2[partY]

            if L1<= R2 and L2 <=R1:
                if (n1+n2)%2 == 0: # in case its even we find the middle two elemnst i.e the max element in the left arra, min element in the right 
                    return (max(L1,L2)+ min(R1,R2))/2.0
                else :
                    return min(R1,R2) # in odd case our median is in the right 

            elif L1 > R2:
                high = partX
            else :
                low = partX + 1

        return -1

        

