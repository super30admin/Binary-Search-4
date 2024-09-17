/*
Time complexity: O(log(min(m,n))) where m is the size of num1 and n is the size of num2;
Space complexity O(1) not using any extra space.
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && num2 == null && num1.length ==0 && nums2.length == 0) return 0.0;

        //get length of both arrays 
        int len1= nums1.length, len2 = nums2.length;
        // do binary search on smaller array
        if(len1 > len2)
            return findMedianSortedArrays(nums2, nums1);
        
        int left =0, right = len1;
        int partition1 =0, partition2=0;
        int maxLeft1 , maxLeft2, minRight1, minRight2 ;
        
        while(left <= right){
            //we would be trying the partitions using binary search
            partition1 = (left+ right)/2;
            //there should be equal elements in left and right side of the partitions.
            partition2 = (len1+ len2 + 1)/2 - partition1;
            
            //all the elements in the left side of the partitions should be less than all the elements 
            //of right side of the partition. so we would be checking boundary elements which are near partition
            maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1-1];
            maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2-1];
            minRight1 = (partition1 == len1) ? Integer.MAX_VALUE : nums1[partition1];
            minRight2 = (partition2 == len2) ? Integer.MAX_VALUE : nums2[partition2];
            
            /*check if all elements on the left side of partitions in both the array are smaller than all 
            the elements in the right side of the partition       
            if this holds true that means this is the correct partition */
            if(maxLeft1 <=  minRight2 && maxLeft2 <= minRight1){
                //correct partition! finding median now
                /*if there are odd elements then left partition would be having 1 extra element and which would 
                the median and that would be max of maxLeft1 and maxLeft2*/
                if( (len1+ len2) % 2 == 1)
                    return Math.max(maxLeft1, maxLeft2);
                else{
                    //if even elements then max of left boundary and min of right boundary would be contributing 
                    //for the median.. which makes sense when we imaginary sort the array and take median
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2))/2.0;
                }
                    
            }
            //reduce partition search to second half
            else if(maxLeft1 > minRight2) right = partition1 -1 ;
            //reduce partition search to first half.
            else left = partition1+1;     
        }
        return 0.0;
    }
}
