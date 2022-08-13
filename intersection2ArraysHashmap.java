//TC = O(m+n)
//SC =O(m)
//amazon interview
//Hashmap decided to put small number or smaller array in my hashmap and record the intersection and reduce 1 from count and make it zero and remove from hashmap after adding to resultant list.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
           return new int[] {};
       } 
        //Hashmap solution
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2<n1){
            return intersect(nums2,nums1);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int num:nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:nums2){
            if(map.containsKey(num)){
                result.add(num);
                int cnt = map.get(num);
                cnt--;
                if(cnt == 0){
                    map.remove(num);
                }else{
                    map.put(num,cnt);
                }
            }
        }
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}