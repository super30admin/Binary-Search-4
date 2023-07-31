// Time Complexity :O(m+n)
// Space Complexity : O(n) min(m,n)
// Did this code successfully run on Leetcode : Yes     
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// we build a frequency map for the smaller array and iterate on the larger array for each element we check it in the map
// if it is in the map we decrease the count and insert it to the map again.
// when the freq becomes 0, we remove that entry from the map
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length; 
        int n = nums2.length;
        if(m>n)
        {
            return intersect(nums2,nums1);
        }
        List<Integer> li = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int el: nums1)
        {
            map.put(el, map.getOrDefault(el,0)+1);
        }
        for(int el:nums2)
        {
            if(map.containsKey(el))
            {
                li.add(el);
                map.put(el, map.get(el)-1);
                if(map.get(el)==0)
                {
                    map.remove(el);
                }
            }
        }
        int result[] = new int[li.size()];
        for(int i =0;i<li.size();i++)
        {
            result[i]= li.get(i);
        }
        return result;

    }
}