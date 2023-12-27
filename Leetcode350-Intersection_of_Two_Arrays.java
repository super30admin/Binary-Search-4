//approach - hashmap - build map for the smaller array,
//and run through the arger and build an intermedate list
//tc: O(n1) for  map + O(n2) run over larger array + O(min (n1,n2)) to run through list ~= O(m+n)
//sc: O(min(n1,n2));

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> result = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2)
            return intersect(nums2, nums1);

        // build map for smaller array
        // here n1 is always smaller
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n1; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        // Go over bigger array and build result list
        for (int i = 0; i < n2; i++) {
            if (map.containsKey(nums2[i])) {
                int count = map.get(nums2[i]);
                result.add(nums2[i]);
                count--;

                if (count == 0)
                    map.remove(nums2[i]);
                else
                    map.put(nums2[i], count);
            }
        }

        int[] arr = new int[result.size()];
        int i = 0;
        for (int n : result) {
            arr[i++] = n;
        }

        return arr;
    }
}

/**
 * approah-2
 * consider a sorted arrays, and then apply binary search in the larger array.
 * TC: O(n1 log(n2));
 * sc: O(min(n1,n2)) //only for the ntermediate result list.
 */

// approach - hashmap - build map for the smaller array,a nd run through the
// arger and build an intermedate list

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2)
            return intersect(nums2, nums1);

        int low = 0, high = n2 - 1;
        for (int i = 0; i < n1; i++) {
            int idx = binarySearch(nums1[i], nums2, low, high);
            if (idx != -1) {
                // System.out.println("Added to result : "+nums1[i]);
                result.add(nums1[i]);
                low = idx + 1;
            }
        }

        int[] arr = new int[result.size()];
        int i = 0;
        for (int n : result) {
            arr[i++] = n;
        }

        return arr;
    }

    private int binarySearch(int target, int[] nums, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                if (mid == low || nums[mid] != nums[mid - 1])
                    return mid;
                else
                    high = mid - 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}