// Time Complexity :  O(mlogn) m - smaller array length , n is larger array length
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if(len1>len2){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int part1;
        int part2;
        
        int start = 0;
        int end = nums1.length;
        int maxLeft1;
        int minRight1;
        int maxLeft2;
        int minRight2;
        while(start <= end){
            
        
        part1 = (start+end)/2;
        part2 = (len1+len2+1)/2-part1;
        
        
        
        if(part1==0){
            maxLeft1 = Integer.MIN_VALUE;
        }
        else{
            maxLeft1 = nums1[part1-1];
        }
        
        if(part2==0){
            maxLeft2 = Integer.MIN_VALUE;
        }
        else{
            maxLeft2 = nums2[part2-1];
        }
        
        if(part1==len1){
            minRight1 = Integer.MAX_VALUE;
        }
        else{
            minRight1 = nums1[part1];
        }
        
        if(part2==len2){
            minRight2 = Integer.MAX_VALUE;
        }
        else{
            minRight2 = nums2[part2];
        }
        
        if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){ //correct partition
            if((len1+len2) % 2==0){
                return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
            }
            else{
                return Math.max(maxLeft1, maxLeft2);
            }
        }
        else if(maxLeft1 > minRight2){
            end = part1-1;
        }
        else{
            start = part1+1;
        }
        
        
        }
        return 0.0;
    }
}