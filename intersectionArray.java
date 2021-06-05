import java.util.Arrays;
import java.util.HashMap;

// Time Complexity : O(m+n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach



public class intersectionArray {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        // hashmap Solution
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);

         /*   // Two pointer solution
       
       if(nums1 == null || nums1.length == 0 || nums2.length == 0 || nums2.length == 0)
            return new int[]{-1};

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n = nums1.length;
        int m = nums2.length;

        int p1 = 0;
        int p2 = 0;
        List<Integer> result = new ArrayList<>();
        while(p1 < n && p2 < m){
            if(nums1[p1] == nums2[p2]){
                result.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1] < nums2[p2])
                p1++;
            else
                p2++;
        }

        int[] output = new int[result.size()];
        for(int i = 0; i < output.length; i++){
            output[i] = result.get(i);
        }
        return output;
       
       
       
       */
       


    }
}
