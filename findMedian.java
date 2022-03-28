// 1,2,3,4 
// 5,6,7


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        int t = n1 + n2;
        
        
        if (n1 > n2)
        {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int halfEles = t / 2;
        int s = 0;
        int end = n1;
        
        while(s <= end)
        {
            int partAsize = s + (end - s) / 2;
            int partBsize = halfEles - partAsize;
            
            int l1 = partAsize == 0 ? Integer.MIN_VALUE : nums1[partAsize - 1];
            int l2 = partBsize == 0 ? Integer.MIN_VALUE : nums2[partBsize - 1];
            
            int r1 = partAsize == n1 ? Integer.MAX_VALUE : nums1[partAsize];
            int r2 = partBsize == n2 ? Integer.MAX_VALUE : nums2[partBsize];
            
            if (l1 <= r2 && l2 <= r1)
            {
                if (t % 2 == 0)
                {
                    return (Math.max(l1,l2) + Math.max(r1, r2)) / 2.0 ;
                }
                else
                {
                    return Math.min(r1,r2);
                }
            }
            else if (l1 > r2)
            {
                end = partAsize - 1;
            }
            else
            {
                s = partAsize + 1;
            }   
        }
        
        return -1;
    }
}
