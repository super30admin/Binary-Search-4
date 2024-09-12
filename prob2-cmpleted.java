//TC:O(n+m)
//sc:o(n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++)
               map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        
        for(int j=0;j<nums2.length;j++)
        {
          if(map.containsKey(nums2[j]))
          {
              if(map.get(nums2[j])==0)
                  map.remove(nums2[j]);
              else
              {
                  list.add(nums2[j]);
                  map.put(nums2[j],map.getOrDefault(nums2[j],0)-1);
              }
                  
          }
        }
        
        int a[] = new int[list.size()];
        int k =0;
        for(int i : list)
            a[k++]=i;
        
        return a;
    }
}