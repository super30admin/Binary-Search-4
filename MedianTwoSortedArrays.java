// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // return helperBruteForce(nums1, nums2);
        // return helperBruteForceOptimized(nums1, nums2);
        return helperBS(nums1, nums2);
    }

    //TC: O(log(min(n, m)))
    //Sc: O(1)
    private double helperBS(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }

        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n2 > n1) {
            return helperBS(nums2, nums1);
        }

        //BS on smaller array
        int low = 0;
        int high = n2;

        while(low <= high) {

            int partX = low + (high - low) /2;
            int partY = (n1 + n2)/2 - partX;

            //divide both arrays in two 2 parts
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums2[partX - 1];
            double r1 = partX == n2 ? Integer.MAX_VALUE : nums2[partX];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums1[partY - 1];
            double r2 = partY == n1 ? Integer.MAX_VALUE : nums1[partY];


            //if l1 < r2 && l2 < r1v then right partition
            if(l1 <= r2 && l2 <= r1) {
                if((n1 + n2)% 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return  Math.min(r1, r2);
                }

            } else if(l2 > r1) {
                low = partX + 1;
            } else if(l1 > r2) {
                high = partX -1;
            } 

        }

        return 23242423.00;

    }

    // Tc: O(n+m)
    // Sc: O(n+m)
    private double helperBruteForce(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        int n3 = n1 + n2;

        int nums3[] = new int[n1 + n2];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                nums3[k++] = nums1[i++];
                nums3[k++] = nums2[j++];
            } else if (nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }

        if (i == n1) {
            while (j < n2) {
                nums3[k++] = nums2[j++];
            }
        } else {
            while (i < n1) {
                nums3[k++] = nums1[i++];
            }
        }

        int mid = n3 / 2;

        if (n3 % 2 == 0) {
            return (nums3[mid] + nums3[mid - 1]) / 2.0;
        } else {
            return nums3[mid];
        }
    }

    // Tc: O(n+m)
    // Sc: O(1)
     public double helperBruteForceOptimized(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int medianIndex1 = (totalLength - 1) / 2;
        int medianIndex2 = totalLength / 2;

        int i = 0; // Index for nums1
        int j = 0; // Index for nums2
        int count = 0; // Counter for merged array elements

        int median1 = 0;
        int median2 = 0;

        while (count <= medianIndex2) {
            int current;

            // System.out.print("i: " + i + "   j: " + j + "  median1: " + median1 + "    median2: " + median2 + "    count: " + count);
            if (i < nums1.length && (j >= nums2.length || nums1[i] <= nums2[j])) {
                current = nums1[i++];
            } else {
                current = nums2[j++];
            }

            // System.out.println("  current:"  + current);

            if (count == medianIndex1) {
                median1 = current;
                // System.out.println("Median1: " + median1);
            }
            if (count == medianIndex2) {
                median2 = current;
                // System.out.println("Median2: " + median2);
                break;
            }

            count++;
        }

        return (median1 + median2) / 2.0;
    }
}