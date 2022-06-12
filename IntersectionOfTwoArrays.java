

// Time Complexity : O(m + n)
// Space Complexity : O(m + n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.ArrayList;
import java.util.HashMap;
public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int m = nums1.length;
        int n = nums2.length;
        int[] arr;
        if(m > n){
            arr = nums1;
            for(int i = 0; i < n; i++){
                if(map.containsKey(nums2[i])){
                    map.put(nums2[i], map.get(nums2[i]) + 1);
                }else{
                   map.put(nums2[i], 1); 
                }
            }
        }
        else{
            arr = nums2;
            for(int i = 0; i<m ; i++){
                if(map.containsKey(nums1[i])){
                    map.put(nums1[i], map.get(nums1[i]) + 1);
                }else{
                   map.put(nums1[i], 1); 
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i =0 ; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                int count  = map.get(arr[i]);
                count--;
                result.add(arr[i]);
                if(count == 0) map.remove(arr[i]);
                else map.put(arr[i], count);
            }
        }
        int[] res = new int[result.size()];
        for(int i =0; i < res.length; i++){
            res[i] = result.get(i);
        }
        return res;
    }
}







// public int[] intersect(int[] nums1, int[] nums2) {
        
//         if(nums1.length > nums2.length) return intersect(nums2, nums1);
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
//         ArrayList<Integer> result = new ArrayList<>();
//         int pt1 = 0;
//         int pt2 = 0;
//         int m = nums1.length;
//         int n = nums2.length;
//         while(pt1 < m && pt2 < n){
//             if(nums1[pt1] == nums2[pt2]){ 
//                 result.add(nums1[pt1]);
//                 pt1++;
//                 pt2++;
//             }else if(nums1[pt1] > nums2[pt2]) pt2++;
//             else pt1++;
//         }
//         int[] res = new int[result.size()];
//         for(int i =0; i < res.length; i++){
//             res[i] = result.get(i);
//         }
//         return res;
//     }