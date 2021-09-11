// TC = O(logm)
//SC - O(1)
public class findMedianSortedArrays {
    
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            
            if ( nums1.length == 0 && nums2.length == 0 ){
                return 0.0;
            }
            int n1 = nums1.length;
            int n2 = nums2.length;
            
            if ( n1 > n2) {
                return findMedianSortedArrays( nums2, nums1) ;
            }
            int low = 0 ;int  high = n1;
            while ( low <= high){
                int partx = low + (high -low) /2 ;
                int party = ( n1 + n2)/2 - partx;
                double l1 = partx == 0 ? Integer.MIN_VALUE:nums1[partx - 1];
                double l2 = partx == n1 ? Integer.MAX_VALUE:nums1[partx];
                double r1 = party == 0 ? Integer.MIN_VALUE:nums2[party-1];
                double r2 = party == n2 ? Integer.MAX_VALUE:nums2[party];
                
                if (l1 <= r2 && r1 <= l2 ){
                    if((n1 + n2)% 2 != 0){
                        return Math.min(l2,r2);
                    }
                    return (Math.max( l1,r1) + Math.min(l1,r2)) / 2;
                    
                }
                else if ( l1 > r2){
                    high = partx -1 ;
                }else {
                    low = partx + 1 ;
                }
            }
            return 0.0;
        }
    }
}
