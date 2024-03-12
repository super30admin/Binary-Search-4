// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class Solution {
    List<Integer> result;

    public int[] intersect(int[] nums1, int[] nums2) {
        result = new ArrayList<>();

        // helperHashMap(nums1, nums2);
        // helperBruteForce(nums1, nums2);
        // helperTwoPtr(nums1, nums2);
        helperBs(nums1, nums2);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    //Tc: O(nlog(n) + mlog(m) + m + log(n)) [n: bigger array; m: smaller array]
    //Sc: O(1)
    private void helperBs(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n2 > n1) {
            helperBs(nums2, nums1);
            return;
        }

        int low = 0;
        int high = n1 -1;
        for(int i = 0; i< n2; i++) {
            int target = nums2[i];
            int bsIdx = binarySearch(nums1, low, high, target);
            if(bsIdx != -1) {
               result.add(nums1[bsIdx]);
               low = bsIdx + 1;
            }
        }

    }

    private int binarySearch(int nums1[], int low, int high, int target) {
        if(low < 0 || high >= nums1.length) {
            return -1;
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums1[mid] == target) {
                //left most
                if(mid == low || nums1[mid] > nums1[mid -1]) {
                    return mid;
                } else {
                    high = mid -1;
                }
            }else if(nums1[mid] > target) {
                high = mid -1;
            } else {
                low  = mid +1;
            }
        }

        return -1;
    }

    //Tc: O(nlog(n) + mlog(m) + m + n) [n: bigger array; m: smaller array]
    //Sc: O(1)
    private void helperTwoPtr(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int ptr1 = 0;
        int ptr2 = 0;

        while (ptr1 != nums1.length && ptr2 != nums2.length) {

            int num1 = nums1[ptr1];
            int num2 = nums2[ptr2];

            if (num1 > num2) {
                ptr2++;
            } else if (num2 > num1) {
                ptr1++;
            } else {
                result.add(num1);
                ptr1++;
                ptr2++;
            }
        }

    }

    //Tc: O(n * m) [n: bigger array; m: smaller array]
    //sc: O(1)
    private void helperBruteForce(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n2 > n1) {
            helperBruteForce(nums2, nums1);
            return;
        }

        for (int i : nums2) {
            int index = indexOf(nums1, i);
            if (index != -1) {
                result.add(i);
                nums1[index] += 2000;
            }
        }

    }

    private int indexOf(int[] nums1, int target) {
        return IntStream.range(0, nums1.length).filter(i -> nums1[i] == target).findFirst().orElse(-1);
    }

    //Tc: O(n + m) [n: bigger array; m: smaller array]
    //sc: O(m)
    private void helperHashMap(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n2 > n1) {
            helperHashMap(nums2, nums1);
            return;
        }

        Map<Integer, Integer> frqMap = new HashMap<>();

        for (int i : nums2) {
            frqMap.put(i, frqMap.getOrDefault(i, 0) + 1);
        }

        for (int i : nums1) {
            if (frqMap.containsKey(i)) {
                frqMap.put(i, frqMap.get(i) - 1);
                frqMap.remove(i, 0);
                result.add(i);
            }
        }
    }
}