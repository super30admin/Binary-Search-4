// Time Complexity - O(logn) where n is the min(n1,n2) where n1 is length of nums1 and n2 is length of nums2
// Space Complexity : O(1)
// This Solution worked on LeetCode
// This is the optimized algorithm with O(logn) time Complexity since both nums1 and nums2 arrays are sorted, the median property of having the elements to the left of median less than the elements to the right of the median is used. The algorithm is for finding the partition in nums1 and nums2 which will give the right median if both the arrays were to merge. The Binary search is applied on the array with lesser number of elements and the partX is found as median to start with, the corresponding partY is found such that number of elements in PartX and PartY are same or +1 in PartX. l1,r1,l2,r2 are calculated which are the immediate elements to the left and right of the partition in nums1 and nums2 respectively. if partX is 0 that the l1 is at the start of the nums1 which means no element from nums1 is considered in partX partition. so Integer min value is considered for l1 which will be useful for comparison if l1 <=r2. Similarly for r1 Integer max value is considered if the partX is at the end of the nums1 array which means the immediate element after the partX is nothing. So, Integer max value will be useful for comparison later for l2 <= r1. 

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n2 < n1) return findMedianSortedArrays(nums2,nums1);
        int low = 0;
        int high = n1;
        while(low <= high){
            int partX = low + (high-low)/2;
            int partY = (n1+n2+1)/2 - partX;
            double l1 = partX <=0 ? Integer.MIN_VALUE : nums1[partX-1];
            double r1 = partX >= n1 ? Integer.MAX_VALUE : nums1[partX];
            double l2 = partY <=0 ? Integer.MIN_VALUE : nums2[partY-1];
            double r2 = partY >= n2 ? Integer.MAX_VALUE : nums2[partY];
            if(l1 <= r2 && l2 <= r1){
                if((n1+n2)%2 ==0){                  // if even numbers in both the partitions which means median will be average of element from each side of the partition
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;    
                }
                else{
                    return Math.max(l1,l2);         // if odd the element left of the partition is median
                }
            }
            else if(l1 > r2){
                high = partX -1;            // Move the high towards lower side if l1 is higher than r2
            }
            else{
                low = partX + 1;        // Move the low towards higher if l2 > r1 
            }
        }
        return -1;
        
    }
}
