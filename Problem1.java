// Time Complexity : O(mlogm + nlogn) where m and n are two given arrays
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We use Two pointers approach to find the intersection 
// We sort both the arrays and loop through them
//If we find the same elements in both we add them to the list and move both the pointers to next element
//We move the pointer only if we have the smaller element in one of the arrays


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1=0; int p2=0;
        List<Integer> li = new ArrayList<>();

        while(p1 < n1 && p2 < n2) {
            if (nums1[p1] == nums2[p2]) {
                li.add(nums1[p1]);
                p1++;
                p2++;
            } else if(nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        int [] result = new int[li.size()];
        for(int i=0; i< li.size(); i++) {
            result[i] = li.get(i);
        }

        return result;
        
    }
}
