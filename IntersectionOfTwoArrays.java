// Time Complexity: O(m + n)
// Space complexity: O(nums1.length) but can be O(min(m, n))

// Approach: Storing frequency of one array and iterating the other
// if there are matching elements; put them in a result list

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            if (frequencyMap.containsKey(num)) {
                res.add(num);
                frequencyMap.put(num, frequencyMap.get(num) - 1);
                if (frequencyMap.get(num) == 0) {
                    frequencyMap.remove(num);
                }
            }
        }

        int[] resArr = new int[res.size()];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = res.get(i);
        }

        return resArr;
    }
}
