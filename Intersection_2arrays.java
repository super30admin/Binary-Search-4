import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time Complexity : O(mlogn)
//Space COmplexity : O(N) -> result list
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return new int[0];
        if(nums1.length > nums2.length) return intersect(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length; 
        int n = nums2.length;
        List<Integer> result = new ArrayList<>();
        int low = 0; int high = n-1;
        for(int i = 0; i < m; i++){
            int bsIndex = binarySearch(nums2,low,high,nums1[i]);
            if(bsIndex != -1){
            result.add(nums1[i]);
            low = bsIndex + 1;
            }
        }
        int [] arr = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            arr[i]=result.get(i);
        }
        return arr;
    }
    private int binarySearch(int[] arr, int low, int high,int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                if(mid == low || arr[mid] > arr[mid -1]) return mid;
                else high = mid - 1;
                
            }else if(arr[mid] > target){
                high = mid -1; 
            }
            else{
                low = mid+1;
            }
            
        }
        return -1;
    }
}