//TC O(m log n)
//SC O(1)
//Executed in Leetcode: yes

/*
Sort the arrays and search for each element from nums1 in nums2 using binary search
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class IntersectionOfArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int index = 0;
        for(int i=0;i<nums1.length;i++){
            int loc = binarySearch(nums2, index, nums1[i]);
            if(loc< nums2.length && nums2[loc] == nums1[i]){
                list.add(nums1[i]);
                index = loc+1;
            }
        }
        int[] res = new int[list.size()];
        int i =0;
        for(int element:list){
            res[i++] = element;
        }
        return res;
    }

    public int binarySearch(int[] nums, int index, int target){
        int left = index, right = nums.length-1;
        int mid;
        while(left<=right){
            mid = left + (right - left)/2;

            if(nums[mid]<target)
                left = mid+1;
            else
                right = mid - 1;
        }
        return left;
    }
}