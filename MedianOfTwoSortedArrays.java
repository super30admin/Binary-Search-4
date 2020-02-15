//Time Complexity : O(log n) - n is the length of the smallest array

//Space Compexity : O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if(n1 > n2) return findMedianSortedArrays(nums2,nums1);
        
        int low = 0;
        int high = n1;
        
        while(low <= high){
            //Find the partitionX
            int partX = low + (high - low) / 2;
            //Find the partitionY
            int partY = (n1+ n2 +1)/2-partX;
            
            //Find elements on either side of the partition for X
            double l1 = (partX == 0) ? Integer.MIN_VALUE : nums1[partX - 1];            
            double r1 = (partX == n1) ? Integer.MAX_VALUE : nums1[partX];
            
            //Find elements on either side of the partition for Y
            double l2 = (partY == 0) ? Integer.MIN_VALUE : nums2[partY - 1];            
            double r2 = (partY == n2) ? Integer.MAX_VALUE : nums2[partY];
            
            if(l1<=r2 && l2<=r1){ //Correct Partition
                //Even numbers
                if((n1+n2)%2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }
                //Odd numbers
                else{
                    return Math.max(l1,l2);
                }
            }
        
            else{
                if(l1 > r2){   //Move high pointer to make the value smaller
                    high = partX - 1;
                }
                else{ //Move low pointer to make the value bigger
                    low = partX + 1;
                }
            }
            
        }
        
        return -1.0000;
        
    }
}