//TC: O(nums1 + nums2)
//SC: O(nums1 + nums2)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] sortedArray = new int[n + m];
        int i=0, j = 0;
        int index = 0;
        while(i < n && j < m) {
            if(nums1[i] <= nums2[j]) {
                sortedArray[index++] = nums1[i];
                i++;
            }
            else {
                sortedArray[index++] = nums2[j];
                j++;
            }
        }

        while(i < n) {
            sortedArray[index++] = nums1[i];
            i++;
        }

        while(j < m) {
            sortedArray[index++] = nums2[j];
            j++;
        }

        int length = sortedArray.length;

        if(length % 2 != 0) {
            return (double)sortedArray[length / 2];
        }
        else {
            int middle1 = sortedArray[length / 2];
            int middle2 = sortedArray[length/2 - 1];
            return (double) (middle1 + middle2)/2;

        }

    }
}