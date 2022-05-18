import java.util.*;

public class Problem1 {
    //TC : O (mlog m + nlog n)
    //SC : O (n)
    // two pointer solution
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        if (nums2.length < nums1.length) return intersect(nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                result.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    //TC : O (m + n)
    //SC : O (min (m, n))
    // map solution

    public int[] intersect2(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        if (nums2.length < nums1.length) return intersect2(nums2, nums1);
        List<Integer> result = new ArrayList<>();
        //map solution
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num)) {
                result.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    //TC : O (mlog m + n log n)
    //SC : O (min (m, n))
    // binary search solution
    public int[] intersect3(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        if (nums2.length < nums1.length) return intersect3(nums2, nums1);
        List<Integer> result = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0;
        int high = nums2.length - 1;
        for (int i = 0; i < nums1.length; i++) {
            int biIndex = binarySearch(nums1[i], nums2, low, high);
            if (biIndex != -1) {
                low = biIndex + 1;
                result.add(nums1[i]);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    private int binarySearch(int target, int[] nums2, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums2[mid] == target) {
                if (mid == low || nums2[mid - 1] < nums2[mid]) {
                    return mid;
                }
                high = mid - 1;

            } else if (nums2[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
