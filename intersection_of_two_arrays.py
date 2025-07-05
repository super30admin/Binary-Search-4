from collections import Counter
# Method 1: Hash Map (Counter-based)
# ----------------------------------
# Approach:
# - Count occurrences of elements in nums1 using Counter (hash map).
# - Iterate through nums2, and if the element exists in the map with count > 0:
#     → Append it to the result and decrement the count
#
# Time Complexity: O(n + m), where n = len(nums1), m = len(nums2)
# Space Complexity: O(min(n, m)) for the hashmap

# Method 2: Two-pointer after sorting
# -----------------------------------
# Approach:
# - Sort both arrays.
# - Use two pointers to iterate both arrays.
# - If values are equal → add to result and move both pointers.
# - Else → move the pointer pointing to the smaller element.
#
# Time Complexity: O(n log n + m log m), for sorting
# Space Complexity: O(1) if sorting in-place


class Solution:
    
    def intersection_linear(self, nums1, nums2):
        if not nums1 and not nums2:
            return []
        res = []
        map_ = Counter(nums1)
        
        for i in nums2:
            if i in map_:
                map_[i] -= 1
                if map_[i] == 0:
                    del map_[i]
                res.append(i)
            else:
                continue
        return result
    
    def intersect_sorting(self, nums1, nums2):
        if not nums1 and not nums2:
            return []
        
        res = []
        
        nums1.sort()
        nums2.sort()
        
        top = 0
        bottom = 0
        while top < len(nums1) and bottom < len(nums2):
            if nums1[top] == nums2[bottom]:
                res.append(nums1[top])
                top += 1
                bottom += 1
            elif nums1[top] < nums2[bottom]:
                top = top + 1
            else:
                bottom = bottom + 1
        return res

def main():
    sol = Solution()

    nums1 = [4, 9, 5]
    nums2 = [9, 4, 9, 8, 4]

    print("Using Counter (Linear):")
    print("Intersection:", sol.intersection_linear(nums1, nums2))  # Expected: [4, 9] or [9, 4]

    print("\nUsing Sorting + Two Pointer:")
    print("Intersection:", sol.intersect_sorting(nums1, nums2))  # Expected: [4, 9] or [9, 4]

    print("\nEdge Case: One array empty")
    print("Intersection:", sol.intersection_linear([], [1, 2, 3]))  # Expected: []
    print("Intersection:", sol.intersect_sorting([1, 2, 3], []))   # Expected: []

    print("\nEdge Case: No intersection")
    print("Intersection:", sol.intersection_linear([1, 2], [3, 4]))  # Expected: []
    print("Intersection:", sol.intersect_sorting([1, 2], [3, 4]))    # Expected: []

if __name__ == "__main__":
    main()