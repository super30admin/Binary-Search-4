// Time Complexity : O(nlogn + mlogm) where m is length of smaller array
// Space Complexity : O(n) Space for list, because the list is converted an array later.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class IntersectionOfArray {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> li = new ArrayList<>();
        int low = 0; int high = nums2.length-1;
        for(int i=0;i<nums1.length;i++){
            int bsIndex = binarySearch(nums2, low, high, nums1[i]);
            if(bsIndex != -1){
                li.add(nums1[i]);
                low = bsIndex+1;
            }
        }
        int[] result = new int[li.size()];
        for(int i=0;i<li.size();i++){
            result[i] = li.get(i);
        }
        return result;
    }

    private int binarySearch(int [] arr, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target){
                if(mid==low || arr[mid]!=arr[mid-1]){
                    return mid;
                }
                else{
                    high = mid -1;
                }
            }
            else if(arr[mid]>target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String [] args){
        IntersectionOfArray is = new IntersectionOfArray();
        System.out.println(Arrays.toString(is.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}