//Time Complexity : O(log(min(size1,size2)))
//Space Complexity: O(1)

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length == 0 && nums2.length == 0) return 0.0;              //check for null case

        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);            //if nums1>nums2 then call the function again as nums1=nums2 and nums2=nums1 and return from there

        int size1 = nums1.length;                                       //store the nums1 length
        int size2 = nums2.length;                                       //store the nums2 length

        int low = 0;
        int high = size1;       //we have to apply binary search on partition, so partition is number of elements + 1, so we directly intiate high value to the size1

        while(low<=high){                                               //iterate till low<=high

            int partX = (low+high)/2;                                   //get the partX, parititon for nums1
            int partY = (size1 + size2 + 1)/2 - partX;                  //get the partY, partition for nums2

            int left1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];              //calculate the left1, which is the parititon's nearest left value for nums1
            int left2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];              //calculate the left2, which is the parititon's nearest left value for nums2

            int right1 = partX == size1 ? Integer.MAX_VALUE : nums1[partX];             //calculate the right1, which is the parititon's nearest right value for nums1
            int right2 = partY == size2 ? Integer.MAX_VALUE : nums2[partY];             //calculate the right2, which is the parititon's nearest right value for nums2

            if((left1<=right2) && (left2 <=right1)){                                //check if left1<=right2 and left2<=right1, means we paritioned to the right position

                if( ( size1 + size2 ) % 2 ==0){         //even number of elements

                    return (Math.max(left1, left2) + Math.min(right1, right2))/2.0;         //then return the median value
                }
                else{               //odd number of elements

                    return (double)Math.max(left1, left2);                              //then return the median value
                }
            }
            else if(left1 > right2){                                            //means we have partitioned on too right, so have to do partition on left

                high = partX - 1;                                               //update high
            }
            else{                                       //means we have partitioned on too left, so have to do partition on right

                low = partX + 1;                        //update low
            }
        }
        return 0.0;                                     //otheriwise return 0
    }
}


public class MedianOf2SortedArraysLC4 {
}
