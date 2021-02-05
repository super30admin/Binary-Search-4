// Time Complexity : The time complexity is O(mlogm+mlogn) where m is the length of the array1 and n is the length of array2
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1 == 0 || len2 == 0){
            return new int[0];
        }

        if(len2 < len1){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            len1 = nums1.length;
            len2 = nums2.length;
        }

        // Sort the arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // two pointers
        int pt1 = 0;
        int pt2 = 0;
        int i=0;

        // traverse to find the intersection of both the arrays
        while(pt1 < len1 && pt2 < len2){

            if(nums1[pt1] == nums2[pt2]){
                nums1[i++] = nums1[pt1];
                pt1++;
                pt2++;
            }
            else if(nums1[pt1] < nums2[pt2]){
                pt1++;
            }
            else{
                pt2++;
            }
        }

        return Arrays.copyOfRange(nums1,0,i);

    }
}