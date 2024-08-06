import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays2 {
    public static int[] intersectUnsorted(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersectUnsorted(nums2, nums1); //always make nums1 length smaller

        HashMap<Integer, Integer> map = new HashMap<>(); //O(min(m,n)) S.C
        for (int key : nums1) { //add elements from smaller length array into the map
            map.put(key, map.getOrDefault(key, 0) + 1); //frequency map
        }

        List<Integer> res = new ArrayList<>();
        for (int key : nums2) { //iterating over the other array, O(max(m,n)) T.C
            if (map.containsKey(key)) { //if element from array 2 is also in array 1
                res.add(key); //add it to result
                map.put(key, map.get(key) - 1); //decrement the frequency of this key in map
                map.remove(key, 0); //if its frequency reaches 0, remove it completely from the map
            }
        }

        int[] result = new int[res.size()]; //O(k) T.C where k is result size
        for(int k=0; k<res.size(); k++) { //sliding window to convert List to int[]
            result[k] = res.get(k);
        }

        return result;
    }

    public static int[] intersectSortedPointers(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersectSortedPointers(nums2, nums1);

        //follow-up question what if arrays are given sorted?
        Arrays.sort(nums1); //do not consider its T.C as this was follow up question
        Arrays.sort(nums2);

        int p1 = 0; //pointer 1 on nums1
        int p2 = 0; //pointer 2 on nums2

        List<Integer> res = new ArrayList<>();
        while(p1 < nums1.length && p2 < nums2.length) { //O(m+n) T.C, O(1) S.C
            if(nums1[p1] == nums2[p2]) { //if values at both pointers are equal
                res.add(nums1[p1]); //add it to list
                p1++; //and increment both
                p2++;
            } else if(nums1[p1] < nums2[p2]) p1++; //else if value at p1 is lesser, increment p1
            else p2++; //else increment p2
        }

        int[] result = new int[res.size()];
        for(int k=0; k<res.size(); k++) { //sliding window
            result[k] = res.get(k);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {0,2,7,7,6,3};
        int[] nums2 = {7,4,0,6};

        System.out.println("The intersection of arrays " + Arrays.toString(nums1) + " and " +
                Arrays.toString(nums2) + " using hashmap is: " + Arrays.toString(intersectUnsorted(nums1, nums2)));

        int[] nums3 = {1,2,2,3,3,3};
        int[] nums4 = {0,1,1,2,2,2,3};

        System.out.println("The intersection of arrays " + Arrays.toString(nums3) + " and " + Arrays.toString(nums4) +
                " using pointers is: " + Arrays.toString(intersectSortedPointers(nums3, nums4)));

    }
}