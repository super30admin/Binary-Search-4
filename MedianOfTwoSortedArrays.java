
// Time Complexity : O(log(min(N,M))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length)
            return findMedianSortedArrays(nums2,nums1);
        int lenA = nums1.length;
        int lenB = nums2.length;
        boolean isEven = (lenA+lenB) % 2 == 0;
        int low = 0;
        int high = lenA;
        while(low <= high){
            int partA = low + (high-low)/2;
            int partB = (lenA+lenB)/2 - partA;
            double leftA = partA == 0 ? Integer.MIN_VALUE : nums1[partA-1];
            double leftB = partB == 0 ? Integer.MIN_VALUE : nums2[partB-1];
            double rightA = partA == lenA ? Integer.MAX_VALUE : nums1[partA];
            double rightB = partB == lenB ? Integer.MAX_VALUE  : nums2[partB];
            //System.out.println(leftA+" "+leftB+" "+rightA+" "+rightB);
            if(leftA <= rightB && leftB <= rightA){
                if(isEven)
                    return (Math.max(leftA,leftB)+ Math.min(rightA,rightB)) / 2;
                else
                    return Math.min(rightA,rightB);
            }else if(leftA > rightB){
                high = partA - 1;
            }else{
                low = partA + 1;
            }
        }
        return -1;
        
    }
}
