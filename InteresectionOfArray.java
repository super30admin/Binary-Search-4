//Time complexity : O(M log M + N log N) + O(M+N) = O(M log M + N log N) //since sorted
//Space complexity: O(1)
//Run on leetcode: Yes
//Any problem: No

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int p1=0, p2=0;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> li = new ArrayList<>();
        
        while(p1<nums1.length && p2<nums2.length){
            if(nums1[p1]==nums2[p2]){
                li.add(nums1[p1]);
                p1++; p2++;
            }
            else if(nums1[p1]<nums2[p2]){
                p1++;
            }
            else{
                p2++;
            }
        }
        int [] result = new int[li.size()];
        for(int i=0; i<li.size(); i++){
            result[i] = li.get(i);
        }
        return result;
    }
}
