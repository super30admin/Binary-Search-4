//Time complexity: O(n)
    // Space Complexity: O(n)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res=new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i])+1);
            } else{
                map.put(nums1[i],1);
            }
        }
        for(int j=0;j<nums2.length;j++){
            if(map.containsKey(nums2[j])){
                res.add(nums2[j]);
                map.remove(nums2[j]);
            }
        }
        int []result = new int[res.size()];
       for(int j=0;j<res.size();j++){
           result[j]=res.get(j);
       }
        return result;
    }
}
