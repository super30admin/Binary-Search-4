//Time Complexity: O(log m) where m is the smaller array
//Space Complexity: O(1)

class findMedianSorted {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null)
            return 0.0;
        
        int m = nums1.length, n = nums2.length;
        
        if(m == 0 && n == 0)
            return 0.0;
        
        //we want to perform binary search on smaller array to reduce time complexity
        //the larger array will play no role in time complexity because partY calculate by equation
        if(m > n)
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0, high = m;
        int partX = 0, partY = 0;
        
        
        while(low <= high){
            //partition both arrays so left and right sides are even when both combined
            //partX is the mid value of small array
            partX = low + (high - low) / 2;
            //partY is calculated with equation using partX
            partY = (m + n) / 2 - partX;
            
            //both l vars are left of partitions
            int l1 = partX == 0? Integer.MIN_VALUE: nums1[partX - 1];
            int l2 = partY == 0? Integer.MIN_VALUE: nums2[partY - 1];
            
            //both r vars are right of partitions
            int r1 = partX == m? Integer.MAX_VALUE: nums1[partX];
            int r2 = partY == n? Integer.MAX_VALUE: nums2[partY];
            
            //check conditions to make sure all left is smaller than right
            if(l1 <= r2 && l2 <= r1){
                
                //odd
                if((m + n)%2 != 0){
                    return Math.min(r1, r2);
                }
                //even
                else{
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                }
            }
            else if(l2 > r1){
                low = partX + 1;
            }
            else
                high = partX - 1;
            
        }
        return 0.0;
    }
}