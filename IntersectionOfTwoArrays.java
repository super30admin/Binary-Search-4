import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//Time Complexity : For two unsorted Arrays : O(N1)+O(N2)
// For two sorted  Arrays : O(N1 Log(N2)) where N2 is the size of big array
//Space Complexity : For two unsorted Arrays : O(N), N is the smaller array
//					For two sorted  Arrays : O(1)
//Did this code successfully run on Leet code :Yes
//Any problem you faced while coding this :

public class IntersectionOfTwoArrays {
	  //There are three Approaches 
    // If unsorted use Frequency map of one and traverse the second to find intersection (O(n1)+O(n2))
    // If sorted, we can use two pointer (O(n1)+O(n2))
    // If sorted we can use binary search O(n1(log(n2))) where n2>n1

    int low;
    public int[] intersect(int[] nums1, int[] nums2) {
      if(nums1==null || nums2==null || nums1.length==0|| nums2.length==0)
        {
           return new int[]{};
        }  
        
      int n1 = nums1.length;
       int n2 = nums2.length;
       low=-1;
        // assuming n1 is bigger thn n2 
       if(n1>n2) return intersect(nums2,nums1);
        
        Arrays.sort(nums2);
        Arrays.sort(nums1); 
        
       List<Integer> result = new ArrayList<>();
       
      for(int num: nums1){
          if(binarySearch(nums2,num,low+1,n2-1)){
             result.add(num); 
          }
      }  
        
       return result.stream().mapToInt(Integer::intValue).toArray();
        
    }
    // Binary search to find left most occurrence of the number
    public boolean binarySearch(int[] arr, int num,int lw,int high){
      while(lw<=high){
          int mid = lw+(high-lw)/2;
          if(arr[mid]==num){
               if(mid==lw || arr[mid-1]!=num){
                   low=mid;
                   return true;
               }else{
                   return binarySearch(arr,num,lw,mid-1);
               }
          }
          else if(arr[mid]>num){
              high = mid-1;
          }else{
              lw = mid+1; 
          }
        }  
        
        return false;
    }
}
