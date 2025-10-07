/*
* Idea is to partition the smaller array and get partX, and derive partY
    - partY is nothing but the complement of partX which can be derived using n1+n2/2 - partX
    - once we have both the partitions, we need to check if the partition is correct or not
    - if we imaging the combined array by combining both the partitions it should be sorted
    - to check that, we can keep four pointers
        - l1 - largest element of nums1 on left side of the partition
        - l2 - largest element of nums2 on left side of the partition
        - r1 - smallest element of nums1 on right side of the partition
        - r2 - smallest element of nums2 on right side of the partition
    - check if l1 <= r2 & l2 <= r1 (cross comparison because both the arrays on its own is sorted), then its correct partition
        - once the correct partition is encountered
            - for odd case:
                - median is the min of r1 and r2
            - for even case:
                - median is the avg of max of l1,l2 and min of r1,r2
    - if l1 > r2, reduce partitionX and increment partitionY move high pointer to partX
    - else, increase partitionX and reduce partitionY; move low pointer to partX + 1 
*Apply binary search on partition. In even case, right side of the partition will have one extra element than left side
* TC: O(logn1) -> where n1 is min length out of n1 and n2
* SC :O(1)
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int left = 0;
        int right = n1;

        while (left <= right) {
            int partX = left + (right - left) / 2;
            int partY = ((n1 + n2) / 2) - partX;

            int l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            int l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if(l1 <= r2 && l2 <= r1){
                //correct partition
                if((n1 + n2) % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }
                else{
                    return Math.min(r1,r2);
                }
            }
            else if(l1 > r2){
                right = partX;
            }
            else{
                left = partX + 1;
            }

        }
        return -1;
    }
}