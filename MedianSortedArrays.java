//Time Complexity :O(M+N).
//Space Complexity :O(M+N).
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach

class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int res[] = new int[A.length+B.length];
        int i = 0, j = 0, k = 0;
        while(i < A.length && j < B.length){
            if(A[i] < B[j]){
                res[k++] = A[i++];
            }else{
                res[k++] = B[j++];
            }
        }
        while(i < A.length){
            res[k++] = A[i++];
        }
        while(j < B.length){
            res[k++] = B[j++];
        }
        int N = res.length;
        if(0 == N % 2){
            return (res[N/2] + res[N/2-1])/2.0;
        }else{
            return res[N/2];
        }
    }
}