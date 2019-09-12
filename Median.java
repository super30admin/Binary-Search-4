class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int final1[]=new int[nums1.length+nums2.length];
        System.arraycopy(nums1, 0, final1, 0, nums1.length);
        System.arraycopy(nums2, 0, final1, nums1.length, nums2.length);  
        Arrays.sort(final1);
        if(final1.length%2==0)
            
            return ( final1[final1.length/2] + final1[final1.length/2-1] )/2.0;
            
        else
            return final1[final1.length/2];
            
            
        }
}