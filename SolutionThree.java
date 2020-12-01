// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

class Solution {
    public int hIndex(int[] citations) {

        if(citations==null||citations.length==0)
            return 0;

        int n =citations.length;

        for(int i=0;i<n;i++)
        {
            int diff = n - i;

            if(diff <= citations[i])
            {
                return diff;//n-i
            }
        }
        return 0;

    }
}