//Accepted on LT
//Idea is to do bs on partition
//time should be O(log(n1+n2))
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length ==0) return 0.0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int l = 0;
        int h = n1;
        while(l<=h){
            int px = l+ (h-l)/2;
            int py = (n1+n2)/2 - px;
            int l1 = px==0? Integer.MIN_VALUE : nums1[px-1];
            int l2 = py==0? Integer.MIN_VALUE : nums2[py-1];
            int r1 = px == n1?Integer.MAX_VALUE : nums1[px];
            int r2 = py == n2?Integer.MAX_VALUE : nums2[py];
            if(l1<=r2 && l2 <=r1){
                if((n1+n2)%2==0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }
                else{
                    return Math.min(r1,r2);
                }
            }
            else if(l2>r1){
                l = px+1;
            }
            else{
                h  = px-1;
            }
        }
        return 121.231;
        
    }
}