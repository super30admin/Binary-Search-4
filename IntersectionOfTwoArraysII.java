import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysII {
    //Method - 2
    //tc : O(mlogm + nlogn)
    //sc : O(1)
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else
                j++;
        }

        int ans[] = new int[res.size()];
        int k = 0;
        for (int n : res) {
            ans[k++] = n;
        }
        return ans;
    }
    //Method - 1
    //tc : O(m + n)
    //sc : O(m + n)
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : nums2) {
            if (map.containsKey(i)) {
                if (map.get(i) > 0) {
                    map.put(i, map.get(i) - 1);
                    res.add(i);
                }
            }
        }

        int[] arr = new int[res.size()];
        for(int c=0; c<arr.length; c++){
            arr[c] = res.get(c);
        }
        return arr;
    }
}
