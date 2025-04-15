//The idea is to use partitions to find the median of two arrays without using any extra space. 
//We then check if the partitions are valid by comparing the left and right elements of partX and partY along with comparing the right and left elements of partX and partY respectively.
//We perform the Binary Search till we get a valid partition.
//We then return the median based on the length of the combined array.
//Time Complexity: O(min(n1,n2)) where n1 and n2 are lengths of arrays nums1 and nums2
//Space Complexity: O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null){
            return 0.0;
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = n1;
        while(low <= high){ // Performing Binary Search on partitions, not numbers
            int partX = low + (high - low) / 2;
            int partY = (n1+n2) / 2 - partX;
            int L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            int L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            if(L1 <= R2 && L2 <= R1){
                if((n1 + n2)%2 != 0) return Math.min(R1,R2);
                else {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) /2.0;
                }
            }
            else if(L1 > R2){
                high = partX - 1;
            }
            else{
                low = partX + 1;
            } 
        }
        return 7d;//just a random value as the code never reaches here
    }
}