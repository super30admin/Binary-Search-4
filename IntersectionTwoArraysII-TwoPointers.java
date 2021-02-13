//Problem 91: Intersection of Two Arrays II
//TC:O(m+n);//O(min(m,n));
//SC: O(1)

/*
Steps
If arrays is sorted use Two Pointers. If both elements are equal record that and move both the pointers, otherwise move the lower one because of ascending value becuse u wont be getting lower elemnt value again in another array.

*/


//Using Two Pointers-> If array is sorted
import java.util.*;
class Solution91TP {


     //Using Two Pointers- if array is sorted
    //If both elements are equal record that and move both the pointers, otherwise move the lower one because of ascending value.
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0) return new int[0];
        
        //If array is sorted
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int p1=0;
        int p2=0;
        List<Integer> result = new ArrayList<>();
        
        while(p1<nums1.length && p2<nums2.length){
            
            if(nums1[p1]==nums2[p2]){
                result.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1]<nums2[p2]){
                p1++;
            }else{
                p2++;
            }
            
        }
        
        int[] arr = new int[result.size()];
        int i=0;
        for(int elem:result){
            arr[i++] = elem;
        }
        
        return arr;
        
    }


}