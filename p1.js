// ## Problem1 
// H-Index II (https://leetcode.com/problems/h-index-ii)

// time: O(logN)
// space: O(1)

const hIndex = function(citations) {
    if(!citations || citations.length === 0) return 0;
    let left = 0, right = citations.length - 1, mid;
    while(left + 1 < right) {
        mid = left + Math.floor((right - left) / 2);
        if(citations[mid] == citations.length - mid) return citations[mid];
        else if(citations[mid] > citations.length - mid) right = mid;
        else left = mid;
    }
    if(citations[left] >= citations.length - left) return citations.length - left;
    if(citations[right] >= citations.length - right) return citations.length - right;
    return 0;
};