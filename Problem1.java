import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Intersection of Two Arrays ii
approach: 2 pointers or sort+binary search
time: O(len(smaller array) log len(bigger array))
space: O(1)
 */
public class Problem1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length>nums1.length) return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l = 0, h = nums1.length-1;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums2.length;i++) {
            int s = binary(nums1, nums2[i], l, h);
            if (s!=-1)
            {
                res.add(nums2[i]);
                l=s+1;
            }
        }
        int[] result = new int[res.size()];

        for(int i=0;i<res.size();i++) {
            result[i] = res.get(i);
        }

        return result;
    }

    private int binary(int[] nums, int target, int l, int h) {
        // l 3 h 3 m 3
        // 1 1 2 2
        // 2 2
        while(l<=h) {
            int m = l+(h-l)/2;

            if(nums[m]==target) {
                if(m==l || nums[m-1]<nums[m]) return m;
                else h = m-1;
            }
            else if(nums[m]>target) {
                h = m-1;
            }
            else {
                l = m+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        problem1.intersect(new int[]{4,9,5},new int[]{9,4,9,8,4});
    }
}
