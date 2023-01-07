//Time Complexity : For two unsorted Arrays : O(LogN) where N is the size of smaller array.
//Space Complexity : O(1)
//Did this code successfully run on Leet code :Yes
//Any problem you faced while coding this :
public class MedianOfTwoSortedArrays {
	  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	       
	        if(nums1.length > nums2.length)
	            return findMedianSortedArrays(nums2,nums1);
	        
	    
	        int n1 = nums1.length;
	        int n2 = nums2.length;
	        int low = 0;
	        int high = n1;
	        while(low <= high){
	            
	            int ptn1 = low+(high-low)/2;
	            int ptn2 = (n1 +n2)/2 - ptn1; 
	            
	            double left1 = ptn1 == 0 ?Integer.MIN_VALUE:nums1[ptn1-1];
	            double left2 = ptn2 == 0 ?Integer.MIN_VALUE:nums2[ptn2-1];
	            double right1 = ptn1==n1 ? Integer.MAX_VALUE:nums1[ptn1];
	            double right2 = ptn2==n2 ? Integer.MAX_VALUE:nums2[ptn2];
	            
	            if(left1 <= right2 && left2 <= right1){
	                
	                // in case of even 
	                
	                if((n1+n2)%2 == 0){
	               
	                    double result =  (Math.max(left1,left2) + Math.min(right1,right2) ) / 2 ; 
	                   
	                    return result;
	                }
	                else{ // in case of odd
	                    
	                    return Math.min(right1,right2);
	                }   
	            }
	            else if(left2 > right1){
	                
	                  low = ptn1+1;
	            
	            }else{
	                 high=ptn1-1;
	                
	                }
	                
	        }
	        
	        return 1.00;
	    }
}
