package BinarySearch4;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArrays {

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return intersect(nums2, nums1);
        int low = 0;
        int high = nums2.length-1;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> res = new ArrayList<>();
        for(int num : nums1){
            int idx = search(nums2, low, high, num);
            if( idx != -1){
                res.add(num);
                low = idx + 1;
            }
        }
        int ret[] = new int[res.size()];
        for(int i=0; i< ret.length; i++){
            ret[i] = res.get(i);
        }
        return ret;
    }
    private int search(int[] arr, int low, int high, int target){
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target){
                if(mid == low || arr[mid] > arr[mid-1])
                    return mid;
                else
                    high = mid - 1;
            }
            else if(arr[mid] > target){
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
