
//Time Complexity: O(log(min(n,m)))
//Space Complexity: O(1)

//we will apply binary search on the smaller array to find the correct partition
//we will find the partition such that all the elements on the left side of both arrays are 
//less than or equal to all the elements on the right side of both arrays. if we find such a partition then we can find the median
//if the partition is not correct then we will move the partition to left or right based on the values.
//if the left element of the first array is greater than the right element of the second array
//then we will move the partition to left in the first array.
//if the left element of the second array is greater than the right element of the first array
//then we will move the partition to right in the first array.
//if the total number of elements is even then the median is the average of the maximum of left elements
//and the minimum of right elements.
//if the total number of elements is odd then the median is the minimum of right elements.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l=0,h=nums1.length,n=nums1.length,m=nums2.length;

        if(n>m)
            return findMedianSortedArrays(nums2,nums1);
        double res=0;

        while(l<=h){
            int partX=l+(h-l)/2;
            int partY=((n+m)/2)-partX;

            double l1=partX==0?Integer.MIN_VALUE:nums1[partX-1];
            double l2=partY==0?Integer.MIN_VALUE:nums2[partY-1];
            double r1=partX==n?Integer.MAX_VALUE:nums1[partX];
            double r2=partY==m?Integer.MAX_VALUE:nums2[partY];

            if(l1<=r2 &&l2<=r1){
                if((n+m)%2==0)
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2;
                else
                    return Math.min(r1,r2);
            }

            else if(l2>r1)
                l=partX+1;
            else
                h=partX-1;
        }
        return -1;
    }
}