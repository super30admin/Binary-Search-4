class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
return findMedianSortedArrays(nums2, nums1);}
int nums1Len = nums1.length;
int nums2Len = nums2.length;
int n = nums1Len + nums2Len;
int halfN= n/2;
int s=0, e = nums1Len;
while(s<= e) {
int nums1Eles = s+ (e-s)/2;
int nums2Eles=halfN-nums1Eles;
int l1 = nums1Eles==0 ? Integer.MIN_VALUE: nums1[nums1Eles-1];
int l2 = nums2Eles==0 ? Integer.MIN_VALUE: nums2 [nums2Eles-1];
int r1 = nums1Eles== nums1Len ? Integer.MAX_VALUE: nums1[nums1Eles];
int r2 = nums2Eles== nums2Len ? Integer.MAX_VALUE: nums2[nums2Eles];
double one = Math.max (l1, l2);
double two = Math.min(r1, r2);
if(one<= two) {
if(n%2 == 0) {
    return (one+two)/2;
}
return Math.min(r1, r2);
} else if(l1 > r2) {
e = nums1Eles-1;
} else {
    s = nums1Eles+1;
}
}
return 0;}}
//tc=O(m+n)
//sc=O(1)
