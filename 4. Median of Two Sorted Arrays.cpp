class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size() == 0 && nums2.size() == 0 )
            return 0.0;
        int n1 = nums1.size();
        int n2 = nums2.size();
        if(n1>n2)
            return findMedianSortedArrays(nums2, nums1);
        int low=0, high=n1;
        while(low<=high){
            int partX = low + (high - low)/2;
            int partY = (n1+n2)/2 - partX;
            double l1 = (partX == 0) ? INT_MIN : nums1[partX - 1];
            double l2 = (partX == n1) ? INT_MAX : nums1[partX];
            double r1 = (partY == 0) ? INT_MIN : nums2[partY - 1];
            double r2 = (partY == n2) ? INT_MAX : nums2[partY];
            if(l1 <= r2 && r1 <= l2){
                if((n1+n2)%2 != 0)
                    return min(l2,r2);
                return (max(l1,r1)+min(l2,r2))/2.0;
                

            }
            else if(l1 > r2)
                high = partX - 1;
            else
                low = partX + 1;
        }
        return 0.0;
    }
};
