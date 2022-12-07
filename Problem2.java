import java.util.*;

public class Problem2 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int center = len % 2 != 0 ? (len / 2) + 1 : (len / 2) + 1;
        int a = 0, b = 0;
        List<Integer> list = new ArrayList<>();
        while (center > 0 && a < nums1.length && b < nums2.length) {
            if (nums1[a] > nums2[b]) {
                list.add(nums2[b]);
                b++;
            } else {
                list.add(nums1[a]);
                a++;
            }
            center--;
        }
        while (a < nums1.length && center != 0) {
            list.add(nums1[a]);
            a++;
            center--;
        }
        while (b < nums2.length && center != 0) {
            list.add(nums2[b]);
            b++;
            center--;
        }
        double last = list.get(list.size() - 1);
        double secondL = len % 2 != 0 ? 0 : list.get(list.size() - 2);
        return len % 2 != 0 ? last : (last + secondL) / 2;
    }
    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2 };
        int[] nums2 = new int[] { 3 };
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.print(median);
    }
}
