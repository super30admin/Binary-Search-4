TC: O(n)
SC: O(n)

Runtime: 4 ms, faster than 22.49% of Java online submissions for Intersection of Two Arrays II.
Memory Usage: 36.6 MB, less than 83.87% of Java online submissions for Intersection of Two Arrays II.


Approach: Take two hashmaps with key as the array element and value as count.Then create an array with keys common in both the 
maps with number of keys the minimum of values of both the hashmaps

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i: nums1){
            map1.put(i,map1.getOrDefault(i,0)+1);
        }
        for(int i: nums2){
            map2.put(i,map2.getOrDefault(i,0)+1);
        }
        
        for(int i: map1.keySet()){
            int val = map1.get(i);
            if(map2.containsKey(i)){
                int val1 = map2.get(i);
            for(int k=0 ; k< Math.min(val,val1); k++)
                list.add(i);
            }
            
        }
   int[] arr = new int[list.size()]; 
        
        for (int i =0; i < list.size(); i++) 
            arr[i] = list.get(i); 
  
        
  
    return arr;
    }
}
