/*
Problem: https://leetcode.com/problems/intersection-of-two-arrays-ii/
*/


// Approach 1: HashMap
// TC: O(m + n)
// SC: O(min(m, n))
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        // To make sure nums1 is the smaller array of the two
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        
        HashMap<Integer, Integer> numFreq = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        // Put the smaller array into the map
        for (int num : nums1) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (numFreq.containsKey(num)) {
                result.add(num);
                int f = numFreq.get(num);
                if (f - 1 == 0) {
                    numFreq.remove(num);
                } else {
                    numFreq.put(num, f - 1);
                }
            }
        }
        
        int res[] = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            res[i] = result.get(i);
        }
        
        return res;
    }
}

// Follow up: If array was sorted, how would you optimize your solution?

// Approach 2: 2 pointers if the array was already sorted.
// TC: O(max(m, n))
// SC: O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = 0, n2 = 0;
        List<Integer> result = new ArrayList<>();
        
        while (n1 < nums1.length && n2 < nums2.length) {
            if (nums1[n1] == nums2[n2]) {
                result.add(nums1[n1]);
                ++n1; ++n2;
            } else if (nums1[n1] < nums2[n2]) {
                ++n1;
            } else {
                ++n2;
            }
        }
        
        int res[] = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            res[i] = result.get(i);
        }
        
        return res;
    }
}


// Approach 3: Binary search.
// Here, we would perform binary search on the larger array for efficiency. When looking for an element of the smaller array in the larger array, we would want to find the left most 
// occurrence of the element in the larger array
// TC: O(m log n) where n > m
// SC: O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int low = 0, high = nums2.length - 1;
        
        for (int i = 0; i < nums1.length; ++i) {
            int index = binarySearch(nums2, low, high, nums1[i]);
            if (index != -1) {
                low = index + 1;
                result.add(nums1[i]);
            }
        }
        
        int res[] = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            res[i] = result.get(i);
        }
        
        return res;
    }
    
    private int binarySearch(int nums2[], int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // System.out.println("Low: " + low + ", high: " + high + ", mid: " + mid + ", nums2[mid]: " + nums2[mid]);
            if (nums2[mid] == target) {
                if (mid == low || nums2[mid-1] < nums2[mid]) {
                    return mid;
                }
                // We want to find the left most occurrence of that element in the array
                high = mid - 1;
            } else if (target <= nums2[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}