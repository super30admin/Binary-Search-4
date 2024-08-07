import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwo {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
         List<Integer> li = new ArrayList<>();
         if(nums1.length > nums2.length){
             return intersect(nums2, nums1);
         }
         int lo =0;
         int hi = nums2.length-1;
         for(int i =0; i< nums1.length;i++){
             int target = nums1[i];
            int curres = binarySearch(nums2,target,lo,hi);
            if(curres !=-1){
             li.add(target);
             lo = curres+1;
            }
            
      
         }
        int[] result = li.stream().mapToInt(i -> i).toArray();
        return result;
     }
 
     private int binarySearch(int[] nums,int target, int lo, int high){
 
         while(lo<=high){
             int mid = lo + (high-lo)/2;
             if(nums[mid]==target){
                 if(mid ==lo || nums[mid]!=nums[mid-1]){
                     return mid;
                 }else{
                     high = mid-1;
                 }
             }else if(nums[mid]> target){
                 high = mid-1;
             }else{
                 lo = mid+1;
             }
         }
 
         return -1;
     }
}
