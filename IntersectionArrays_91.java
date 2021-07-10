// Time Complexity : O(log(m + n)), where m & n are the size of two arrays
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package binarySearch4;

import java.util.*;

public class IntersectionArrays_91 {

    public int[] intersect(int[] nums1, int[] nums2) {
        //two pointer solution
        int n1 = nums1.length;
        int n2 = nums2.length;
        //if nums1 length is > nums2 then swap nums1 and nums2 
        //to always have the nums1 smaller length
        if (n1 > n2) {
            return intersect(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0;
        List<Integer> res = new ArrayList<>();
        while (p1 < n1 && p2 < n2) {
            if (nums1[p1] == nums2[p2]) {
                res.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    /**
     * HashMap solution with Time Complexity: O(m + n) Space complexity: O(n),
     * where n is size of smallest array, not including space of list as
     * consdiering it as return type public int[] intersect(int[] nums1, int[]
     * nums2) { int n1 = nums1.length; int n2 = nums2.length; //if nums1 length
     * is > nums2 then swap nums1 and nums2 //to always have the nums1 smaller
     * length if(n1 > n2) return intersect(nums2, nums1);
     * HashMap<Integer, Integer> map = new HashMap<>(); List<Integer> res =new
     * ArrayList<>(); for(int num : nums1){ map.put(num, map.getOrDefault(num,
     * 0) + 1);
     *
     * }
     * for(int num : nums2){ if(map.containsKey(num)){ res.add(num);
     * map.put(num, map.get(num) - 1); map.remove(num, 0); }
     *
     * }
     * return res.stream().mapToInt(Integer::intValue).toArray(); }
     */
}
