TIME = O(log(min(m,n))
SPACE = O(1)

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        if(n1==0 && n2 ==0) return 0.00;
        if(n2<n1) return findMedianSortedArrays(nums2,nums1);
        int low = 0;
        int high = n1;
        while(low<=high){
            int pivotX = low + (high-low)/2;
            int pivotY = (n1+n2)/2 - pivotX;
            double l1 = pivotX == 0 ? INT_MIN : nums1[pivotX-1];
            double r1 = pivotX == n1 ? INT_MAX : nums1[pivotX];
            double l2 = pivotY == 0 ? INT_MIN : nums2[pivotY-1];
            double r2 = pivotY == n2 ? INT_MAX : nums2[pivotY];
            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==0){
                    return (max(l1,l2) + min(r1,r2))/2;
                }else{
                    return min(r1,r2);
                }
            }else if(l2>r1){
                low = pivotX + 1;
            }else{
                high = pivotX;
            }
        }
        return 0.00; //never comes here
    }
};
