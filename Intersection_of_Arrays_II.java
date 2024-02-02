// Time Complexity : O(n1 + n2)
// Space Complexity : O(n1)
// Method used : Hashing

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
     
        if(nums1 == null || nums2 == null) return new int[]{};
        
        ArrayList<Integer> list = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap();
        for(int x : nums1) map.put(x, map.getOrDefault(x , 0) + 1);
        
        for(int x : nums2)
        {
            if(map.containsKey(x))
            {
                list.add(x);
                int count = map.get(x);
                --count;
                if(count == 0)
                    map.remove(x);
                else 
                    map.put(x, count);
            }
        }
        
        int[] result = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        
        return result;
    }
}