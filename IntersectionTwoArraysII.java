public class IntersectionTwoArraysII {

// Time Complexity : O(N1+N2)
// Space Complexity : O(min(N1,N2))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    class HashMapSolution {
        public int[] intersect(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            if (n1 > n2) {
                return intersect(nums2, nums1);
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n1; i++) {
                map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
            }
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < n2; i++) {
                if (map.containsKey(nums2[i])) {
                    li.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                    if (map.get(nums2[i]) == 0) {
                        map.remove(nums2[i]);
                    }
                }
            }
            int size = li.size();
            int[] res = new int[size];
            for (int i = 0; i < size; i++) {
                res[i] = li.get(i);
            }
            return res;
        }
    }

// Time Complexity : O(n1*logn2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    class BinarySearchSolution {
        public int[] intersect(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            if (n1 > n2) {
                return intersect(nums2, nums1);
            }
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int startIdx = 0;
            List<Integer> li = new ArrayList<>();
            for (int i = 0; i < n1; i++) {
                System.out.println(nums1[i]);
                int idx = binarySearch(nums2, startIdx, n2 - 1, nums1[i]);
                if (idx != -1) {
                    startIdx = idx + 1;
                    li.add(nums1[i]);
                }
            }
            int size = li.size();
            int[] res = new int[size];
            for (int i = 0; i < size; i++) {
                res[i] = li.get(i);
            }
            return res;
        }

        private int binarySearch(int arr[], int low, int high, int target) {
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] == target) {
                    if (mid == low || arr[mid] != arr[mid - 1]) {
                        return mid;
                    } else {
                        high = mid - 1;
                    }
                } else if (arr[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }
            return -1;
        }
    }

// Time Complexity : O(min(N1,N2))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

    class TwoPointerSolution {
        public int[] intersect(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            if (n1 > n2) {
                return intersect(nums2, nums1);
            }
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int p1 = 0;
            int p2 = 0;
            List<Integer> li = new ArrayList<>();
            while (p1 < n1 && p2 < n2) {
                if (nums1[p1] == nums2[p2]) {
                    li.add(nums1[p1]);
                    p1++;
                    p2++;
                } else if (nums1[p1] > nums2[p2]) {
                    p2++;
                } else {
                    p1++;
                }
            }
            int size = li.size();
            int[] res = new int[size];
            for (int i = 0; i < size; i++) {
                res[i] = li.get(i);
            }
            return res;
        }
    }
}
