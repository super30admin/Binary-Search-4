
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//# Binary-Search-4



//## Problem1 
//Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)
class Solution1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)
            return new int[0];
        if(nums1.length < nums2.length)
            return intersect(nums2, nums1);
        int m = nums1.length; int n = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0;
        int high = m-1;
        List<Integer> li = new ArrayList<>();
        for(int i=0; i < n; i++) {
            int bindex = Binarysearch(nums1, low, high, nums2[i]);
            if(bindex != -1) {
                low = bindex + 1;
                li.add(nums2[i]);
            }
        }
        int[] result = new int[li.size()];
        for(int k = 0; k < result.length; k++)
            result[k] = li.get(k); 
        return result;
    }
    private int Binarysearch(int[] nums1, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums1[mid] == target) {
                if(mid == low || nums1[mid-1] < nums1[mid])
                    return mid;
                else
                    high = mid-1;
            }
            else if(nums1[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
}


//## Problem2
//Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return 0.0;
        int n1 = nums1.length; int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = n1;
        while(low <= high) {
            int partX = low + (high-low)/2;
            int partY = (n1 + n2)/2 - partX;
            double L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            if(L1 <= R2 && L2 <= R1) {
                if((n1 + n2)%2 == 0)                        //it is even
                    return (Math.max(L1, L2) + Math.min(R1, R2))/2;
                else                                        //it is odd
                    return Math.min(R1, R2);
            }
            else if(L2 > R1)
                low = partX + 1;
            else high = partX -1;
        }
        return 1.0;
    }
}
