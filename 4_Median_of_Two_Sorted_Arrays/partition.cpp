#include<bits/stdc++.h>
using namespace std;

/*
Approach: Binary search on partitions: So suppose we have the merged and sorted array. Consider array to be of even size for now. There will the mid point where there are (n1+n2)/2 elems to left andright. Now map this to original arrays arr1 and arr2. There will be corresponding partition in arr1 say at pos X and in arr2 at posY. They are related by posX + posY = (n1+n2)/2. Hence given posX, posY can be determined in O(1). In this partition, elem to left of posX<elem to right of posY and elem to right of posX > elem to left of posY. So now problem reduces to finding the posX where this condition is satisfied. So we take a valid partition range. Find mid and check condition. If elem to left of posX > elem to right of posY then we will have to move posX to left to reduce the elem val in arr1 and to increase in arr2. So we do R=mid-1. In other case L=mid+1. Once we get the partition, depending on even or odd len of (n1+n2) we get the median as max(l1+l2) + min(r1,r2)/2 or min(r1,r2) respectively.
Time: O(n1*log(n2))
Works on leetcode: Yes
*/

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size() > nums2.size()) {
            cout<<"H"<<endl;
            return findMedianSortedArrays(nums2, nums1);
        }
        int nl1=nums1.size(), nl2=nums2.size();
        int st=0,end=nums1.size();
        while (st<=end) {
            // cout<<st<<" "<<end<<endl;
            int partX=st + (end-st)/2;
            int partY=getYPart(nl1,nl2,partX);
            int l1 = partX==0 ? INT_MIN:nums1[partX-1];
            int l2 = partY==0 ? INT_MIN:nums2[partY-1];
            int r1 = partX==nl1 ? INT_MAX:nums1[partX];
            int r2 = partY==nl2 ? INT_MAX:nums2[partY];

            if(l1>r2) {
                // move partition to left
                end = partX-1;
            }
            else if(l2>r1) {
                // move partition to right
                st = partX+1;
            }
            else {
                // get median
                if((nl1 + nl2)%2==0) {
                    return ((double)max(l1,l2) + (double)min(r1,r2))/2.0;
                }
                else {
                    return min(r1,r2);
                }
            }
        }
        return 0.0;
    }

    int getYPart(int nl1, int nl2, int xPart) {
        return (nl1+nl2)/2-xPart;
    }
};

int main() {
    vector<int> nums1{1,2};
    vector<int> nums2{3,4};
    Solution S;
    cout<<S.findMedianSortedArrays(nums1, nums2)<<endl;
}