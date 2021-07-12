package BinarySearch4;

import java.util.ArrayList;
import java.util.HashMap;

public class question91_InteresectionOfTwoArrays2 {
    /* Created by palak on 7/9/2021 */

    /*
        Time Complexity: O(n) //length of smaller array
        Space Complexity: O(n) // HashMap
    */
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return intersect(nums2, nums1);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num1: nums1) {
            map.put(num1, map.getOrDefault(num1, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num2: nums2) {
            if(map.containsKey(num2)) {
                list.add(num2);
                map.put(num2, map.get(num2) - 1);
                map.remove(num2, 0);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}