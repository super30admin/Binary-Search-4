# Binary-Search-4


## Problem 1 
Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

Approached Solution: In this solution, we will create a frequency map which is hashmap to store the frequency of each element from nums1. Then for each element in nums1, we will iterate over the array and will update its frequency in the map. Then will iterate through nums2 and if an element is found in the map, we will add it to the result list and decrease its frequency in the map. Then we will convert the result list to an array and will return it.

Time Complexity: O(n1+n2) as we are iterating over both nums1 and nums2 which takes linear tim in relation to their sizes whene n1 is the length of nums1 and n2 is the length of nums2.

Space Complexity: The space complexity is primarily due to the storage of the HashMap which can hold up to n1 unique elements from nums1. The list for storing the intersection can also grow up to the size of nums2 in the worst case.

Approached Code:

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n1; i++) {
            if(!map.containsKey(nums1[i])) {
                map.put(nums1[i], 0);
            }

            map.put(nums1[i], map.get(nums1[i]) + 1);
        }

        List<Integer> intersection = new ArrayList<>();

        for(int i = 0; i < n2; i++) {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) != 0) {
                intersection.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] result = new int[intersection.size()];

        for(int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;

    }
}



## Problem 2
Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

Approached Solution: In this approach first, we will ensure that nums1 is the smaller array, using binary search on it to minimize the number of elements to check. Then in the binary search we will split nums1 into two parts (partX) and then will calculate the corresponding partition for nums2 (partY) which will ensure the left side of both partitions contains half of the total elements. For each partition, we will check if the maximum element on the left side of both partitions is less than or equal to the minimum element on the right side. If so, then partition is correct. If the total length is even, the median is the average of the maximum of the left elements and the minimum of the right elements. If odd, it's the minimum of the right elements. If the partition is incorrect, we will adjust the binary search bounds based on whether the left element in nums1 is greater than the right element in nums2 or vice versa.

Time Complexity: O(log(min(n1, n2))) as the binary search is performed on the smaller array making the time complexity logarithmic with respect to the size of the smaller array.

Space Complexity: O(1) is the space complexity as the algorithm only uses a few extra variables for partitions and comparisons and no additional data structures are used.

Approached Code:

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        int low = 0;
        int high = n1;

        while(low <= high) {

            int partX = low + (high - low)/2;
            int partY = (n1+n2)/2 - partX;

            int L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];

            int R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            int R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if(L1 <= R2 && L2 <= R1) {

                if((n1+n2)%2 == 0) {
                    return (Math.min(R1, R2) + Math.max(L1, L2))/2.0;
                } else {
                    return Math.min(R1, R2);
                }

            } else if(L1 > R2) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }
        }

        return 0.0;

    }
}



## Problem 3
Research's H-Index 2 (https://leetcode.com/problems/h-index-ii/description/)

Approached Solution: In this solution we will use binary search to efficiently find the H-index. The H-index is the largest number h such that the researcher has at least h papers with h or more citations. The binary search will operate on the sorted citations array where we will calculate the difference diff = n - mid where n is the total number of papers. If the citation at the current position citations[mid] is greater than or equal to diff, then the H-index candidate is valid, and we will adjust the search range accordingly. If the citation count at the mid position is smaller, we will shift the search to the right half. This process will continue until the correct H-index is found.

Time Complexity: O(log n) as binary search narrows down the possible H-index in logarithmic time where n is the number of papers.

Space Complexity: O(1) as algorithm uses only a few variables for the binary search and comparison so the space complexity is constant.

Approached Code:

class Solution {
    public int hIndex(int[] citations) {

        if(citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;

        // for(int i = 0; i < n; i++) {
        //     int diff = n - i;

        //     if(diff <= citations[i]) {
        //         return diff;
        //     }
        // }

        int low = 0;
        int high = n - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            int diff = n - mid;

            if(citations[mid] == diff) {
                return diff;
            } else if(citations[mid] > diff) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // return 0;
        return n - low;
    }
}


