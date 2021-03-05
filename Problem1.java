//Time complexity-O(nlogn + mlogm)
//Space Complexity-O(1)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
     boolean[] visited;
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);//sorting both the array
        int n= nums1.length;
        int m =nums2.length;
        List<Integer> out= new ArrayList<>();
        int p1 =0;
        int p2 =0;
        while(p1<n && p2<m){//checking if the values at p1 and p2 index match
        if(nums1[p1]==nums2[p2]){
            out.add(nums1[p1]);
            p1++;
            p2++;
        }
        else if(nums1[p1]<nums2[p2])
            p1++;
        else
            p2++;
        }
        int[] result = new int[out.size()];
        for(int x=0;x<out.size();x++)
            result[x]=out.get(x);
        
        return result;
   
    }
}