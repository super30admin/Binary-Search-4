// Time Complexity : O(log n) Binary Search where n is the number of elements of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: Since the list is sorted, the max length of the citations can be only acieved
for the element if the length of array - mid position is equal to the mid element. If the mid element is greater than the length => we dont have
enough elements to its right, put the high to the left of mid for search. Add the max of the lengths as the result. Else add the low to the right of
mid to reduce search space to its right as we need the max value if we have multiple values satisfying the criteria.
*/
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){return 0;}
        int low = 0, end = citations.length-1;
        int n = citations.length;
        int result = 0;
        while(low <= end){                                                              // while low is lesser than end
            int mid = low + (end -low)/2;
            if(n - mid <= citations[mid]){                          // if the right length of the element is lesser than the mid element
                result = Math.max(result, n - mid);                 // Take the max length towards the right from the mid element.
                end = mid -1;                                       // if the length towards the right is lesser than the mid element, reduce the search space to the left of the array
            } else 
            {
                low = mid+1;                                    // Search on the right of the mid element
            }
        }
        return result;                                          // Return the result
    }
}