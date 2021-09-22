//https://leetcode.com/problems/intersection-of-two-arrays-ii/
/*
Time: O(mlogn) where m =nums1.length & n=nums2.length
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<Integer> result = new ArrayList<>();

        // Binary Search Approach on the larger array
        if (n1 > n2)
            return intersect(nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // For each elem in nums1, do a BinarySearch on nums2
        int left = 0, right = n2 - 1;
        for (int i = 0; i < n1; i++) {
            int target = nums1[i];
            int nums1Index = binarySearch(nums2, left, right, target);
            if (nums1Index != -1) {
                result.add(target); // add to result
                left = nums1Index + 1; // move to next elem on nums1

            }
        }

        // convert list to array
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;

    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) // not sure which occurance you have hit (there can be dups)
            {
                // mid == leftmost, so no point in looking towards the left side
                if (mid == left || nums[mid] > nums[mid - 1]) // middle val is larger than it's prev, mid is first
                                                              // occurance
                {
                    return mid; // first occurance
                }
                right = mid - 1;
            }

            else if (target > nums[mid])
                left = mid + 1;

            else
                right = mid - 1;
        }
        return -1;
    }

}
