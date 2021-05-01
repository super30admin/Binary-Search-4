//median of two sorted array
//tc - O(log(m,n))
///sc- O(1)

public class Problem2 {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        Problem2 p = new Problem2();
        System.out.println(p.findMedianSortedArrays(nums1,nums2));

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n > m){
            return findMedianSortedArrays(nums2, nums1);
        }
        //make partition
        int low = 0, high = n;
        while(low <= high){
            int partX = low + (high-low)/2;
            int partY = (m+n)/2-partX;
            //make sure partX has all lower elements,& partY has larger ele
            
            double l1 = partX == 0 ?Integer.MIN_VALUE : nums1[partX-1];
            double l2 = partY == 0 ? Integer.MIN_VALUE: nums2[partY-1];
            double r1 = partX == n ? Integer.MAX_VALUE : nums1[partX];
            double r2 = partY == m ? Integer.MAX_VALUE : nums2[partY];
            
            if(l1 <= r2 && l2 <= r1){
                //check if even or odd
                if((m+n) %2 ==0){
                    return (Math.max(l1,l2)+ Math.min(r1,r2))/2;
                }
                else{    //if odd
                    return Math.min(r1,r2);
                }
            }
            else if(l1 > r2){
                high = partX-1;
            }
            else{   //move towards right side   
                low = partX+1;
            }
        }
        
        return -1;
        
        
    }
    
}
