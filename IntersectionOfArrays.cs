Time: O(nlogn)+O(mlogm) for sorting
space: O(length of intersection elements)
leetcode: yes

public class Solution {
    public int[] Intersect(int[] nums1, int[] nums2) {
        int n = nums1.Length;
        int m = nums2.Length;
        if(n > m) return Intersect(nums2, nums1);
        Array.Sort(nums1);
        Array.Sort(nums2);
        int n1 = 0;
        int n2 = 0;
        var result = new List<int>();
        while(n1 < n && n2 < m){
            if(nums1[n1] == nums2[n2]){
                result.Add(nums1[n1]);
                n1++; n2++;
            } else if(nums1[n1] < nums2[n2]){
                n1++;
            }else
                n2++;
        }
        return result.ToArray();
    }
}
