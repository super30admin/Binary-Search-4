/**  Time Complexity : O(M+N)
  Space Complexity : O(N)
 Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
**/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        if(nums1 == null || nums2 == null || nums2.length == 0 || nums1.length == 0){
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        if(nums1.length > nums2.length){
            for(int n : nums1){
                int count = map.getOrDefault(n, 0);
                map.put(n, count+1);
            }
            for(int a : nums2){
                if(map.containsKey(a)){
                    int m = map.get(a);
                    if(m > 0){
                        map.put(a, m-1);
                        result.add(a);
                    }
                }
            }
            
        }else{
            for(int m : nums2){
                int count1 = map.getOrDefault(m,0);
                map.put(m, count1+1);
            }
            for(int b : nums1){
                if(map.containsKey(b)){
                    int k = map.get(b);
                    if(k > 0){
                        map.put(b, k-1);
                        result.add(b);
                    }
                }
            }
        }
        // the below one i used stream to conver list to int array
         int[] primitive = result.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
        return primitive;

        
    }
}
