#Approach 1: HashMap
#TC: O(n)
#SC: O(min(m,n))

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        
        hashMap = collections.defaultdict()
        
        for num in nums1:
            if num in hashMap.keys():
                hashMap[num] += 1
            else:
                hashMap[num] = 1
        res = []
        for num in nums2:
            if num in hashMap.keys():
                res.append(num)
                f = hashMap[num]
                if f == 1:
                    hashMap.pop(num, None)
                else:
                    hashMap[num] -= 1
        return res

#Approach 2: Two Pointer + Binary search
#TC: O(m+n) if we ignore the time complexity for sorting
#SC: O(1)


class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        result = []
        
        if(len(nums1) > len(nums2)):
            nums1, nums2 = nums2, nums1
            
        #apply binary search with 2 pointers
        p1, p2 = 0, 0
        
        while(p2<len(nums2)):
            if(p1 >= len(nums1)):
                break
            if(nums1[p1] == nums2[p2]):
                result.append(nums1[p1])
                p1 +=1 
                p2 +=1
            elif(nums2[p2] > nums1[p1]):
                p1 +=1 
            elif(nums2[p2] < nums1[p1]):
                p2 += 1
        return result

#Approach 3: Binary Search
#TC: nLogm
#SC: O(1) #if sorting is not considered

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        result = []
        
        #keep larger array in nums2
        if(len(nums1) > len(nums2)):
            nums1, nums2 = nums2, nums1
            
        def binarySearch(l, r, nums2, target):
            while(l<=r):
                mid = (l + r) // 2
                print(l, r, mid)
                if (nums2[mid] == target):
                    if(mid==l or nums2[mid-1]!= target):
                        return mid
                    r = mid - 1
                elif nums2[mid] > target:
                    r = mid -1
                else:
                    l = mid + 1
            return -1
        
        start = 0
        for num in nums1:
            index = binarySearch(start, len(nums2)-1, nums2, num)
            print(index)
            if index != -1:
                result.append(num)
                start = index+1
                
        return result