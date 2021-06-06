import java.util.*;

public class IntersectionOfTwoArray {

    public int[] intersectBF(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        HashSet<Integer> result = new HashSet();
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                result.add(nums1[p1]);
                p1++;
                p2++;
            } else {
                if (nums1[p1] < nums2[p2]) {
                    p1++;
                } else {
                    p2++;
                }
            }
        }
        int[] resultArray = new int[result.size()];
        int i = 0;
        for(Integer item: result) {
            resultArray[i] = item;
            i++;
        } 
        return resultArray;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArray intersectionOfTwoArray = new IntersectionOfTwoArray();
        int[] result = intersectionOfTwoArray.intersectBF(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        System.out.println("The result is"+ Arrays.asList(result));
    }
}