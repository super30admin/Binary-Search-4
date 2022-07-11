// Time Complexity : O(min(n1,n2))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//4. Median of Two Sorted Arrays
//https://leetcode.com/problems/median-of-two-sorted-arrays/


class Solution {
    //time:O(min(n1,n2))
    //space:O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        double median = 0.0000;
        
        if(n1 == 0){
            if((n2)%2 == 0){
                    //even case
                        int midd = n2/2; 
                        double r11 = nums2[midd-1];
                        double r22 = nums2[midd];
                        double res = (r11+r22)/2;
                        return res; //System.out.println("median even " + median);
                        
                    }else{
                    //odd case
                        double res = nums2[n2/2];
                        return res; //System.out.println("median odd " + median);
                        
                    }
        }
        if(n2 == 0){
            if((n1)%2 == 0){
                    //even case
                        int midd = n1/2;
                        double r11 = nums1[midd-1];
                        double r22 = nums1[midd];
                        double res = (r11+r22)/2;
                        return res; //System.out.println("median even " + median);
                        
                    }else{
                    //odd case 
                        double res = nums1[n1/2];
                        return res; //System.out.println("median odd " + median);
                        
                    }
        }
        
        if(n1<=n2){
            //do BS on n1
            //find Xp which is where mid is at
            //then find Yp and set l1, l2, r1, r2
            //check l1 and l2 conditons
            //if l1 < r2 and l2 < r1 then calculate the median for odd and even respectively
            //if l1 > r2, high = mid-1 and do all the above again
            //if l2 > r1, low = mid + 1 and do all the above again
            int low = 0; int high = n1; //n1 and not n1-1 because we are doing it on the partition
            while(low <= high){
                
                int mid = low + (high-low)/2;
                int Xp = mid; //System.out.println("Xp mid " + Xp);
                int Yp = (n1+n2)/2 - Xp; //System.out.println("Yp " + Yp);
                
                double l1 = Xp == 0 ? Integer.MIN_VALUE : nums1[Xp-1];
                double r1 = Xp == n1 ? Integer.MAX_VALUE : nums1[Xp];
                double l2 = Yp == 0 ? Integer.MIN_VALUE : nums2[Yp-1];
                double r2 = Yp == n2 ? Integer.MAX_VALUE : nums2[Yp];
                
                 // System.out.println("l1 " + l1); System.out.println("l2 " + l2);
                 // System.out.println("r1 " + r1); System.out.println("r2 " + r2);
                
                if(l1 <= r2 && l2 <= r1){
                    if((n1+n2)%2 == 0){
                    //even case 
                        median = (Math.min(r1,r2)+Math.max(l1,l2))/2; //System.out.println("median even " + median);
                        break;
                    }else{
                    //odd case
                        median = Math.min(r1,r2); //System.out.println("median odd " + median);
                        break;
                    }
                }else if(l1 > r2){
                    
                    high = mid-1;
                    
                }else if(l2 > r1){
                    
                    low = mid+1;
                } 
            }
             
         }else{
            //do BS on n2
            int low = 0; int high = n2;
            while(low <= high){
                
                int mid = low + (high-low)/2;
                int Xp = mid;
                int Yp = (n1+n2)/2 - Xp;  //System.out.println("Xp mid " + Xp); System.out.println("Yp " + Yp);
                
                 double l1 = Xp == 0 ? Integer.MIN_VALUE : nums2[Xp-1];
                double r1 = Xp == n2 ? Integer.MAX_VALUE : nums2[Xp];
                double l2 = Yp == 0 ? Integer.MIN_VALUE : nums1[Yp-1];
                double r2 = Yp == n1 ? Integer.MAX_VALUE : nums1[Yp];
                 
                // System.out.println("l1 " + l1); System.out.println("l2 " + l2);
                // System.out.println("r1 " + r1); System.out.println("r2 " + r2);
                
                if(l1 <= r2 && l2 <= r1){
                    if((n1+n2)%2 == 0){
                    //even case 
                        median = (Math.min(r1,r2)+Math.max(l1,l2))/2; //System.out.println("median even " + median);
                        break;
                    }else{
                    //odd case
                        median = Math.min(r1,r2); //System.out.println("median odd " + median);
                        break;
                    }
                }else if(l1 > r2){
                    
                    high = mid-1;
                    
                }else if(l2 > r1){
                    
                    low = mid+1;
                } 
            }
            
        }
        return median;
    }
}
