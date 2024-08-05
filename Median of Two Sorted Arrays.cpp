//this algorithm is just for this question
//binary search on partitions - 8/2 s30 class
//time: O(log(smaller arr))
//space: O(1)
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = n1;
        while(low <= high) {
            int partX = low + (high-low)/2;
            int partY = (n1+n2)/2 - partX;
            //L1 L2 R1 R2
            int L1 = partX == 0 ? INT_MIN : nums1[partX-1];
            int L2 = partY == 0 ? INT_MIN : nums2[partY-1];
            int R1 = partX == n1 ? INT_MAX : nums1[partX];
            int R2 = partY == n2 ? INT_MAX : nums2[partY];
            if(L1 <= R2 && L2 <= R1) {
                //correct partition find median
                if((n1+n2)%2 == 0) {
                    //even
                    return (min(R1,R2) + max(L1,L2))/2.0;
                }
                else {
                    //odd
                    return min(R1,R2);
                }
            }
            else if(L1 > R2) {
                high = partX - 1;
            }
            else {
                low = partX + 1;
            }
        }
        //return anything
        return 0;
    }
};