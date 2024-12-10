// Time Complexity :O(m log m + n log n + m log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1= nums1.length;
        int n2= nums2.length;

        if(n1>n2) return intersect(nums2, nums1);

        List<Integer> result = new ArrayList<>();
        int l = 0; int h=n2-1;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for(int num: nums1){
            int bsIndex = binarySearch(nums2, l,h,num);
            if(bsIndex != -1){
                result.add(num);
                l = bsIndex+1;
            }
        }

        int[] res = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            res[i]=result.get(i);
        }
        return res;
    }

    private int binarySearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;

            if(nums[mid]==target){
                if(mid==low || nums[mid]!=nums[mid-1]){
                    return mid;
                }else{
                    high = mid-1;
                }
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}
