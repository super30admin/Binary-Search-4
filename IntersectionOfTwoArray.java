import java.util.*;
//Time Complexity mlogn ( m is the length of smallar array and logn from binary search on longer array)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;
        int k = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2){
            return intersect(nums2, nums1);
        }
        List<Integer> l = new ArrayList<>();
        for(int num : nums1){
            int a = BinarySearch(nums2,index, n2-1,num);
            if(a != -1){
                l.add(num);
                index = a + 1;
            }
        }
        
        int[] result = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            result[i] = l.get(i);
        }
        return result;
     }
    
    private int BinarySearch(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = left + (right-left)/2;
            if(target == nums[mid]){
                if(mid == left || nums[mid] > nums[mid-1]){
                    return mid;
                }
            }
            if(target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
            
        }
        return -1;
    }
}