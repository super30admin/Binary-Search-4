/*
 * #275. H-Index II
 * 
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [0,1,3,5,6]
Output: 3 
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had 
             received 0, 1, 3, 5, 6 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
             
Note:

If there are several possible values for h, the maximum one is taken as the h-index.

Follow up:

1. This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
2. Could you solve it in logarithmic time complexity?

 */


/*
 * Time Complexity: O (log N) -> Binary Search on given array
 * 
 * Space Complexity: O (1) -> constant space, no extra space used
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.binarysearch4;

public class HIndexII {
	public int hIndex(int[] citations) {
        
        // #1. Base condition 
        if(citations == null || citations.length == 0){
            return 0;
        }
        
        // Since the array is sorted, we will apply binary search to find the h-index
        /*
        * Two conditions should be satisfied:
        *   1. Suppose if h-index = 2, then we say that there should be atleast 2 papers
        *      with citation value >= 2. -> We take care of this condition in code
        *   2. After first condition is satisfied, then (N-h) = (5-2) = 3 papers
        *      should have citation value no more than h-index. Means, citation value should be <= 2.
        *      -> This is automatically being taken care of without writing code because array is sorted.
        */
        
        // #2. Initialize the low and high pointers 
        int low = 0;
        int high = citations.length - 1;
        
        // #3. Get the length of array
        int len = citations.length;
        
        // #4. Binary Search
        while(low <= high){
            
            int mid = low + (high - low) / 2;
            
            // #5. Get the h-index at a particular position in array
            
            /*              0  1  2  3  4  -> Index
            *  citations = [0, 1, 3, 5, 6]  -> citation values
            *               5  4  3  2  1   -> h-index
            *  
            *  h-index at a particular index is computed as: length of array - index at a particular position
            *                                                len - mid -> 'mid' is the index;
            */
            
            int h_index = len - mid; 
            
            // #6. Find the h-index of a researcher
            
           /*
            * There is a pattern of "sign change" between citation value and h-index to find the answer
            *                   0  1  2  3  4
            * e.g: citations = [0, 1, 2, 5, 6]
            *                   5  4  3  2  1
            * 
            * Starting with index 0:
            *   citation value < h-index:
            *       0 < 5
            *       1 < 4
            *       2 < 3
            *       5 > 2  -> Here, we got our answer
            *              -> Once, citation value >= h-index, we have found our h-index
            */
            // Either, we return answer if this condition is satisfied, or keep moving the low and high pointers and 
            // changing mid until low pointer > high pointer, exit the while loop
            if(h_index == citations[mid]){
                return h_index;
            }
            else if(h_index > citations[mid]){
                // move to the right as citation value should be greater
                low = mid + 1; 
            }
            else{
                // move to the left
                high = mid - 1;
            }
            
        }
        
        // #7. Return the answer
        
       /* return the answer here
        * low = 3
        * For above example, ans = len - low = 5 - 3 = 2 (h_index)
        */
        return len - low; 
        
    }
    
}
