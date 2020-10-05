    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/intersection-of-two-arrays-ii/
    Time Complexity for operators : o(max(m,n)) .. m and n are leangth of two different arrays
    Extra Space Complexity for operators : o(m) .. used hashmap
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : two for loops/
        # Optimized approach: 
                              
            # 1. 
                    A) Check the length of Array if nums1 is bigger then swap the arrays.
                    B) Then, add data into the hashmap with the counter of the elemnst repeated in it.
                    C) In the next for loop, check if elements are exist in the hashmap and deduct the count from hashmap.
                    D) Add those data starting from first index to the nums1.
                    E) At the end, return the firstk elements from the nums1.
    */  

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }
            
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<nums1.length;i++){
            if(!hm.containsKey(nums1[i])){
                hm.put(nums1[i],1);
            }else{
                hm.put(nums1[i],hm.get(nums1[i])+1);
            }
        }
        
        int k = 0;
        for(int i=0;i<nums2.length;i++){
            if(hm.containsKey(nums2[i])){
                int cnt = hm.getOrDefault(nums2[i],0);
                if(cnt > 0){
                    nums1[k++] = nums2[i];
                    hm.put(nums2[i],cnt-1);
                }
            }
        }
        
        return Arrays.copyOf(nums1, k);
    }
}