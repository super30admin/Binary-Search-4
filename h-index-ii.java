// Time Complexity : O(N)--->O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// class Solution {
//     public int hIndex(int[] citations) {
//         //base case
//         if(citations == null || citations.length == 0)
//             return 0;
        
//         int n=citations.length;
//         for (int i=0;i<n;i++)
//         {
//             int citation = citations[i];
//             int count = n-i;
//             if(citation >= count)
//                 return count;
//         }
//         return 0;
//     }
// }

class Solution {
    public int hIndex(int[] citations) {
        //base case
        if(citations == null || citations.length == 0)
             return 0;
        
        int n=citations.length;
        int low=0, high=n-1;
        while(low <= high)
        {
            int mid = low+(high-low)/2;
            if(citations[mid] == n-mid)
                return n-mid;
            
            if(citations[mid] < n-mid)
                low=mid+1;
            else
                high=mid-1;
        }
        return n-low;
    }
}
