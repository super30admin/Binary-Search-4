// Time Complexity: O(m+n)
//Space Complexity: O(min(m,n))

/*
 * create a hashmap for the smaller array and check if the element is present
 * int the bigger array.
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(m > n) return intersect(nums2, nums1);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> li = new ArrayList<>();
        for(int num: nums2){
            if(map.containsKey(num)){
                li.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }

        int[] result = new int[li.size()];
        for(int i = 0; i < li.size(); i++){
            result[i] = li.get(i);
        }

        return result;
    }
}