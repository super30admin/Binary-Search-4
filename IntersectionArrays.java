/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Idea:
 * 
 * Brute Force is O(m*n), where in for each element we find its corresponding in
 * other array, also marking them so that we count only once.
 * 
 * Other idea is to use a hashmap, compute the frequencies of both arrays and then
 * compute the intersection, which would be the minimum for 2 frequencies for
 * corresponding values. This approach uses extra space.
 * 
 * Space Complexity: O(m+n), HashMap
 * Time Complexity: O(m+n)
 * 
 * 2 pointer approach is to sort the arrays and then progress 2 pointers on each of the arrays.
 * I have implemented the 2 pointer approach.
 * 
 * Space Complexity: O(1)
 * Time Complexity: O(mlogm); where m > n, size of the 2 input lists
 * 
 * Leetcode Results:
 * Runtime: 2 ms, faster than 93.40% of Java online submissions for Intersection of Two Arrays II.
 * Memory Usage: 37.5 MB, less than 61.29% of Java online submissions for Intersection of Two Arrays II.
 * 
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int first = 0, second = 0;
        // sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // result 
        List<Integer> result = new LinkedList<>();
        
        while(first < nums1.length && second < nums2.length) {
            // same values, add to result
            if(nums1[first] == nums2[second]) {
                result.add(nums1[first]);
                first++;
                second++;
            } else if(nums1[first] > nums2[second]) {
                second++;
            } else {
                first++;
            }
        }
        
        int[] intersection = new int[result.size()];
        int i = 0;
        for(int r: result) {
            intersection[i++] = r;
        }
        return intersection;
    }
}