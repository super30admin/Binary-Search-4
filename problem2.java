// 4 Median of Two sorted Arrays
// solved on Leetcode
// Time complexity : O(log(n1))
// Space Complexity : O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1==0 && n2==0){
            return 0.0;
        }
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);
        }
        
        int low = 0;
        int high = nums1.length;
        
        while(low<=high){
            int mid1 = low + (high-low)/2;
            int mid2 = (n1+n2)/2 - mid1;
            
            double l1 = mid1 ==0 ? Integer.MIN_VALUE: nums1[mid1-1];
            double r1 = mid1 == n1 ? Integer.MAX_VALUE : nums1[mid1];
            double l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2-1];
            double r2 = mid2 == n2 ? Integer.MAX_VALUE : nums2[mid2];
            
            if(l1<=r2 && l2<=r1){
                
                if((n1+n2)%2==0){
                    return (Math.max(l1,l2)+ Math.min(r1,r2))/2;
                }else{
                    return Math.min(r1,r2);
                }
            }else if(l1>r2){
                high=mid1-1;
            }else{
                low = mid1+1;
            }
        }
        
        return 34.0;
    }
}