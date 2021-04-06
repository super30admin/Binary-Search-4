
// Time Complexity : O(n)
// Space Complexity : O(n)
// Where n is total number of elements present in nums1 and nums2
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      int m = nums1.length;
      int n = nums2.length;
      if(n<m) return intersect(nums2,nums1);
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int num : nums1)
      {
          map.put(num,map.getOrDefault(num,0)+1);
      }
      List<Integer> intersect = new ArrayList<>();
      for(int num : nums2)
      {
          if(map.containsKey(num)&&map.get(num)>0)
          {
              intersect.add(num);
              map.put(num,map.get(num)-1);
          }
      }
        int [] result = new int[intersect.size()];
        int i = 0;
        for(int num : intersect)
        {
            result[i++] = num;
        }
        return result;
    }
}