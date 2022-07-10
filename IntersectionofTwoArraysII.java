// T O(n+m)
// S O(m) where m is the smaller size array
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length) return intersect(nums2, nums1);
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for( int i :nums1)
        {
            frequencies.put(i,frequencies.getOrDefault(i,0)+1);
        }
      
        ArrayList<Integer> li = new ArrayList<>();
        for( int i:nums2)
        {
            if(frequencies.containsKey(i))
            {   
                int val = frequencies.get(i);
                val--;
                if(val==0)
                    frequencies.remove(i);
                else 
                    frequencies.put(i,val);
                li.add(i);
            }
        }
        int [] res =new int[li.size()];
        for(int i=0;i<res.length;i++)
            res[i]=li.get(i);
        
        return res;
        
    }
}