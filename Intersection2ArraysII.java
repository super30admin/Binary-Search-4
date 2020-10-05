// Time Complexity : O(nlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Sort both array and then use two pointers
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null)
            return new int[0];
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> list = new ArrayList<>();
        
        int i =0;
        int j =0;
        while(i < nums1.length && j < nums2.length){
              if(nums1[i] < nums2[j]){
                    i++;
                }else if(nums1[i] > nums2[j]){
                    j++;
                }else{
                    list.add(nums1[i]);
                    i++;
                    j++;
                }
        }       
        int[] res = new int[list.size()];
        for(int k =0; k < list.size();k++){
            res[k] = list.get(k);
        }
        return res; 
    }
  
    
}