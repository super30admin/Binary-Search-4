import java.util.Arrays;
import java.util.HashMap;

/*
Time Complexity: O(n+m) n is the length of nums1, and m is the length of nums2 array
Space Complexity: O(min(n,m)), To store elements in the HashMap
Run on leetcode: yes
Any difficulties: no

Approach:
1. Well Commented code
 */
public class IntersectionOfTwoArraysII {

    public static int[] intersectionOfTwoArraysII(int[] nums1, int[] nums2){
        if(nums1.length > nums2.length){
            return intersectionOfTwoArraysII(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // Keep adding elements of array whose length is less to HashMap as the key, and their frequencies as value
        for(int num: nums1){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        // Now I will iterate over the second array and if that element is already present in the HashMap then
        // I would take count of that and if that is greater than 0 then I will update the count decrementing by one
        int k = 0;

        for(int num: nums2){
                int count = map.getOrDefault(num,0);
                if(count>0){
                    nums1[k++] = num;
                    map.put(num, count-1);
                }
        }

        // returning array from 0 to k the index
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args){
        int[] a = {1,2,2,1};
        int[] b = {2,2};

        System.out.println("Intersection of the arrays: "+ Arrays.toString(intersectionOfTwoArraysII(a,b)));
    }
}
