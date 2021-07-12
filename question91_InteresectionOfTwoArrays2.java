package BinarySearch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class question91_InteresectionOfTwoArrays2 {
    /* Created by palak on 7/9/2021 */

    /*
        Time Complexity: O(n) //length of smaller array
        Space Complexity: O(n) // HashMap
    */
    public static int[] intersect(int[] nums1, int[] nums2) {
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


    /*
    Example: n1 = 4,5,9,9
            n2 = 4,4,8,9,9
                To Find: 4
                low = 0(4); high = 4(9); mid = 2(8)
                low = 0(4); high = 1(4); mid = 0(4)
                bstIndex = 0; Found first 4
                To Find: 5 (4,8,9,9)
                low = 1(4); high = 4(9); mid = 2(8)
                low = 1(4); high = 1(4); mid = 0(4)
                bstIndex = -1; Not Found 5
                To Find: 9 (4,8,9,9)
                low = 1(4); high = 4(9); mid = 2(8)
                low = 3(9); high = 4(9); mid = 3(9)
                bstIndex = 3; Found First 9

    Binary Search Solution
        Time Complexity: O(m log m) ; m:length of smaller array
        Space Complexity: O(m)
    */
    public static int[] intersect1(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return intersect1(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int low = 0;
        int high = n2 - 1;

        for(int i = 0 ; i < n1 ; i++) {
            //Modified Binary Search
            int bstIndex = binarySearch(nums2, low, high, nums1[i]);
            if(bstIndex != -1) {
                list.add(nums1[i]);
                low = bstIndex + 1;
            }
        }

        int result[] = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    private static int binarySearch(int[] nums2, int low, int high, int target) {
        int first_pos = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums2[mid] == target) {
                first_pos = mid;
                high = mid-1;
            } else if (nums2[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return first_pos;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};


        int[] result = intersect(nums1, nums2);
        System.out.println("Result 1: ");
        for(int i = 0 ; i < result.length ; i++) {
            System.out.println(result[i]);
        }
        int[] result1 = intersect1(nums1, nums2);
        System.out.println("Result 2: ");
        for(int i = 0 ; i < result1.length ; i++) {
            System.out.println(result1[i]);
        }
    }
}