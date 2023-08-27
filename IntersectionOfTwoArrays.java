import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class IntersectionOfTwoArrays {

    //Binary Search solution
    //Time Complexity : O(m*log(n))) where m is length of the nums1 array(smaller length) and n is the length of the nums2 array
    //not counting O(n*log(n)) + O(m * log(m)) taken for sorting the two arrays
    // Space Complexity : O(1) as no auxiliary space has been used
    // Did this code successfully run on Leetcode :yes
    public int[] intersect(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1 > len2){
            return intersect(nums2, nums1);
        }

        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int low = 0; int high = len2 -1;
        for(int element: nums1){
            int targetIdx = binarySearch(element, nums2, low, high);
            if(targetIdx != -1){
                result.add(element);
                low = targetIdx +1;
            }
        }

        int[] resultArray = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
    private int binarySearch(int target, int[] nums, int low, int high){

        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                //find the first occurrence of the target
                if(mid == low || nums[mid] != nums[mid-1]){
                    return mid;
                }else{
                    high = mid-1;
                }
            }
            else if(nums[mid] > target){
                //left half
                high = mid-1;
            }else if(nums[mid] < target){
                //right half
                low = mid +1;
            }
        }
        return -1;
    }


    //hashMap solution
    //Time Complexity : O(m+n)) where m is length of the nums1 array and n is the length of the nums2 array
    // Space Complexity : O(min(m,n)) where m is length of the nums1 array and n is the length of the nums2 array
    // Did this code successfully run on Leetcode :yes
    public int[] intersectBruteForce(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 > len2){
            return intersectBruteForce(nums2, nums1);
        }
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0; i<len1; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        for(int element: nums2){
            if(map.containsKey(element)){
                result.add(element);
                map.put(element, map.get(element)-1);
                map.remove(element, 0);
            }
        }
        int[] resultArray = new int[result.size()];
        for(int i =0; i< result.size(); i++){
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    //Two-pointer solution:
    //Time Complexity :  O(m+n)) where m is length of the nums1 array and n is the length of the nums2 array
    //not counting O(n*log(n)) + O(m * log(m)) taken for sorting the two arrays
    // Space Complexity : O(1) as no auxiliary space is used
    // Did this code successfully run on Leetcode :yes
    public int[] intersectBF2(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1 > len2){
            return intersectBF2(nums2, nums1);
        }

        List<Integer> result = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;

        while(p1 < len1 && p2 < len2){
            if(nums1[p1] < nums2[p2]){
                p1++;
            }else if(nums1[p1] > nums2[p2]){
                p2++;
            }else{
                result.add(nums1[p1]);
                p1++;
                p2++;
            }
        }

        int[] resultArray = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
