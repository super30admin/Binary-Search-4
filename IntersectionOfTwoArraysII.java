/* Time Complexity : O(mlogn)
 * Space Complexity : O(min(m,n)), to store result
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

class Solution {
    // approch 3 using binary search
    public int[] intersect(int[] nums1, int[] nums2) {
        // sorting both the arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // binary search on bigger array
        if (nums2.length > nums1.length)
            return intersect(nums2, nums1);
        // bigger one
        int m = nums1.length;
        // smaller one
        int n = nums2.length;
        // left and right for binary search
        int l = 0;
        int r = m - 1;
        List<Integer> li = new ArrayList<>();

        // normal traverse in smaller array
        for (int i = 0; i < n; i++) {
            int bsIndex = binarySearch(nums1, l, r, nums2[i]);
            if (bsIndex != -1) {
                li.add(nums2[i]);
                // to handle same elements
                l = bsIndex + 1;
            }
        }

        // System.out.println(li);
        // result array
        int[] result = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            result[i] = li.get(i);
        }
        return result;

    }

    // to find first occurences of the character
    private static int binarySearch(int[] nums, int l, int r, int target) {

        // binary search
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                if (mid == l || nums[mid] != nums[mid - 1]) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1; 
    }
}
