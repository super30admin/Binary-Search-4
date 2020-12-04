class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] result = new int[n1+n2];
        int i =0 , j = 0 , k=0;
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                result[k] = nums1[i];
                k++;
                i++;
            }
            else if(nums1[i]>nums2[j]){
                result[k] = nums2[j];
                k++;
                j++;
            }
            else{
                result[k] = nums1[i];
                result[k+1] = nums2[j];
                k = k+2;
                i++;
                j++;
            }
        }
        while(i<n1){
            result[k] = nums1[i];
            i++;
            k++;
        }
        while(j<n2){
            result[k] = nums2[j];
            j++;
            k++;
        }
        if((n1+n2)%2 == 0){
            return (result[(n1+n2)/2]+result[((n1+n2)/2)-1])/2.0;
        }
        else
            return result[(n1+n2)/2];
    }
}
