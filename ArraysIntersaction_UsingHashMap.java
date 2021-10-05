// Time Complexity :O(m + n ) n = length of array1 m = length of array2
// Space Complexity :O(n) length of bigger array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach

//store larger arrays values in hashmap along with each nums frequency in that array 
// 2.run another loop through second array and check if this nums is in map or not if yes then add it in result reduce its count by one in map and if it is zero then remove it from map

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        if(nums1 == null || nums1.length == 0 || nums2 == null | nums2.length ==0)
            return new int[0];
        
        if(nums2.length > nums1.length) 
        {
            // make sure the first array is big1
          return intersect(nums2,nums1);
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num1: nums1 )
        {
           
            map.put(num1,map.getOrDefault(num1,0)+1);
        }
        
        for(int num2: nums2)
        {
            if(map.containsKey(num2))
            {
                 result.add(num2);
                 map.put(num2,map.get(num2)-1);
                 if(map.get(num2)<=0)
                  map.remove(num2);
             }
        }
        int[] arr = new int[result.size()];
         for(int i = 0 ; i < result.size();i++ )
        {
            arr[i] = result.get(i);
        }
        return arr;
    }
}