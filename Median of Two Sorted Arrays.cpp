//Time Complexity- O(log(min(m,n))
//Space Complexity- O(1)

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        
        if(nums1.size()==0 && nums2.size()==0){
            return 0.00;
        }
        int n1=nums1.size();
        int n2=nums2.size();
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);
        }
        
        int low=0;
        int high=n1;
        while(low<=high){
            int px=low+(high-low)/2;
            int py=(n1+n2)/2-px;
            double l1=(px==0)?INT_MIN:nums1[px-1];
            double l2=(py==0)?INT_MIN:nums2[py-1];
            double r1=(px==n1)?INT_MAX:nums1[px];
            double r2=(py==n2)?INT_MAX:nums2[py];
            
            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==0){
                    return (max(l1,l2)+min(r1,r2))/2;
                }
                else{
                    return min(r1,r2);
                }
            }
            else if(l1>r2){
                high=px-1;
            }
            else{
                low=px+1;
            }
        }
        return -1;
    }
};