// tc : O(log(m+n))
// sc : O(log(m+n)) //memory stack space  


class Solution {
    public double findMedianSortedArrays(int[] n1, int[] n2) {
        int m = n1.length, n = n2.length;
        int l = (m+n+1)/2;
        int r = (m+n+2)/2;
        return (helper(n1,0,n2,0,l)+helper(n1,0,n2,0,r))/2.0;
    }

    private int helper(int[] n1, int as, int[] n2, int bs, int k){
        if(as>=n1.length) return n2[bs+k-1];
        if(bs>=n2.length) return n1[as+k-1];
        if(k==1) return Math.min(n1[as],n2[bs]);

        int am =  Integer.MAX_VALUE;
        int bm = am;
        if(as+k/2-1 < n1.length) am = n1[as+k/2-1];
        if(bs+k/2-1 < n2.length) bm = n2[bs+k/2-1];

        if(am<bm) return helper(n1, as+k/2 , n2 , bs , k-k/2);
        else return helper(n1, as, n2, bs+k/2, k-k/2);

    }
}
