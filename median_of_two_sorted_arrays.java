//TC: O(logn)
//SC: O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int m = nums2.length;
        if(n ==0 && m==0) return 0.0;  //null case
        if(n>m) return findMedianSortedArrays(nums2,nums1);  //considering first array as the smaller one
        int low =0;
        int high= n;  //partitions are from 0 to n
        
        while(low<=high){
            int partX = low+(high-low)/2;
            int partY = ((n+m)/2) - partX;
            double L1 = partX ==0 ? Integer.MIN_VALUE : nums1[partX-1];
            double R1 = partX == n ? Integer.MAX_VALUE : nums1[partX];
            double L2 = partY ==0 ? Integer.MIN_VALUE : nums2[partY-1];
            double R2 = partY == m ? Integer.MAX_VALUE : nums2[partY];
            if(L1 <= R2 && L2 <= R1){
                //correct partition
                if((n+m)%2 == 0){   //if there are even no. of elements 
                    return (Math.max(L1,L2) + Math.min(R1,R2))/2;
                }else{   //odd no. of elements
                    return Math.min(R1,R2);
                }
                
            }else if(L1 > R2){   
                high = partX-1;
            }else{
                low = partX+1;
            }
        }
        return 7.88;
    }
}
