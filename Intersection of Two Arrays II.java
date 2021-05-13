// Time Complexity :O(mlogn) 
// Space Complexity :O(k) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
      return new int[] {};

    int n1 = nums1.length, n2 = nums2.length;
    if (n1 > n2)
      return intersect(nums2, nums1);

    List<Integer> result = new ArrayList<>();
    int low = 0;
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    for (int i = 0; i < n1; i++) {
      int index = binary(nums2, low, n2 - 1, nums1[i]);
      if (index != -1) {
        result.add(nums1[i]);
        low = index + 1;
      }
    }
    int[] ans = new int[result.size()];
    for (int i = 0; i < result.size(); i++)
      ans[i] = result.get(i);

    return ans;
  }

  private int binary(int[] arr, int low, int high, int target) {
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] == target) {
        if (mid == low || arr[mid] > arr[mid - 1])
          return mid;
        else
          high = mid - 1;
      } else if (arr[mid] > target)
        high = mid - 1;

      else
        low = mid + 1;
    }
    return -1;
  }
}