// Time Complexity : O(n log m - m keeps reducing for finding further elements ; m - larger array
// Space Complexity : O(n) ; length of list
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {

    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        List<Integer> li = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int low = 0, high = nums2.length - 1;

        for(int i = 0; i < nums1.length; i++){
            int target = nums1[i];
            int bIndex = binSearch(nums2, low, high, target);

            if(bIndex != -1){
                li.add(target);
                low = bIndex + 1;
            }
        }

        return li.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int binSearch(int[] arr, int low, int high, int target){

        while(low <= high){
            int mid = low + (high - low)/ 2;
            if(arr[mid] == target){
                //bound check
                if(mid == low || arr[mid] != arr[mid - 1]){
                    return mid; // first index of target
                }else{
                    //move left
                    high = mid - 1;
                }
            }else if(arr[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
