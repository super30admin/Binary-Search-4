//Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size(); int n2 = nums2.size();
        
        if(n1>n2) return findMedianSortedArrays(nums2, nums1);
        int low =0; int high = nums1.size();
        
        while(low<=high){
            int part1 = low+(high-low)/2;
            int part2 = (n1+n2+1)/2 - part1;
            double l1, l2, r1, r2;
            
            //l1
            if(part1==0)  l1 = INT_MIN;
            else          l1 = nums1[part1-1];
            
            //r1
            if(part1 == n1)  r1 = INT_MAX;
            else             r1 = nums1[part1];
            
            //l2
            if(part2==0) l2 = INT_MIN;
            else         l2 = nums2[part2-1];
            
            //r2
            if(part2 == n2) r2 = INT_MAX;
            else            r2 = nums2[part2];
                

            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==0){
                    return double((max(l1, l2)+min(r1, r2))/2);
                }
                else{
                    return double(max(l1, l2));
                }
            }
            else if(l2>r1){
                low = part1+1;
            }
            else
                high = part1-1;
                 
        }
            
       return -1;
    }
};