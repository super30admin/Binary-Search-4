// TC : O(n log n + m log m + n log m)
// SC : O(1)

package S30_Codes.Binary_Search_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return intersect(nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> res = new ArrayList<>();
        int num2Start = 0;
        int num2End = nums2.length-1;

        for(Integer num : nums1){
            if(num2Start > num2End)
                break;
            int idx = binarySearch(num2Start, num2End, nums2, num);
            if(idx > -1){
                res.add(num);
                num2Start = idx+1;
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private int binarySearch(int start, int end, int nums[], int num){
        while(start <= end){
            int mid = (end-start)/2 + start;

            if(nums[mid] >= num){
                end = mid-1;
            }
            else
                start = mid+1;
        }

        if(start >= nums.length)
            return -1;
        return nums[start] == num ? start : -1;
    }
}