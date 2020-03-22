// Time Complexity : O(m+n) ---> O(mlogm+nlogn)
// Space Complexity : O(HashMapSpace+ResultantSpace) ---> O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
//         ArrayList<Integer> list = new ArrayList<>();
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i=0;i<nums1.length;i++){
//             if(map.containsKey(nums1[i]))
//                 map.replace(nums1[i], map.get(nums1[i])+1);
//             else
//                 map.put(nums1[i], 1);
//         }
        
//         for(int i=0;i<nums2.length;i++)
//         {
//             if(map.containsKey(nums2[i]) && map.get(nums2[i]) != 0){
//                 System.out.println(map.get(nums2[i]));
//                 list.add(nums2[i]);
//                 int key = nums2[i];
//                 int value = map.get(nums2[i])-1;
//                 map.replace(key, value);
//             }
//         }
        
//         int[] result=new int[list.size()];
//         for(int i = 0; i < list.size();i++){
//             result[i] = list.get(i);
//         }
        
//         return result;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int first = 0, second = 0;
        
        List<Integer> list = new LinkedList<>();
        
        while(first < nums1.length && second < nums2.length) {
            if(nums1[first] == nums2[second]) {
                list.add(nums1[first]);
                first++;
                second++;
            } else if(nums1[first] > nums2[second]) {
                second++;
            } else {
                first++;
            }
        }
        
        int[] result = new int[list.size()];
        int i = 0;
        for(int ele: list) {
            result[i++] = ele;
        }
        return result;
        
        
    }
}
