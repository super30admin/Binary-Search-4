// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> second = new HashMap<>();
        ArrayList<Integer> finalList = new ArrayList<>();
        
        for(int i=0;i<nums1.length;i++) {
            if(first.containsKey(nums1[i])) {
                first.put(nums1[i], first.get(nums1[i])+1);
            } else 
                first.put(nums1[i], 1);
        }

        for(int i=0;i<nums2.length;i++) {
            if(first.containsKey(nums2[i])) {
                if(first.get(nums2[i])>0) {
                    first.put(nums2[i], first.get(nums2[i])-1);
                    finalList.add(nums2[i]);
                }
            }
        }
        int[] finalArr = finalList.stream().mapToInt(i -> i).toArray();
        return finalArr;
    }
}
