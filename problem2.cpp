// Time Complexity : O(log(min(n1,n2)))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*

You try to find the partition for the first array 
The partition of the second array will be half of the number of elements combined(cause median will divide both the arrays) - partition of the array1
this is because a half will contain partitions combined from both the arrays. So they will be divided among them when combined.

You will check if the element before parition of the first array is smaller than the smallest eleemnt of the partition of the second array 
(as that element will be smaller than the smallest element of the 2nd partition of the same array cause sorted )

Similarly the largest element of the first partition of the second array 
must be less than the smallest element of the second partition of the first array using above logic.

apply binary search on the partition of the first array and do above untill the low crosses high.

*/

#include<iostream>
#include<vector>
#include<math.h>
#include<cctype>

using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int low{};
        int high{n1};
        double res{};
        while(low<=high){
            int partx = low + (high-low)/2;
            int party = (n1+n2)/2 - partx;
            double l1 = (partx==0)?INT_MIN:nums1.at(partx-1);
            double l2 = (party==0)?INT_MIN:nums2.at(party-1);
            double r1 = (partx==n1)?INT_MAX:nums1.at(partx);
            double r2 = (party==n2)?INT_MAX:nums2.at(party);

            cout<<"partx "<<partx<<"party "<<party<<endl;
            

            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2 == 0){
                    res = (max(l1,l2)+min(r1,r2))/2;
                    break;
                }
                else{
                    res = min(r1,r2);
                    break;
                }
            }
            else{
                if(l2>=r1){
                    low=partx+1;
                }
                else if(l1>=r2){
                    high = partx -1;
                }
            }

        }
        return res;
    }
};