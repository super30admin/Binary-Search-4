// sort the arrays and then compare the lists
// tc: O(nlogn) sc: O(n)

// hashtable to store the frequency of the numbers
// traverse the second list and delete any intersections found

// if the arrays are sorted -> we use binary search to optimize

class Solution {

  public int[] intersect(int[] nums1, int[] nums2) {
    int first = 0, second = 0;

    // sort both arrays

    Arrays.sort(nums1);

    Arrays.sort(nums2);

    // result

    List<Integer> result = new LinkedList<>();

    while (first < nums1.length && second < nums2.length) {
      // same values, add to result

      if (nums1[first] == nums2[second]) {
        result.add(nums1[first]);

        first++;

        second++;
      } else if (nums1[first] > nums2[second]) {
        second++;
      } else {
        first++;
      }
    }

    int[] intersection = new int[result.size()];

    int i = 0;

    for (int r : result) {
      intersection[i++] = r;
    }

    return intersection;
  }
}

class Solution {

  public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length == 0 || nums2.length == 0) return new int[0];

    Arrays.sort(nums1);

    Arrays.sort(nums2);

    List<Integer> list = new ArrayList<>();

    int index = 0;

    for (int i = 0; i < nums1.length; i++) {
      int loc = binarySearch(nums2, index, nums1[i]);

      if (loc < nums2.length && nums2[loc] == nums1[i]) {
        list.add(nums1[i]);

        index = loc + 1;
      }
    }

    int[] res = new int[list.size()];

    int i = 0;

    for (int element : list) {
      res[i++] = element;
    }

    return res;
  }

  public int binarySearch(int[] nums, int index, int target) {
    int left = index, right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] < target) left = mid + 1; else right = mid - 1;
    }

    return left;
  }
}
