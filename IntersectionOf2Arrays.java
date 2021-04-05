// Time Complexity : O(n+m)
// Space Complexity : O(min(n,m))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Using extra space - HashMap
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) return intersect(nums2,nums1);
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums1)
            map.put(i,map.getOrDefault(i,0)+1);
        for(int j:nums2){
            if(map.containsKey(j)){
                map.put(j,map.get(j)-1);
                if(map.get(j) == 0)
                    map.remove(j);
                result.add(j);
            }
        }
        int[] output = new int[result.size()];
        for(int i=0;i<result.size();i++)
            output[i] = result.get(i);
        return output;
    }
}

// Approach -2 : Using two pointers and without extra space

// Time Complexity : O(Max(n,m) log(Max(n,m)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(m < n) return intersect(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0,j=0;
        while(i< n && j< m){
            if(nums1[i] == nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
           
        int[] output = new int[result.size()];
        for(int k=0;k<result.size();k++)
            output[k] = result.get(k);
        return output;
    }
}
