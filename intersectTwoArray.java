//350. Intersection of Two Arrays II
// Time Complexity : O(M+N)
// Space Complexity : O(min (M,N))
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

//using hashMap without sorting the given 2 arrays
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0)
            return nums1;
        
        if(nums2 == null || nums2.length == 0)
            return nums2;
        
        int n1 = nums1.length, n2 = nums2.length;
        
        if(n1 > n2)
            return intersect(nums2, nums1);
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for(int num: nums1){
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<n2; i++){
            if(countMap.containsKey(nums2[i])){
                //update map
                countMap.put(nums2[i], countMap.get(nums2[i])-1);
                list.add(nums2[i]);
                
                //remove from map if count is 0
                if(countMap.get(nums2[i]) == 0){
                    countMap.remove(nums2[i]);
                }  
            }
        }
            
            int[] result = new int[list.size()];
            
            for(int i=0; i<list.size(); i++){
                result[i] = list.get(i);
            }
            
        return result;
    }
}