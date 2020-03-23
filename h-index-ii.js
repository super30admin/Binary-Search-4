// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} citations
 * @return {number}
 */
var hIndex = function(citations) {
    if (!citations || !citations.length) return 0;
    
    let left = 0,
        right = citations.length - 1;
    while (left <= right) {
        let mid = Math.floor((left + right) / 2);
        let currH = citations[mid];
        if (citations[mid] == citations.length - mid) return citations.length - mid;
        else if (citations[mid] < citations.length - mid) left = mid + 1;
        else right = mid - 1;
    }
    
    return citations.length - left;
};
