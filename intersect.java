// Time Complexity : O(log n) n is input length
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        if(nums1.length > nums2.length){
            return intersect(nums2,nums1);
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int start = 0;
        
        for(int i=0;i<nums1.length;i++){
            
            int ind = binSearch(nums1[i],start,nums2);
            if(ind < nums2.length && nums2[ind] == nums1[i]){
                result.add(nums1[i]);
                start = ind +1;
            }
        }
        
        
        int[] res = new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i] = result.get(i);
        }
        
        return res;
    }
    
    private int binSearch(int target, int start, int[] nums2){
            int s = start;
            int e = nums2.length-1;
            
            while(s<=e){
                int mid = s + (e-s)/2;
                if(nums2[mid]<target)
                    s = mid + 1;
                else
                    e = mid-1;

            }
            
           return s; 
        }
}