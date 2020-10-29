/*Time Complexity: O(nlogn)
Space Complexity: O(n+m)*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int totalLength = nums1.length + nums2.length;
        int combinedArray [] = new int[totalLength];
        int j = nums1.length;
        double median=0;

        for(int i=0;i<nums1.length;i++)
        {
            combinedArray[i] = nums1[i];
        }

        for(int i=0;i<nums2.length;i++)
        {
            combinedArray[j] = nums2[i];
            j++;
         }
        Arrays.sort(combinedArray);

        if(combinedArray.length%2 != 0)
        {
             median = (combinedArray[(combinedArray.length-1)/2]);
        }
        else
        {
            median = (float) (((combinedArray[(combinedArray.length)/2])) + ((combinedArray[((combinedArray.length)/2)-1])))/2;
        }
        return median;

    }
}
