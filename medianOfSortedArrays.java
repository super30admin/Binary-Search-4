//Time Complexity:O(log(min(nums1,nums2))), will be the logarithemic time complexity of the smallest array.
//SPace complexity:O(1)
//Brute force: Flatten both the arrays into one single array, sort them and find the median. Time complexity:O(n^2).
//Approach here:(Binary search) Find the smallest of the two given arrays and perform binary search on it to find the midpoint. Use that midpoint to find the partition in y by using the formula midx+midy=(x+y+1)/2 where x and y are the length of the 2 given list and the right hand side denotes the mid of the list when both are combined into a single list. +1 offset is added to make it generic for both odd and even length arrays. After finding the partition, the maximum left in x  and maximum right element in y should be less than minimum right in x and minimum right in y. That means that all the elements in left are less than all the elements in the right and hence we have arrived at the right partition and hence if the combined length is odd, then the max of the two maxleft elements will be the median, other wise the average of the max of the two maximum left elements and the two minimum right elements will be the median. If the maxleft elements at x is greater than the min right element at Y, then move the right element in the smallest array to mid-1 and perform the binary serach again. Else, move the left element to mid+1 and perform the binary serach again.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int x=nums1.length;
        int y=nums2.length;
        if(x==1&&y==1){
            return((double)nums1[0]+nums2[0])/2;
        }
        int low=0;
        int high=x;
        while(low<=high){
            int midx=low+(high-low)/2;
            int midy=(x+y+1)/2 - midx;
            int maxleftX=(midx==0)?Integer.MIN_VALUE:nums1[midx-1];
            int minrightX=(midx==x)?Integer.MAX_VALUE:nums1[midx];
            int maxleftY=(midy==0)?Integer.MIN_VALUE:nums2[midy-1];
            int minrightY=(midy==y)?Integer.MAX_VALUE:nums2[midy];
            if(maxleftX<=minrightY&&maxleftY<=minrightX){
                if((x+y)%2==0){
                    return((double)Math.max(maxleftX,maxleftY)+Math.min(minrightX,minrightY))/2;
                }
                else{
                    return ((double)Math.max(maxleftX,maxleftY));
                }
            }
            else if(maxleftX>minrightY){
                high=midx-1;
            }
            else{
                low=midx+1;
            }
        }
        throw new IllegalArgumentException();
    }
}