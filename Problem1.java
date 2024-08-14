//Time = O(mn), two array lengths
//Space = O(k), size of intersection of nums1, nums2

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Create an empty ArrayList to store the intersection of nums1 and nums2.
        List<Integer> list = new ArrayList<Integer>();
        
        // Iterate over each element of nums1.
        for (int i = 0; i < nums1.length; i++) {
            // For each element of nums1, iterate over each element of nums2.
            for (int j = 0; j < nums2.length; j++) {
                // If there's a matching element in nums2, add it to the ArrayList and mark it in nums2 by changing its value to -1.
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                    nums2[j] = -1;
                    break;
                }
            }
        }
        
        // Convert the ArrayList to an array and return it as the result.
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
