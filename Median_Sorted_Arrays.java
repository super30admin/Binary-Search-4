/*For binary search 
How to find partition:
1. We do normal partition for (len1<len2) nums1 array
if(l2>=r1)
l2 = mid+1;
else

2. partY = (m+n/2)- partX;
3.For valid partition: 
l1 <= r2
l2 <= r1 
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     int len1 = nums1.length;
     int len2 = nums2.length;
        if(len1 > len2)return findMedianSortedArrays(nums2,nums1);
     int low = 0;
     int high = len1;
        while(low <= high){
            int partX = low +(high-low)/2;
            int partY = (len1 + len2)/2 - partX;
            
            double left1 = partX == 0?      Integer.MIN_VALUE : nums1[partX - 1];
            double left2 = partY == 0?      Integer.MIN_VALUE : nums2[partY - 1];
            double right1 = partX == len1?   Integer.MAX_VALUE : nums1[partX ];
            double right2 = partY == len2?   Integer.MAX_VALUE : nums2[partY ];
         
            if(left1 <= right2 && left2 <= right1){
             if((len1+ len2)% 2 == 1)return(Math.min(right1,right2));
             else return((Math.max(left1,left2)+ Math.min(right1,right2))/2);
         }
            else if(left2>right1) low = partX + 1;
            else high = partX - 1;
        }
        return -1;
    }
}