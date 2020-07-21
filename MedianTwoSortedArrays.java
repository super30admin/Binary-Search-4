
//TimeComplexity :O(logmin(m,n)
//Space Complexity :O(1);
//Did it run on leetcode : yes
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         
       
        if(nums1.length > nums2.length)
         return findMedianSortedArrays(nums2,nums1);
                                           
       int n1 = nums1.length;   
       int n2 = nums2.length;
       int low =  0; 
       int high = n1;
       
                                                                    
       while(low <= high){
            int partX = low + (high -low)/2;    
            int partY = (1+n1+n2)/2 - partX; 
           // System.out.println("partX "+partX);
           // System.out.println("partY " +partY);
           double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
           double l2  = partY==0 ? Integer.MIN_VALUE : nums2[partY-1];
           double r1 = partX ==n1 ? Integer.MAX_VALUE : nums1[partX];
           double r2  = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
         
               
           if( l1 > r2){
               high = partX -1;
           }
           else if(r1 < l2){
               low = partX +1 ;
               
           }
           else{
               if((n1+n2) % 2 == 0 ){
                 return (Math.max(l1,l2)+  Math.min(r1,r2))/2; 
               }
               else{  
                   return Math.max(l1 ,l2);
               }
               
           }
                
    }
        return 0;
}
}





