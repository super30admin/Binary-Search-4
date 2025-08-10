class Solution {

    // Binary search method
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return intersect(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList();

        int low = 0;
        // do binary search on larger array so log(n) reduces its value. Therefor iterate over smaller array
        for (int i = 0; i < m; ++i) {
            int bsIndex = binarySearch(nums2, nums1[i], low, n - 1);

            if (bsIndex != -1) {
                list.add(nums1[i]);
                low = bsIndex + 1;
            }
        }

        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    private int binarySearch(int[] nums2, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums2[mid] == target && (mid == low || nums2[mid - 1] != nums2[mid])) {
                return mid;
            } else if (target <= nums2[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }



    // using map
    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        // To optimize space, put the smaller array into the map.

        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return intersect1(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();

    To optimize space, put the smaller array into the map.
        for (int a : nums1) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        // Use list since we do not know the final result size;
        List<Integer> list = new ArrayList();

        for (int b : nums2) {
            if (map.containsKey(b)) {
                list.add(b);
                map.put(b, map.get(b) - 1);
                if (map.get(b) == 0) {
                    map.remove(b);
                }
            }

        }

        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
        
    }



    // 2 pointers - not preferred as TC is nlogn + nlogn
    public int[] intersect2Pointers(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return intersect(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList();

        int p1 = 0;
        int p2 = 0;

        while (p1 < m && p2 < n) {
            if(nums1[p1] == nums2[p2]) {
                list.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else {
                p1++;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}