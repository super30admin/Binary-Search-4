import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time complexity- O(n1 + n2) + O(n1 log n1  + n2 log n2)
//Space complexity- O(n)
//Sucessfully ran on leetcode

class Solution {
 public int[] intersect(int[] nums1, int[] nums2) {
     
     if(nums1 == null || nums2 == null || nums1.length==0 || nums2.length==0) return new int[]{};
     
     //2 pointer solution
     int n1 = nums1.length;
     int n2 = nums2.length;
     int p1 = 0;
     int p2 = 0;
     List<Integer> result = new ArrayList<>();
     if(n2< n1){
         return intersect(nums2,nums1);
     }
     
     Arrays.sort(nums1);
     Arrays.sort(nums2);
     
     while(p1 < n1 && p2 < n2){
         
         if(nums1[p1]== nums2[p2]){
             result.add(nums1[p1]);
             p1++;
             p2++;
         }
         else if(nums1[p1] < nums2[p2]) 
             p1++;
         
         else p2++;
     }
     int[] ans = new int[result.size()];
   for(int i=0; i< result.size(); i++){
       ans[i]= result.get(i);
   } 
     return ans;
 }
}