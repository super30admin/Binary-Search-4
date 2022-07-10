class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=0;
        int l2=0;
        int m=nums1.length;
        int n=nums2.length;
        double median=0;
        int[] temp=new int[m+n];
        int k=0;
     while ( l1< m && l2 < n) {
      if (nums1[l1] <= nums2[l2]) {
        temp[k++] = nums1[l1++];
      } else {
        temp[k++] = nums2[l2++];
       
      }
    }

    // When we run out of elements in either L or M,
    // pick up the remaining elements and put in A[p..r]
    while (l1 < m) {
      temp[k++] = nums1[l1++];
      
    }

    while (l2 < n) {
      temp[k++] = nums2[l2++];
    }
  
        for(int j:temp){
            System.out.print(j);
        }
        if((m+n)%2==0){
            // length is 4..get 1 and 2 index 
            median=(double)(temp[(m+n)/2-1]+temp[(m+n)/2])/2;
        }
       else 
           median=(double)temp[(m+n)/2];
 
     return median;      
}
}
