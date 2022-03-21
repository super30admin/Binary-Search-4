// Time Complexity:    O( min(m,n) * log(max(m,n)) )
// Space Complexity:   O( m + n )
// where m and n are number of elements in arrays
// This code ran successfully on Leetcode


import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        // SORTING ARRAYS
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        int start = 0;

        for(int num : nums1) {
            int index = binarySearch(nums2, start, nums2.length-1, num);        // recursive calls
            if(index != -1) {                                                 // element is found
                result.add(num);                                              // add it to result
                start = index+1;                                              // change scope
            }
        }


        int[] resultArr = new int[result.size()];

        for(int i=0; i<result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }

    private int binarySearch(int[] arr, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end-start)/2;

            if(arr[mid] == target) {                                          // target found
                if(mid == start || arr[mid-1] != target) {                    // first occurance
                    return mid;                                               // return index
                }
                end = mid-1;
            }
            else if(arr[mid] < target) {                                      // target is greater than mid element
                start = mid+1;
            }
            else {                                                            // target is less than mid element
                end = mid-1;
            }
        }
        return -1;                                                           // target not found
    }
}



//// Time Complexity:    O( m + n )
//// Space Complexity:   O( m + n )
//// ****************************** Map approach ******************************
//public class IntersectionOfTwoArrays {
//    public int[] intersection(int[] nums1, int[] nums2) {
//
//        if(nums1.length > nums2.length) {
//            return intersection(nums2, nums1);
//        }
//
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for(int num : nums1) {
//            map.put(num, map.getOrDefault(num, 0)+1);                 // creating frequency map
//        }
//
//        List<Integer> result = new ArrayList<>();
//
//        for(int num : nums2) {
//            if(map.containsKey(num)) {
//                int freq = map.get(num);
//                result.add(num);
//                freq--;
//                if(freq == 0) {                                       // if all occurances of "num" has been traversed from frist array
//                    map.remove(num);                                  // remove it from map
//                }
//                else {                                                // else
//                    map.put(num, freq);                               // updating frequency of "num"
//                }
//            }
//        }
//        int[] resultArr = new int[result.size()];
//
//        for(int i=0; i<result.size(); i++) {
//            resultArr[i] = result.get(i);
//        }
//        return resultArr;
//    }
//}
