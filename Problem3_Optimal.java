/**
Leet Code Submitted : YES
Space Complexity : O(1)
Time Complexity : O(Minimum length of two arrays)

 
Partition arrays into two parts such that we will compare left of the partition of first array with right pointer of partition of second array. Also, compare left of partition of second array with right of partition of first array. Once, they are less then thats the median. if left of partition of first array is greater than right of partition of second array increase high to partititon_x - 1 otherwise low to partitition_x + 1. 
**/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { 
        int first  = nums1.length;
        int second = nums2.length;
        
        if(first > second){
            return findMedian(nums2,nums1); 
        }else{
            return findMedian(nums1,nums2);
        }
        
    }
    
    private double findMedian(int[] nums1, int[] nums2){
        int first  = nums1.length;
        int second = nums2.length;
        
        int low  = 0;
        int high = first;
        
        while(low <= high){
            int partition_x = low + (high - low)/2;
            int partition_y = (first + second + 1)/2 - partition_x;
            
            double l1;
            double r1;
            if(partition_x == 0)
                l1 = Integer.MIN_VALUE;
            else
                l1 = nums1[partition_x - 1];
            
            if(partition_x == first)
                r1 = Integer.MAX_VALUE;
            else
                r1 = nums1[partition_x];
            
            double l2;
            double r2;
            
            if(partition_y == 0)
                l2 = Integer.MIN_VALUE;
            else
                l2 = nums2[partition_y - 1];
                
            if(partition_y == second)
                r2 = Integer.MAX_VALUE;
            else
                r2 = nums2[partition_y];
            
            
            if(l1 <= r2 && l2 <= r1){
                if((first + second) % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2d;
                }else{
                    return Math.max(l1,l2);
                }
            }else if(l2>r1){
                low = partition_x + 1;
            }else{
                high = partition_x - 1;
            }
            
        }
        
        return -1;
    }
}
