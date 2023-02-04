class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        list1,list2=[],[]
        i,j=0,0
        if len(nums1)==0 and len(nums2)==0:
            return 0.0
        while i<len(nums1) or j<len(nums2):
            if i<len(nums1) and j<len(nums2):
                if nums1[i]<nums2[j]:
                    list1.append(nums1[i])
                    i+=1
                else:
                    list1.append(nums2[j])
                    j+=1
            else:
                if i>=len(nums1):
                    list2.append(nums2[j:])
                    break
                if j>=len(nums2):
                    list2.append(nums1[i:])
                    break
        for i in list2:
            for k in i:
                list1.append(k)
        print(list1)
        l=len(list1)
        if l%2==0:
            med=float( (list1[int(l/2)-1]+list1[int(l/2)]))
            med=float(med/2)
            print(med)
            return med
        else:
            med=list1[int(l/2)]
            return med

            
            