// Time Complexity : O(m+n)
// Space Complexity : O(m), m -> elements of smaller array as we are adding those elements in the hashmap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //null
        if(nums1 == null || nums2 == null)
            return new int[0];

        //hashmap approach
        //making sure nums2 is smaller everytime
        if(nums1.length < nums2.length){
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int m = nums1.length;
        int n = nums2.length;

        //putting elements of nums2 in hashmap with total number of occurence of each elemenrt
        for(int num : nums2){
            map.put(num, map.getOrDefault(num,0) +1);
        }

        List<Integer> li = new ArrayList<>();
        for(int num : nums1){
            if(map.containsKey(num)){
                li.add(num);
                map.put(num, map.get(num)-1);
                map.remove(num,0);
            }
        }

        int[] result = new int[li.size()];
        for(int i=0;i<result.length;i++){
            result[i] = li.get(i);
        }

        return result;
    }
}