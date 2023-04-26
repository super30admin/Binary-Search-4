// Approach - Binary Search
// Time Complxity - O(n), n is the size of the smaller array.
// Space Complexity - O(1)

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size(); int n2 = nums2.size();
        if(n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0;
        int high = n1;
        while(low <= high){
            int px = low + (high - low)/2;
            int py = (n1+n2)/2 - px;
            
            double l1 = px == 0 ? INT_MIN : nums1[px-1];
            double l2 = py == 0 ? INT_MIN : nums2[py-1];
            double r1 = px == n1 ? INT_MAX : nums1[px];
            double r2 = py == n2 ? INT_MAX : nums2[py];
            
            if(l1 <= r2 && l2 <= r1){
                if((n1+n2)%2 == 0)
                    return (max(l1, l2) + min(r1, r2))/2;
                else
                    return min(r1, r2);
            }else if(l1 > r2)
                high = px - 1;
            else
                low = px + 1;
        }
        return 0;
    }
};

// Attempt 2
// Time Complxity - O(n), n is the size of the smaller array.
// Space Complexity - O(1)
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        if(n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0;
        int high = n1;
        int mid;
        double l1, l2, r1, r2;
        
        while(low <= high){
            mid = low + (high - low)/2;
            int p1 = mid;
            int p2 = (n1 + n2)/2 - p1;
            
            if(p1 == 0)
                l1 = INT_MIN;
            else
                l1 = nums1[p1-1];
            if(p2 == 0)
                l2 = INT_MIN;
            else
                l2 = nums2[p2-1];
            
            if(p1 == n1)
                r1 = INT_MAX;
            else
                r1 = nums1[p1];
            if(p2 == n2)
                r2 = INT_MAX;
            else
                r2 = nums2[p2];
            
            if(l1 <= r2 && l2 <= r1){
                if((n1+n2)%2 == 0){
                    return (max(l1, l2) + min(r1, r2))/2;
                }
                else{
                    return min(r1, r2);
                }
            }
            else if(l1 > r2)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 0;
    }
};