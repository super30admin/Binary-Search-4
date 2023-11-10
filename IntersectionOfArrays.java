// Time Complexity : O(n+m) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: None

// Your code here along with comments explaining your approach

class IntersectionOfArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1 = new HashMap();
        HashMap<Integer,Integer> map2 = new HashMap();
        if(nums2.length < nums1.length){
            return intersect(nums2, nums1);
        }
        for(int num: nums1){
            map1.put(num,map1.getOrDefault(num,0)+1);
        }
        List<Integer> res = new ArrayList();
      
        for(int num2: nums2){
            if(map1.containsKey(num2) && map1.get(num2)>0){
                res.add(num2);
                map1.put(num2,map1.get(num2)-1);
            }
        }
        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
}