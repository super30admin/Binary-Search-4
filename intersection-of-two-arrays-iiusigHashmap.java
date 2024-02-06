class Solution {
    //TC: O(m+n)
    //SC : O(min(m,n))
    //HashMap solution
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return intersect(nums2,nums1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num)) {
                res.add(num);
                map.put(num,map.get(num) - 1);
                map.remove(num,0);
            }
        }
        int [] result = new int[res.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = res.get(i);
        }
        return result;
    }
}