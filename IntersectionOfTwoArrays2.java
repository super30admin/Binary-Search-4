import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays2 {
    //Time complexity: O(M+N) size of the two arrays
    //Space complexity: O(smaller array size)
    public int[] intersect(int[] nums1, int[] nums2) {

        //find the smaller of the 2 array
        //if we store the smaller array in thr map; this will save space if the arrays were very large
        if(nums2.length < nums1.length) return intersect(nums2, nums1);

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< nums1.length; i++){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+ 1);
        }

        int k = 0;
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i])){
                map.put(nums2[i], map.get(nums2[i])-1);
                if(map.get(nums2[i]) == 0){
                    map.remove(nums2[i]);
                }
                nums1[k++] = nums2[i];
            }

            if(map.size() == 0)break;
        }

        return Arrays.copyOfRange(nums1, 0, k);

    }
}
