//Time complexity:O(log m) m=smaller array
//Space complexity:O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int low=0;
        int high=nums1.length;
        while(low<=high){
            int partX=low+(high-low)/2;
            int partY=(n1+n2+1)/2 - partX;
            double l1=Integer.MIN_VALUE;
            double l2=Integer.MIN_VALUE;
            double R1=Integer.MAX_VALUE;
            double R2=Integer.MAX_VALUE;
            if(partX!=0){
                l1=nums1[partX-1];
            }
            if(partX!=nums1.length){
                R1=nums1[partX];
            }
            if(partY!=0){
                l2=nums2[partY-1];
            }
            if(partY!=nums2.length){
                R2=nums2[partY];
            }
            
            if(l1<=R2 && l2<=R1){
                if((n1+n2)%2!=0){
                    System.out.println("odd" + l1 + " " + l2 + " " + R1 + " " + R2);
                    return Math.max(l1,l2);
                }
                else{
                    System.out.println("even" + l1 + " " + l2 + " " + R1 + " " + R2);
                    return (Math.max(l1,l2)+Math.min(R1,R2))/2;
                }
            }
            else if(l1>R2){
                high=partX-1;
            }
            else{
                low=partX+1;
            }
        }
    
    return -1;
    }
}