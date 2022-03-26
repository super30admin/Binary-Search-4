// Time Complexity:    O( log(n) )
// Space Complexity:   O(1)
// where n is number of elements in array
// This code ran successfully on Leetcode

public class Hindex {
    public int hIndex(int[] citations) {

        int n = citations.length;
        int ans = 0;
        int l = 1;
        int r = n;

        while(l <= r) {

            int mid = l + (r-l)/2;
            int p2 = n-mid;                             // getting index p2 to check whether "mid" number of elements are according to h-index or not
            int p1 = p2-1;                              // to check whether "ans" is correct or not

            if(citations[p2] >= mid && (p1<0 || citations[p1]<=mid)) { // checking whether "mid" number of elements are according to h-index or not
                ans = mid;                                             // if yes then update "ans"
                l = mid+1;                                             // and reduce scope for greater possible "ans"
            }
            else if(citations[p2] < mid)                // if "mid" can't be answer and value at "p2" is smaller, we reduce scope and go left
                r = mid-1;
            else                                        // otherwise we reduce scope and go right
                l = mid+1;
        }
        return ans;
    }
}
