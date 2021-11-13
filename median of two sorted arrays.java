//Timecomplexity:-O(log(min(m,n));
//space complexity:- O(1);
//Did it run on leetcode:- yes.
//What problems did you face?- faced many runtime errors.
//Your code with approach:- partitioning such that there will be equal sizes of elements on either side and how many elements needed to be taken is decided in binary search.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        
        if(n>m){
            return findMedianSortedArrays(nums2,nums1);
        }
        int low=0;
        int high=n;
        while(low<=high){
            int partx= low+(high-low)/2;
            int party=(n+m)/2-partx;
            int l1= partx==0? Integer.MIN_VALUE :nums1[partx-1];
            int r1= partx==n? Integer.MAX_VALUE:nums1[partx];
            
            int l2= party==0? Integer.MIN_VALUE:nums2[party-1];
            int r2= party==m? Integer.MAX_VALUE:nums2[party];
            if(l1<=r2 &&l2<=r1){
                if((m+n)%2!=0){
                    double median=Math.min(r1,r2);
                    return median;
                }
                else{
                    double median1=(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                    return median1;
                }
            }
            else if(l2>r1){
                low=partx+1;
            }
            else{
                high=partx-1;
                
            }
        } 
        
return -1;}
}