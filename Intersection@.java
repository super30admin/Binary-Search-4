//Time - O(m+n)
//space -O(m-n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        if(nums1==null || nums2== null) return new int[0];
        if(nums1.length > nums2.length){
            return intersect (nums2, nums1);}
        
        for(int num : nums1)
        {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        List<Integer> result = new ArrayList<>();
        for(int num :nums2){
            if(map.containsKey(num)){
                result.add(num);
                map.put(num, map.get(num) -1);
                map.remove(num ,0);
            }
        }
            int [] arr = new int[result.size()];
        for(int i =0 ; i<arr.length; i++){
            arr[i] = result.get(i);
        }    
         return arr;   
    }
}