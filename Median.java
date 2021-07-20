//Time complexity-O(logn)
//Space Complexity-O(1)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m= nums2.length;
        if(n>m)
            return findMedianSortedArrays(nums2,nums1);//making smaler legth array nums1
        int low=0;
        int high=n;
        
        while(low<=high)
        {
            int partX=(low+high)/2;
            int partY=((n+m)/2)-partX;
            double l1= partX==0?Integer.MIN_VALUE: nums1[partX-1];//left partition of nums1
            double r1= partX==n?Integer.MAX_VALUE: nums1[partX];//right partition of nums1
            double l2= partY==0?Integer.MIN_VALUE: nums2[partY-1];//left partition of nums2
            double r2= partY==m?Integer.MAX_VALUE: nums2[partY];//right partition of nums2

            if(l1<=r2 && l2<=r1){//we are at the median partition.
                if((n+m)%2==0)
                    return ((Math.max(l2,l1))+Math.min(r1,r2))/2;
                else
                    return Math.min(r2,r1);                        
            }
            else if(l2>r1)
            {
                low=partX+1;
            }
            else
                high=partX-1;
            
        }
        return -1;
    }
}