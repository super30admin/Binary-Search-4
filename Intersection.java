// o(m+n)  time || space - O(m+n) space
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap <Integer, Integer> map = new HashMap<>();
        for(int i =0; i< nums1.length; i++){
            map.put(nums1[i], 1);
            
        }
       
        for(int j =0; j<nums2.length; j++){
            if(map.containsKey(nums2[j]) == true){
                res.add(nums2[j]);
                map.remove(nums2[j]);
               
            }
        }
        int[] arr = new int[res.size()];
        for(int i =0; i< arr.length; i++){
            arr[i]= res.get(i);
        }
        
        return arr;
    }
}
