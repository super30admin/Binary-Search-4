class Solution {
  //TC: O(n) SC: O(n)
    public int[] intersect(int[] nums1, int[] nums2) {
     List<Integer> result=new ArrayList<>();int[] res;
        HashMap<Integer,Integer> map=new HashMap<>();
      
            //put element and count in hashmap
            
            for(int i=0;i<nums1.length;i++){
                if(!map.containsKey(nums1[i]))
                   map.put(nums1[i],1);
                  else
                   map.put(nums1[i],map.get(nums1[i])+1);
            }
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
                map.put(nums2[i],map.get(nums2[i])-1);
                result.add(nums2[i]);
                if(map.get(nums2[i])==0){
                    map.remove(nums2[i]);
                }
            }
            
        }
        res=new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i]=result.get(i);
            
        }
        return res;
    }
}
