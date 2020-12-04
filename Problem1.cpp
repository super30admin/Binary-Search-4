/* Problem Statement:
Verified on leetcode

275. H-Index II
Medium
Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

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

    This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
    Could you solve it in logarithmic time complexity?



 *
 * Time Complexity : O(n) iterating over complete array 
 * Space complexity : O(1)
 */

/* TODO : need to provide O(log N) solution */
class Solution {
public:
    int hIndex(vector<int>& citations) {
        /* initialize with len of list */
        int len = citations.size();
        /* cidx will serve to find the point till we get a valid h-index */
        int cidx = 1;
        
        /* validation input */
        if (len == 0) {
            return 0;
        }
        /* initialize answer */
        int hindex = 0;
        
        for (int idx = len - 1; idx >=0; idx--,cidx++) {
            /* start from the end. if the citation at idx >= pos of idx keep updating h-index */
            if (citations[idx] >= cidx) {
                hindex++;
            } else {
                break;
            }
        }
        return hindex;
    }
};

/* Execute on leetcode platform */


