// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: store all the elemts from arr1 in hashmap and from 2nd array check if that element id there in hash map then remove elemet and add it to the result n return retult
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length; int n2 = nums2.length;
        if(n1 > n2) return intersect(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0 ) + 1);
        }
        List<Integer> li = new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num)){
                li.add(num);
                map.put(num, map.get(num)-1);
                map.remove(num,0);

            }
        }
        int[] r = new int[li.size()];
        for(int i = 0; i< li.size(); i++){
            r[i] = li.get(i);
        }
        return r;
    }
}