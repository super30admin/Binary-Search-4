package com.ds.rani.bs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 * <p>
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class ArrayIntersection {

    //Approach:store elements of array1 into hashmap along with its frequency.
    //traverse over array 2, and check if that elemnt present in map, if it is present, add that in result and decrement the
    //frequency for that element in map. If the frequency of that element becomes 0, remove it from the map

    //Time Complexity:o(m+n) where m is size of nums1 and n is size of nums2
    //Space Complexity:o(m)
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        //add all the numbers along with its frequencies in map
        for (int num : nums1) {
            map.put( num, map.getOrDefault( num, 0 ) + 1 );
        }

        //now traverse over nums2
        for (int num : nums2) {
            if (map.containsKey( num )) {
                result.add( num );
                map.put( num, map.get( num ) - 1 );
                //when frequency becomes o for that number remove it
                map.remove( num, 0 );
            }
        }
        int[] resultArr = new int[result.size()];
        int idx = 0;
        for (int num : result) {
            resultArr[idx++] = num;
        }
        return resultArr;
    }
}
