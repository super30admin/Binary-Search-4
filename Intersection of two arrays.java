//Time complexity: O(n)
//Space complexity: O(n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int m= nums1.length; int n=nums2.length;
        List<Integer> result=new ArrayList();
        for(int i=0;i<m;i++)
        {
            map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
        }
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i])!=0)
            {
                int count=map.get(nums2[i]);
               
                count--;
                map.put(nums2[i],count);
              
                result.add(nums2[i]);
            }
        }
        int[] res= new int[result.size()];
        for(int i=0;i<res.length;i++)
        {
            res[i]= result.get(i);
        }
        return res;
    }
}