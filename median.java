/*
Time Complexity: O(N)
Space Complexity: O(1)
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length + nums2.length];
        int j=0;
        for(int i=0;i<nums1.length;i++){
            arr[i]=nums1[i];
            j++;
        }
        for(int i=j;i<(nums1.length+nums2.length);i++){
            arr[i]=nums2[i-j];
        }
        Arrays.sort(arr);
        if(arr.length%2 == 0){
            return (double)(arr[arr.length/2]+arr[(arr.length/2)-1])/2;
        }else{
            return (double)arr[arr.length/2];
        }
    }
}