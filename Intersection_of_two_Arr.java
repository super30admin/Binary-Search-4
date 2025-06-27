/*
 * TC: O(n+m) where n = nums1.length and m = nums2.length;
 * SC: O(min(n,m)), size of the HashMap.
 * 
 * Approach: Here, initially i will iterate thorugh the smaller arr and store the value with its frequency in my hashmap. Then, i will iterate through my second arr and check if the value exist in my map, if it does then i will reduce the counf of the key and add the num to the result. 
 */


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
            if(nums1.length > nums2.length) return intersect(nums2,nums1);

        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer>  map = new HashMap<>();

        for(int num : nums1){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(int num : nums2){
            if(map.containsKey(num)){
                result.add(num);
                map.put(num, map.get(num)-1);
                if(map.get(num) == 0) map.remove(num);
            }
        }

        int[]  ans = new int[result.size()];
        int i =0;
        for(int n : result){
            ans[i++] = n;
        }
    return ans;
    }
}