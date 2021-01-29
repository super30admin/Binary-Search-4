/*
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        if nums1 is None or nums2 is None:
            return 0
        
        n1, n2 = len(nums1), len(nums2)
        
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        
        low , high = 0, n1
        
        while low <= high:              # assuming to extreme left is -infity and extreme right is +infinity
            partx = low + (high-low)//2
            party = (n1+n2)//2 -partx
            
            l1 = float('-inf') if partx - 1 < 0 else nums1[partx-1]
            l2 = float('-inf') if party - 1 < 0 else nums2[party-1]
            r1 = float('inf') if partx == n1 else nums1[partx]
            r2 = float('inf') if party == n2 else nums2[party]
            
            if l1 <= r2 and l2 <= r1:
                # even
                if (n1+n2) % 2 == 0:
                    return (max(l1,l2) + min(r1,r2))/2
                # odd
                return min(r1,r2)
            
            elif l1 > r2:
                high = partx - 1
                
            else:
                low = partx + 1
*/

// Time - O(min(logn, logm)) where n and m is size of two lists
// Space - O(1)
// Logic - Based on the fact that if two arrays are merged and sorted then all elements to left of median are smaller than median and to
// the right are bigger than median

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return 0;
        int n1 = nums1.length, n2 = nums2.length;
        
        if (n1 > n2) // to maintain smaller array in n1
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0, high = n1;
        while (low <= high){
            int partx = low + (high  - low)/2;
            int party = (n1+n2)/2 - partx;
            
            double l1 = partx - 1 < 0? Integer.MIN_VALUE: nums1[partx-1];
            double l2 = party - 1 < 0? Integer.MIN_VALUE: nums2[party-1];
            double r1 = partx == n1? Integer.MAX_VALUE: nums1[partx];
            double r2 = party == n2? Integer.MAX_VALUE: nums2[party];
            
            if (l1 <= r2 && l2 <= r1){
                //even
                if ((n1+n2)%2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }
                // odd
                return Math.min(r1,r2);
            }
            else if (l1 > r2){
                high = partx - 1;
            }
            else{
                low = partx + 1;
            }
                
        }
        return -10;
    }
}