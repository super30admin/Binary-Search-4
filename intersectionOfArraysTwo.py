"""
Using a hash map, count frequency of elements in nums1
Iterate through nums2; if an element is in the map and count > 0, add to result
Reduce count in map
"""
"""
Time Complexity: O(n + m) —  n = len(nums1), m = len(nums2)
Space Complexity: O(n) — for hashmap storage
"""



from collections import Counter

class intersectionOfArraysTwo:
    def intersect(self, nums1: list[int], nums2: list[int]) -> list[int]:
        count = Counter(nums1)
        result = []

        for num in nums2:
            if count[num] > 0:
                result.append(num)
                count[num] -= 1
        
        return result

if __name__ == "__main__":
    obj = intersectionOfArraysTwo()
    
    nums1 = [1, 2, 2, 1]
    nums2 = [2, 2]
    print(obj.intersect(nums1, nums2))  

    nums1 = [4, 9, 5]
    nums2 = [9, 4, 9, 8, 4]
    print(obj.intersect(nums1, nums2))  
