//Time Complexity:O(m+n)
//Space Complexity:O(m+n)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length, n=nums2.length;
        int[] res = new int[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                res[k]=nums1[i];
                i++;
            }else{
                res[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i<m){
            res[k]=nums1[i];
            i++;
            k++;
        }
        while(j<n){
            res[k]=nums2[j];
            j++;
            k++;
        }
        double ans =0;
        if((m+n)%2==0){
            ans=(res[((m+n-1)/2)]+(double)res[((m+n-1)/2 )+1])/2;
        }else{
            ans =res[(m+n)/2];
        }

        return ans;
    }
} 
