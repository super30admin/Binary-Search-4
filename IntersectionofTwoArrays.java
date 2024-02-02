/*
* Approach:
*  1. Store the smaller length array in hashmap with frequencies
* 
*  2. iterate the larger length array and check in hashmap,
        if found, 
            add to result
            decrement the frequency in hashmap
            if freq = 0, remove the element
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m+n)
* 
* Space Complexity: O(min(m,n))
* 
*/

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class IntersectionofTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);

        HashMap<Integer, Integer> hmap = new HashMap<>();

        List<Integer> intersection = new ArrayList<>();

        for (int index = 0; index < nums1.length; index++) {
            hmap.put(nums1[index],
                    hmap.getOrDefault(nums1[index], 0) + 1);
        }

        for (int index = 0; index < nums2.length; index++) {
            if (hmap.containsKey(nums2[index])) {
                intersection.add(nums2[index]);

                hmap.put(nums2[index],
                        hmap.get(nums2[index]) - 1);

                if (hmap.get(nums2[index]) == 0)
                    hmap.remove(nums2[index]);
            }
        }

        int[] result = new int[intersection.size()];

        for (int index = 0; index < intersection.size(); index++) {
            result[index] = intersection.get(index);
        }

        return result;
    }
}
