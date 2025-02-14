/**
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 
 */

public class HIndex {
    public int hIndex(int[] citations) {
        int low = 0;
        int n = citations.length;
        int high = n - 1;
        while (low <=high) {
            int mid = low + (high - low)/2;

            if (citations[mid] >= n - mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return n - low;
    }

    public static void main(String[] args) {
        // Your code here
        HIndex obj = new HIndex();

        int val = obj.hIndex(new int[]{0,1,1,2,3});
        System.out.println(val);
    }
}