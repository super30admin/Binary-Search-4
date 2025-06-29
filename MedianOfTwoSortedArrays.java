//Time Complexity: O(log(min(n1, n2)))
//Space Complexity: O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }
        int low  = 0;
        int high = n1;
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (n1+n2)/2 - partX;
            double x1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            double y1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double x2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            double y2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            if(x1 <= y2 && x2 <=y1){
                //correct partition
                if((n1+n2)%2 == 0){
                    //even length
                    return (Math.min(y1,y2) + Math.max(x1,x2))/2;
                }else{
                    //odd length
                    return Math.min(y1, y2);
                }
            }else if(x1 > y2){
                high = partX-1;
            }
            else{
                low = partX +1;
            }
        }
        return 3.00;
    }
}