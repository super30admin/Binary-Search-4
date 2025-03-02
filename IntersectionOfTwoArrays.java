// Two pointer Solution
// TC: O(n1 log n1 + n2 log n2) for sorting; O(min(n1, n2)) for intersection
// SC: O(1)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1, n2;
        n1 = nums1.length;
        n2 = nums2.length;


        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] resArray = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            resArray[k] = result.get(k);
        }
        return resArray;
    }
}
