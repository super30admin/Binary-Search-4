//TC: (m+n)log(m+n)
//SC: O(1)

public class median_sorted_arrays {
    class Solution {
        public double findMedianSortedArrays(int[] a1, int[] a2) {
            int m = a1.length, n = a2.length, len = m + n;
            int k = len / 2;
            int x = find(a1, a2, 0, 0, k+1);
            if (len % 2 == 1) return (double) x;
    
            return ((double) x + find(a1, a2, 0, 0, k)) / 2;
        }
    
        private int find(int[] a1, int[] a2, int i, int j, int k) { // i: idx for a1, j: idx for a2
            if (i == a1.length) return a2[j+k-1]; // corner case 1
            if (j == a2.length) return a1[i+k-1]; // corner case 2
            if (k == 1) return Math.min(a1[i], a2[j]); // corner case 3
    
            int d1 = k / 2, d2 = k - d1; // delta 1 vs delta 2
            if (i+d1 > a1.length) { // if a1 side is out of bound, we can get rid of more from a2 side
                d1 = a1.length-i;
                d2 = k - d1;
            } else if (j + d2 > a2.length) { // if a2 side is out of bound, we can get rid of more from a1 side
                d2 = a2.length - j;
                d1 = k - d2;
            }
    
            int i2 = i + d1 -1, j2 = j + d2 - 1;
    
            return a1[i2] > a2[j2] ? find(a1, a2, i, j2+1, d1) : find(a1, a2, i2+1, j, d2);
        }
    }
}
