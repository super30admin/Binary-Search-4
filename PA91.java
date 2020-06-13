//Leetcode : 4. Median of Two Sorted Arrays
//Time Complexity: O(n)
//Space Co mplexity: O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       
        int len = nums1.length+nums2.length;
        int k=len/2;
        int prev=0;
        int next=0;
        int i=0;
        int n1=0;
        int n2=0;
        while(n1<nums1.length && n2<nums2.length && i<=k ){
            prev= next;
            if(nums1[n1]<nums2[n2]) {
                next=nums1[n1];
                n1++;
                
                }
            else{
                next=nums2[n2];
                n2++;
            }
            
            i++;
        }
         
        while(n2<nums2.length && i<=k){
            prev= next;
            next=nums2[n2];
            n2++;
            i++;
        }
       
        while(n1<nums1.length && i<=k){
            prev= next;
            next=nums1[n1];
            n1++;
            i++;
        }
        
      
        double result; 
        if(len%2==1){
            result=(double)next;
        }
        else{
            result = (prev+next)/2.0;
        }
        return result;
    }
}