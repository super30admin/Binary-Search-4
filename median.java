//Runtime complexity - O(log(min(m,n))).
// Space complexity - O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        return (get_k_element(nums1,nums2,(m+n+1)/2,0,m,0,n)+get_k_element(nums1,nums2,(m+n+2)/2,0,m,0,n))/2.0;
    }
    
    private double get_k_element(int[] A,int[] B,int k,int s1,int A_rem,int s2, int B_rem)
    {  
        if(A_rem>B_rem)
            return get_k_element(B,A,k,s2,B_rem,s1,A_rem);
        if(A_rem==0)
            return B[s2+k-1];
        if(k==1)
            return Math.min(A[s1],B[s2]);
        int i=Math.min(A_rem,k/2);
        int j=Math.min(B_rem,k/2);
        if(A[s1+i-1] < B[s2+j-1])
        {
            return get_k_element(A,B,k-i,s1+i,A_rem-i,s2,B_rem);
        }
        else
        {
            return get_k_element(A,B,k-j,s1,A_rem,s2+j,B_rem-j);
        }
    }
}


/*

 public double findMedianSortedArrays(int[] A1, int[] A2) {
        int m = A1.length, n = A2.length;
        int mid1 = (m + n + 1) / 2, mid2 = (m + n + 2) / 2;
        return (findKth(A1, 0, m, A2, 0, n, mid1) + findKth(A1, 0, m, A2, 0, n, mid2)) / 2;
    }
    
    private double findKth(int[] A1, int s1, int m, int[] A2, int s2, int n, int k) {
        if (m > n) return findKth(A2, s2, n, A1, s1, m, k);
        if (m == 0) return A2[s2 + k - 1];
        if (k == 1) return Math.min(A1[s1], A2[s2]);
        
        int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
        if (A1[s1 + i - 1] < A2[s2 + j - 1]) {
            return findKth(A1, s1 + i, m - i, A2, s2, n, k - i);
        } else {
            return findKth(A1, s1, m, A2, s2 + j, n - j, k - j);
        }
    }*/
