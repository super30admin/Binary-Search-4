import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionTwoArrays {

    /*
    TC : O(n+m) where n and m are the length of the two arrays
    SC :O(n)
    LC : yes
    Problems : No
     */

    /**
     * The approach is to iterate over one of the arrays and create a map with elements and their count
     * Then iterate over the second array, if the we find an element then add it to result list and decrease the count by 1
     * When the count reaches 0, remove the element
     *
     * @param nums1
     * @param nums2
     * @return
     */

    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2)
            return intersect(nums2, nums1);
        List<Integer> result = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap<>();

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

        int[] returnArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            returnArr[i] = result.get(i);

        return returnArr;
    }

}
