// Time Complexity: O(log min(n1, n2))
// Space Complexity: O(1)
// Run on leetcode: yes
// Problems faced: None

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0;
        int high = n1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            int Py = (n1 + n2)/2 - mid;
            double L1 = mid == 0 ? Integer.MIN_VALUE : nums1[mid - 1];
            double R1 = mid == n1 ? Integer.MAX_VALUE : nums1[mid];
            double L2 = Py == 0 ? Integer.MIN_VALUE : nums2[Py - 1];
            double R2 = Py == n2 ? Integer.MAX_VALUE : nums2[Py];
            if(L1 <= R2 && L2 <= R1){
                if((n1+n2)%2 == 0){
                    return (Math.max(L1, L2)+Math.min(R1, R2))/2;
                }
                else{
                    return Math.min(R1, R2);
                }
            }
            else if(L1 > R2){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return 0.00;
    }
}
