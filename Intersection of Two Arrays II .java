class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums2.length>nums1.length) intersect(nums2,nums1);

        HashMap<Integer,Integer> map = new HashMap<>();

        ArrayList<Integer> res = new ArrayList<>();

       for(int i=0 ; i<nums1.length ; i++)
       {
           map.put(nums1[i] , map.getOrDefault(nums1[i],0)+1);
       }

        for(int n :nums2)
        {
            if(map.containsKey(n))
            {
                res.add(n);
                map.put(n , map.getOrDefault(n,0)-1);
                if(map.get(n)==0) map.remove(n);
            }
        }

        int[] ans = new int[res.size()];
        int index=0;

        for(int n : res)
        {
            ans[index++] = n;
        }

        return ans;

    }
}
