//Time Complexity-O(logn1+n2)
//Space Complexity-O(1)
//Ran successfully on leetcode

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1=nums1.size();
        int n2=nums2.size();
        if(n1>n2)
            return findMedianSortedArrays(nums2,nums1);
        int low=0,high=n1;
        while(low<=high)
        {
            int px=low+(high-low)/2;
            int py=(n1+n2+1)/2-px;
            double l1,l2,r1,r2;
            //l1
            if(px==0)
                l1=INT_MIN;
            else
                l1=nums1[px-1];
            //r1
            if(px==n1)
                r1=INT_MAX;  
            else
                r1=nums1[px];             
            if(py!=0)
                l2=nums2[py-1];
            else
                l2=INT_MIN;
            if(py!=n2)
                r2=nums2[py];
            else
                r2=INT_MAX;
            //cout<<r2<<" ";
            if(l1>r2)
                high=px-1;
            else if(l2>r1)
                low=px+1;
            else 
            {
                if((n1+n2)%2!=0)
                    return max(l1,l2);
                else
                    return (max(l1,l2)+min(r1,r2))/2;
            }
        }
        return -1;            
    }
};