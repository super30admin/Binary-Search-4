// https://leetcode.com/problems/intersection-of-two-arrays-ii/
// Time complexity : O(mlogn)  n -> len(nums1)  m -> len(nums2)
// Space complexity : O(1)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return intersect(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int low = 0;
        int high = nums1.length - 1;
        for (int elem : nums2) {
            int index = binarySearch(nums1, elem, low, high);
            // System.out.println("Searching :"+elem+"\t"+"index : "+index);
            if (index >= 0 && index < (high + 1) && nums1[index] == elem) {
                res.add(elem);
                low = index + 1;
            }
        }

        int r[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;

    }

    public int binarySearch(int arr[], int target, int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}