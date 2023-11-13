// Time Complexity : O(n1+n2)
// Space Complexity : O(n1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class IntersectionOfTwoArrays {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {

            // int n1 = nums1.length, n2 = nums2.length;

            // List<Integer> list = new ArrayList<>();

            // Arrays.sort(nums1);
            // Arrays.sort(nums2);

            // int p1 = 0, p2 = 0;
            // while(p1 <= n1- 1 && p2 <= n2 - 1){
            //     if(nums1[p1] == nums2[p2]){
            //         list.add(nums1[p1]);
            //         p1++;
            //         p2++;
            //     }
            //     else if(nums1[p1] < nums2[p2]){
            //         p1++;
            //     }
            //     else{
            //         p2++;
            //     }
            // }

            // int n = list.size();
            // int[] result = new int[n];
            // for(int i = 0; i < n; i++){
            //     result[i] = list.get(i);
            // }

            // return result;


            int n1 = nums1.length, n2 = nums2.length;
            //let get 1st array as smaller one
            if(n2 < n1)
                return intersect(nums2, nums1);

            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();

            //store smaller array in map
            for(int num : nums1){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            for(int num : nums2){
                if(map.containsKey(num)){
                    list.add(num);
                    map.put(num, map.get(num) - 1);
                    map.remove(num, 0);
                }
            }

            int n = list.size();
            int[] result = new int[n];
            for(int i = 0; i < n; i++){
                result[i] = list.get(i);
            }

            return result;
        }
    }
}
