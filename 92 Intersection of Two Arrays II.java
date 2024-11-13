// Time Complexity : O(n1+n2)
// Space Complexity : O(n2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    //aesha
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for(int num :nums2)
        {             
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int num: nums1)
        {
            if(map.containsKey(num))
            {
                result.add(num); 
                map.put(num, map.get(num) -1 );
                map.remove(num,0);
            }
        }
        int[] re = new int[result.size()];
        for(int i = 0;i<re.length; i++)
        {
                re[i] = result.get(i);
        }
        return re;
    }
}