'''
Accepted on leetcode(275)
Time - O(logn), space O(1)
We have to give output as maximum number of papers with maximum citations which should match and rest of the papers should have less than the maximum citations mentioned above.

'''


class Solution:
    def hIndex(self, citations) -> int:
        # 1. Initialize our variables
        low = 0
        high = len(citations) - 1
        n = len(citations)
        # 2. Do binary search and return if H-index is found
        while low <= high:
            mid = low + (high - low) // 2  # Calculating mid

            diff = n - mid  # difference of number of papers and the mid index
            midVal = citations[mid]  # value of mid

            if midVal == diff:  # if both are equal then we can say that it is maximum and return
                return diff
            elif midVal < diff:  # as the midVal is still less look towards right half
                low = mid + 1
            else:  # as the midVal is greater look towards left half
                high = mid - 1
        # 3. return using our low
        return n - low
