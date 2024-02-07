class Solution {
    //TC: O(m+n)
    //SC : O(1)
    //TP solution
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return intersect(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int p1 = 0; int p2 = 0;
        while(p1 < n1 && p2 < n2){
            if(nums1[p1] == nums2[p2]){
                res.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1] < nums2[p2]) p1++;
            else p2++;
        }
        
        int [] result = new int[res.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = res.get(i);
        }
        return result;
    }
}