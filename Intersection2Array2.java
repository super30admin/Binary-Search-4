//Personal Solution
//Time Complexity:O(m+n)
//Space Complexity:o(m):
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       if (nums1 == null || nums1.length ==0 || nums1 == null || nums1.length ==0){
        return new int[]{};
       } 

       int m = nums1.length;
       int n = nums2.length;
       if (m > n){
        intersect (nums2, nums1);
       }

       HashMap<Integer,Integer> map= new HashMap<>();
       for (int i = 0;i < n;i++){
        map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
       }
      ArrayList<Integer> res = new ArrayList<>(); 
       for (int num:nums1){
        if (map.containsKey(num) && map.get(num)!= 0){
            map.put(num, map.get(num)-1);
            res.add (num);
        }
       }
       return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
