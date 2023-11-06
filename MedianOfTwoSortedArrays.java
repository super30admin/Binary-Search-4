class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0) return 0.0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int low = 0;
        int high = nums1.length;
        while(low <= high){
        int partx = (low + (high - low )/2);

        int party = (nums1.length + nums2.length)/2 - partx;

        double L1 = partx == 0 ? Integer.MIN_VALUE : nums1[partx - 1];
        
        double L2 = party == 0 ? Integer.MIN_VALUE : nums2[party-1];
     
        double R1 = partx == nums1.length ? Integer.MAX_VALUE : nums1[partx];
        double R2 = party == nums2.length ? Integer.MAX_VALUE : nums2[party];

        if((L1 <= R2) && (L2 <= R1)){
            int size = nums1.length + nums2.length;
            if(size % 2 == 0){
                 return ( Math.min(R1,R2) + Math.max(L1,L2) )/2;
           
            }
            else{
                return Math.min(R1,R2);
            }
        }
        else if(L1 > R2){
            high = partx -1;
        }
        else{
            low = partx + 1;
        }


        }

        return 0;

        



    }
}



/**
 * 
 * We need to combine both arrays and sort and find the median → If it's odd then the middle number is the median and if it's even avg both middle numbers to find the median. 
 *
   In bruteforce, if we are merging 2 arrays it will take O max(n1,n2).

   In optimized, doing partition with binary search

   TC : O(logk) → Bcz we are only doing binary search for the smallest array among both arrays.
 * 
 */