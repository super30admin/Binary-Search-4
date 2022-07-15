// Time Complexity: O(n) ; n=length of bigger array
// Space Complexity: O(m) ; m=length of smaller array
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        if(nums1.length>nums2.length) return intersect(nums2,nums1);
        List<Integer> ls = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0) + 1);
        }
        for(int j=0;j<nums2.length;j++){
            if(map.containsKey(nums2[j])){
                map.put(nums2[j],map.get(nums2[j]) - 1);
                map.remove(nums2[j],0);
                ls.add(nums2[j]);
            }
        }
        int []res = new int[ls.size()];
        for(int i=0;i<ls.size();i++){
            res[i]=ls.get(i);
        }
        return res;
    }
}
