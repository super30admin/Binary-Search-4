// Time Complexity : The time complexity is O(log(m+n)) where m is the length of the array1 and n is the length of array2
// Space Complexity : The space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        double output;

        int len = len1+len2;

        // Two pointers
        int pt1=0;
        int pt2=0;
        int cur=0;
        int prev=0;
        int index=0;
        int target = (len1+len2)/2;

        // traverse till the median
        while(index <= target){

            if(pt1 == len1){
                prev = cur;
                cur = nums2[pt2++];
            }
            else if(pt2 == len2){
                prev = cur;
                cur = nums1[pt1++];
            }
            else{
                if(nums1[pt1] < nums2[pt2]){
                    prev = cur;
                    cur = nums1[pt1++];
                }
                else{
                    prev = cur;
                    cur = nums2[pt2++];
                }
            }
            index++;
        }

        //return the median
        if(len%2 == 0){
            output = (prev+cur)/2.0;
        }
        else{
            output = cur;
        }

        return output;

    }
}