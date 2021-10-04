// Time Complexity: O(nlog(n)+log(k))
// Space: O(1)
// Idea here is to run 2 pointer on both arrays simultaneously until one of them completes
// if the value is same add to result or else increment pointer for lower value
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        if(nums1 == null || nums2==null || nums1.length==0 || nums2.length==0) return new int[0];
        if(nums1.length>nums2.length) return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pt1=0; int pt2=0;
        while(pt1<nums1.length && pt2<nums2.length) {
            if(nums1[pt1]==nums2[pt2]) {
                result.add(nums1[pt1]);
                pt1++;
                pt2++;
            } else if(nums1[pt1]<nums2[pt2]) {
                pt1++;
            } else {
                pt2++;
            }
        }
        int[] arr = new int[result.size()];
        for(int i=0; i<result.size();i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}