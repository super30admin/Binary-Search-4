
// Time Complexity :O(log(min(m,n)))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :getting started

// Your code here along with comments explaining your approach
public class MedianofTwoSortedArrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            //if nums1 is longer then swap nums1 with nums2
            if(nums1.length > nums2.length){
                return findMedianSortedArrays(nums2, nums1);
            }

            int low=0, high= nums1.length;//low and high pointer for binary search
            int combinedLength = nums1.length + nums2.length;//combined lenght to check if odd or even

            //binary search
            while(low<=high){
                int partitionX = (low+high)/2;
                int partitionY = (combinedLength+1)/2-partitionX;

                //get number directly to the left of partition in each array
                int leftX = getMax(nums1, partitionX);
                int rightX = getMin(nums1, partitionX);

                int leftY = getMax(nums2, partitionY);
                int rightY = getMin(nums2, partitionY);

                if(leftX <= rightY && leftY <= rightX){
                    //check for even and odd case for combined length
                    if(combinedLength%2==0){
                        return (Math.max(leftX, leftY) + Math.min(rightX,rightY))/2.0;
                    }
                    return Math.max(leftX, leftY);
                }
                if(leftX > rightY){
                    //shift high down by 1
                    high=partitionX-1;
                } else{
                    //shift high up
                    low=partitionX+1;
                }
            }
            return -1;//all cases vailid, return invalid answer
        }

        private int getMax(int[] nums, int partition){
            if(partition == 0){
                return Integer.MIN_VALUE;
            }else{
                return nums[partition-1];
            }
        }

        private int getMin(int[] nums, int partition){
            if(partition == nums.length){
                return Integer.MAX_VALUE;
            }else{
                return nums[partition];
            }
        }
    }
}
