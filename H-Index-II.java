/**
 * Time: O(n) n-length of the array c
 * Space: O(1)
 */
class Solution {
    public int hIndex(int[] c) {
        int low = 0, high = c.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int diff = c.length - mid;

            if(diff == c[mid]) return diff;
            else if(c[mid] > diff) high = mid-1;
            else low = mid+1;
        }
        return c.length-low;
    }
}