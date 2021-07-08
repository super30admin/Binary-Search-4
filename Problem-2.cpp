//O(m+n) TC, same SC
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1=nums1.size(),n2=nums2.size();
        int result[n1+n2];
        int i=0,j=0,k=0;
        while(i<n1 && j<n2) result[k++]= nums1[i]<nums2[j]?nums1[i++]:nums2[j++];
        while(i<n1) result[k++]=nums1[i++];
        while(j<n2) result[k++]=nums2[j++];
        int l=n1+n2;
        
        double f = l%2==0?(double)(result[l/2 -1]+result[l/2])/2:(double)result[l/2];
        
        return f;
    }
};
