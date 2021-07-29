// Time Complexity : O(Math.min(n1, n2)) //ignored sorting
// Space Complexity : O(n)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if(n1 > n2)
            return intersect(nums2, nums1);
        
        int p1 = 0;
        int p2 = 0;
        
        while(p1 < n1 && p2 < n2){
            if(nums1[p1] == nums2[p2]){
                list.add(nums1[p1]);
                p1++;
                p2++;
            }
            else if(nums1[p1] > nums2[p2])
                p2++;
            else
                p1++;
        }
        
        int[] result = new int[list.size()]; 
        for(int i = 0;i < result.length; i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
}