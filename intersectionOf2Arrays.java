// Time complexity = O(m+n)
// Space complexity = O(m), where m is the length of smaller array, used in hashMap and result ArrayList
// Use hashMap, keep <nums1 elements, count> and traverse nums2 to find if map contains key and count >0, and add to result.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[]{};

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();       //since we dont know the number of elements in the result
        int count=0;

        if(nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }

        //nums1 is always smaller so we add it to map, to minimize extra space requirement
        for (int i=0; i<nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i=0; i<nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i])>0) {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }

        int[] out = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            out[i] = result.get(i);
        }

        return out;
    }
}

// Follow-up if the given arrays are sorted
// Time complexity = O(m+n)
// Space complexity = O(k), where k is size of result ArrayList
// Follow-up: If the 2 arrays are sorted we will use a 2 pointer approach where 1st pointer will be at the start of first array, and second pointer will be at the start of second array
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[]{};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0;
        List<Integer> result = new ArrayList<>();       //since we dont know the number of elements in the result

        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }

        int[] out = new int[result.size()];
        for (int idx=0; idx<result.size(); idx++) {
            out[idx] = result.get(idx);
        }

        return out;
    }
}