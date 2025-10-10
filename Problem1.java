// Time Complexity : O(m+n) + O(k) where m,n are lengths of array and k is the number of matches
// Space Complexity : O(min(m,n) + k) since we are storing the result in list
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Storing the frequency of the numbers on smaller array in hashmap. Finding the match from the other via hashmap lookup.
 */
class NonSortedSolution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                res.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}

// Time Complexity : O(m+n) + O(k) where m,n are lengths of array and k is the number of matches
// Space Complexity : O(k) since we are storing the result in list
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using two pointers for sorted arrays to find a match.
 */
class SortedSolution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {
            return intersect(nums2, nums1);
        }

        // sorting both arrays for follow up
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;

        List<Integer> res = new ArrayList<>();

        while (p1 < n1 && p2 < n2) {
            //match found, move both pointers
            if (nums1[p1] == nums2[p2]) {
                res.add(nums1[p1]);
                p1++;
                p2++;

            }
            // num1 is bigger so move the p2 pointer to find bigger match
            else if (nums1[p1] > nums2[p2]) {
                p2++;
            }
            // num2 is bigger so move the p1 pointer to find bigger match
            else {

                p1++;
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}