//time complexity- O(n2)
//space complexity- O(n1)
import java.util.*;
public class IntersectionOfTwoArrays {
    static int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        ArrayList<Integer> li = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(int i : nums2) {
            if(map.containsKey(i)) {
                li.add(i);
                map.put(i, map.get(i) - 1);
                if(map.get(i) == 0) map.remove(i);
            }
        }

        int[] arr = new int[li.size()];
        for(int i = 0; i < li.size(); i++) {
            arr[i] = li.get(i);
        }

        return arr;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        System.out.println("Intersect of array1 " + Arrays.toString(nums1) + " and array2 " + Arrays.toString(nums2) + " is : " + Arrays.toString(intersect(nums1, nums2)));
    }
}
