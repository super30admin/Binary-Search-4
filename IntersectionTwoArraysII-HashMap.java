//Problem 91: Intersection of Two Arrays II
//TC: Max(O(nums1),O(nums2))
//SC: O(Min(nums1,nums2))

/*
Steps
Have to find common elements amoung two arrays.
Make HashMap of smaller elements for preventing space wastage. Add elements along with their frequency in the hash map. Then iterate over the other array along with reduce common/matched element frequency 
*/

//Using HashMap
import java.util.*;
class Solution91Hashing {

    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0) return new int[0];
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        //will create hash map on smaller array, so thinking that nums1 is smaller
        if(n1>n2) return intersect(nums2, nums1);//If nums2 is greater than nums1, so preventing if else comparison of nums 1 and nums2
        
        //will store elements of smaller array in map to optimize space
        Map<Integer,Integer> map = new HashMap<>();
        
        //Will consider nums1 to be smaller always
        
        for(int elem:nums1){
            map.put(elem,map.getOrDefault(elem,0)+1);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(int elem:nums2){
            
            if(map.containsKey(elem)){
               result.add(elem);
               map.put(elem,map.get(elem)-1);
               map.remove(elem,0); 
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