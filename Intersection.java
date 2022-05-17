import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {

    // 2 pointer solution
    // TC: O(m * log m + n * log n + m + n) = O(m * log m + n * log n)
        //  m - nums1.length   n - nums2.length
    // SC: O(1)
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[]{};

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        int p1 = 0, p2=0;

        while(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] == nums2[p2]){
                result.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1] < nums2[p2]){
                p1++;
            }else {
                p2++;
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue).toArray();
    }
}
