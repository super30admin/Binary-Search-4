// Time Complexity : O(logm) (m<n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// context: when two sorted arrays are given, if we need to find median, the position of median would roughly be after (m+n)/2 position.
//           so , that means before our median , there are (m+n)/2 elements. these elements can be from nums1 or from nums2, but total 
//           will defnetly be (m+n)/2.
// Approach: we will find how many elements are picked from nums1 array out of those (m+n)/2 elements.
//          so, if x = no. of elements from 1st array, then no. of elements picked from 2nd array would be ((m+n)/2 - x) elements.
//          we use binary search to find the x elements(we choose small size array).
//          we get two halves of nums1 and nums2. whenever our condition satisfies.
//          Based on (m+n) is even or odd, we properly findout the median.

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size();
        int n = nums2.size();
        if(m > n) return findMedianSortedArrays(nums2,nums1);
        int lo = 0,hi = m;
        double l1,r1,l2,r2;
        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            int y = (m+n)/2 - mid;
            l1 = (mid == 0)? INT_MIN : nums1[mid-1];
            r1 = (mid == m)? INT_MAX: nums1[mid];
            l2 = (y == 0)? INT_MIN: nums2[y-1];
            r2 = (y==n)? INT_MAX:nums2[y];
            if(l1<=r2 && l2<=r1)
            {
                if((m+n)%2)
                {
                    return min(r1,r2);
                }
                else
                {
                    return ((max(l1,l2) + min(r1,r2))/2);
                }
            }
            if(l1>r2)
            {
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
        }
        return 3;
    }
};