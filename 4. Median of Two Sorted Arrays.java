class Solution {// time of O(lg (min array length)) and space constant
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int aLen = nums1.length; 
        int bLen = nums2.length;
        if(aLen > bLen){
            return findMedianSortedArrays(nums2,nums1);
            //makeing first array as shorter
        }
        int left = 0 , right = aLen;
        int cutA , cutB;
        int maxLeftA , minRightA;
        int maxLeftB , minRightB;
        
        while(left<= right){
            cutA = left + (right - left)/2 ; 
            cutB = (aLen + bLen + 1 )/2 - cutA ;
            if(cutA == 0){
                maxLeftA = Integer.MIN_VALUE ;
            }else{
                maxLeftA = nums1[cutA - 1];
            }
            if(cutA == aLen){
                minRightA = Integer.MAX_VALUE;
            }else{
                minRightA = nums1[cutA];
            }
            if(cutB == 0){
                maxLeftB = Integer.MIN_VALUE ;
            }else{
                maxLeftB = nums2[cutB - 1];
            }
             if(cutB == bLen){
                minRightB = Integer.MAX_VALUE;
            }else{
                minRightB = nums2[cutB];
            }
            //Check whether we find correct partition
            if(maxLeftA <= minRightB &&  maxLeftB <= minRightA ){
                if((aLen + bLen) % 2 == 0 ){
                    return (Math.max(maxLeftA,maxLeftB) + Math.min(minRightA,minRightB))/2.0 ;
                }
                else{
                    return Math.max(maxLeftA,maxLeftB) ;
                }
            }
            else if(maxLeftA > minRightB){
                right = cutA - 1;
            }else{
                left = cutA + 1;
            }
        }
        return 0.0;
    }
}