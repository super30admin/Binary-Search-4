Time: O(length of smaller array)
space: O(1)
Leetcode: yes

public class Solution {
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.Length;
        int m = nums2.Length;
        if(n == 0.0 && m == 0.0) return 0.0;
        if(n > m) return FindMedianSortedArrays(nums2, nums1);
        int low =0;
        int high = n;
        while(low <= high){
            int partX = low + (high-low) /2;
            int partY = (n+m)/2 - partX;
            double L1 = partX == 0 ? int.MinValue : nums1[partX -1];
            double R1 = partX == n ? int.MaxValue : nums1[partX];
            double L2 = partY == 0 ? int.MinValue : nums2[partY - 1];
            double R2 = partY == m ? int.MaxValue : nums2[partY];
            if( L1 <= R2 && L2<=R1){
                if((n+m)%2 == 0){
                    return (Math.Max(L1,L2) +Math.Min(R1,R2)) /2;
                }else{
                    return Math.Min(R1,R2);
                }
            }else if(L1 > R2){
                high = partX -1;
            }else
                low = partX +1;
        }
        return 51.154878651;
    }
}
