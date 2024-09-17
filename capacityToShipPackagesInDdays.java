/*
Problem: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
*/

// TC: O(n log k) -> k is the range of lower to higher bound. n = size of weights.
// SC: O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        if (days == 0 || weights == null || weights.length == 0) {
            return 0;
        }
        
        // low -> The capacity should at least be the weight of the largest package
        // high -> Sum of all weights i.e when we send all packages in one day
        int low = 0, high = 0;
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        
        low = Math.max(low, high / days);
        
        // Binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // d is the days needed to ship packages with capacity = mid
            int d = 1;
            int curCapacity = 0;
            
            for (int i = 0; i < weights.length; ++i) {
                if (curCapacity + weights[i] > mid) {
                    ++d;
                    if (d > days)
                        break;
                    curCapacity = 0;
                }
                curCapacity += weights[i];
            }
            
            // <= because d could be equal to days with curCapacity but we can also have a smaller one that satisfies the same condition.
            if (d <= days) {
                // We are sending packages in less than 'days' days so reduce capacity
                high =  mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}