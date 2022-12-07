import java.util.*;

class Problem1 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int a = 0, b = 0;
        List<Integer> result = new ArrayList<>();
        while (a < nums1.length && b < nums2.length) {
            if (nums1[a] == nums2[b]) {
                result.add(nums1[a]);
                a++;
                b++;
            } else if (nums1[a] > nums2[b])
                b++;
            else
                a++;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2, 2, 1 };
        int[] nums2 = new int[] { 2, 2 };
        int[] nums3 = intersect(nums1, nums2);
        System.out.print("[");
        for (int i = 0; i < nums3.length; i++) {
            if(i != nums3.length - 1)
                System.out.print(nums3[i] + ",");
            else
                System.out.print(nums3[i]);
        }
        System.out.print("]");
    }
}