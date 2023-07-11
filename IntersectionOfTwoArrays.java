import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int k = 0;
        for (int i = 0; i < nums2.length; i++) {
            int count = map.getOrDefault(nums2[i], 0);
            if (count > 0) {
                nums1[k++] = nums2[i];
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays solution = new IntersectionOfTwoArrays();

        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };

        int[] result = solution.intersect(nums1, nums2);

        System.out.println("Intersection of Arrays: " + Arrays.toString(result));
    }
}