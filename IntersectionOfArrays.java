import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TC: O(m + n), SC: O(min(m,n))
public class IntersectionOfArrays {

    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2) return intersect(nums2, nums1);

        final Map<Integer, Integer> frequency = new HashMap<>();
        final List<Integer> output = new ArrayList<>();

        for (int num : nums1) frequency.put(num, frequency.getOrDefault(num, 0) + 1);

        for (int num: nums2) {
            if (frequency.containsKey(num)) {
                output.add(num);
                frequency.put(num, frequency.getOrDefault(num, 0) - 1);
                frequency.remove(num, 0);
            }
        }

        return output.stream().mapToInt(Integer::intValue).toArray();
    }
}
