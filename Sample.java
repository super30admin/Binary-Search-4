## Problem1 
Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

// Time Complexity - 0(m + n)
// Space Complexity - 0(m + n)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Hashmap to store frequency of elements in nums1
        Map<Integer, Integer> freqMap = new HashMap<>();

        // populate the map
        for (int num : nums1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }  
        List<Integer> intersection = new ArrayList<>();
        
        // common elements and maintain the count
        for (int num : nums2) {
            if (freqMap.containsKey(num) && freqMap.get(num) > 0) {
                intersection.add(num);
                freqMap.put(num, freqMap.get(num) - 1);
            }
        }
        // Convert ArrayList to Array
        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }
        return result;
    }
}


## Problem2
Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

// Time Complexity - 0(log m)
// Space Complexity - 0(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return -1.0;
        }
        int m = nums1.length;
        int n = nums2.length;

        if(m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = m;

        while(low <= high) {
            int partX = low + (high - low) / 2;   // prevent integer overflow
            int partY = (m + n) / 2 - partX;

            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double r1 = partX == m ? Integer.MAX_VALUE : nums1[partX];
            double r2 = partY == n ? Integer.MAX_VALUE : nums2[partY];

            if(l1 <= r2 && l2 <= r1) {
                if((m + n) % 2 == 0) {
                    return(Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }
                return Math.min(r1, r2);
            }
            if(l1 > r2) {
                high = partX - 1;
            }
            else {
                low = partX + 1;
            }
        }
        return 2.0;       
    }
}