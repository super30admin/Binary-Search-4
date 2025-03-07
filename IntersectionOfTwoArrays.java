//HashMap solution
class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m= nums1.length;
        int n = nums2.length;
        if(m>n)
        {
            return intersect(nums2,nums1);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums1)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        ArrayList<Integer> li = new ArrayList<>();
        for(int num:nums2)
        {
                if(map.containsKey(num))
                {
                    li.add(num);
                    map.put(num,map.get(num)-1);
                    map.remove(num,0);
                }
        }
        int[] res = new int[li.size()];
        for(int i=0;i<li.size();i++)
        {
            res[i] = li.get(i);
        }
        return res;
    }
}

//tc: O(m+n) where m and n are the sizes of the given arrays
//sc: O(min(m,n))