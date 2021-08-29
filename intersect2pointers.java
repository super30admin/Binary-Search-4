//Time complexity: O(N + M)
//Space complexity: O(1)

import java.util.*;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1 == null || nums1.length == 0)
            return nums1;
        
        if(nums2 == null || nums2.length == 0)
            return nums2;
        
        int n1 = nums1.length, n2 = nums2.length;
        
        if(n1 > n2) return intersect(nums2, nums1);
                
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList<>();
        
        int p1 = 0, p2 = 0;
        
        while(p1 < n1 && p2 < n2){
            //equal
            if(nums1[p1] == nums2[p2]){
                list.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1] < nums2[p2]){
                p1++;
            }
            else{
                p2++;
            }
        }
            
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
}