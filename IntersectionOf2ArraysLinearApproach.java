
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :Nope


// Your code here along with comments explaining your approach
/*Approach:
1) we use a hashmap to iterate on this array
2) we iterate on the shorter array and store the counts of each integers
3) if length of num1 > num2
-> recurse 
4) iterate on num2 and for every occurence of element in hashmap
-> add to result list and also decrement the count from Map
-> if size of map is 0, we know we have already exhausted all the elements
-> we add in the final array by traversing the list

*/
import java.util.*;

public class IntersectionOf2ArraysLinearApproach {
    
        public int[] intersect(int[] nums1, int[] nums2) {
           if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0)
           {
               return new int[]{};
           
           }
            
           Map<Integer,Integer> map = new HashMap<>();
            
           if(nums1.length>nums2.length)
           {
               return intersect(nums2,nums1);
           }
            
            for(int num: nums1)
            {
                map.put(num,map.getOrDefault(num,0)+1);
            }
            
            List<Integer> res = new ArrayList<>();
            for(int i=0;i<nums2.length;i++)
            {
                if(map.containsKey(nums2[i]))
                {
                    res.add(nums2[i]);
                    map.put(nums2[i],map.get(nums2[i])-1);
                    map.remove(nums2[i],0);
                }
                
                if(map.size()==0)
                {
                    break;
                }
            }
            
            int [] resArr = new int[res.size()];
            for(int i=0;i<res.size();i++)
            {
                resArr[i]=res.get(i);
            }
            
            return resArr;
        }
        
    

}
