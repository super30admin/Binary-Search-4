// TC : O(nlogn + mlogm)
// SC : O(1)
// Two Pointer Solution
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 ||
            nums2 == null || nums2.length == 0) return null;
        int n = nums1.length;
        int m = nums2.length;
        
        if(n < m)
            return intersect(nums2, nums1);
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();

        int low = 0;
        int high = 0;
        
        while(low < nums2.length && high < nums1.length) {
            
            if(nums2[low] == nums1[high]) {
                res.add(nums2[low]);
                low++;
                high++;
            }
                
            
            else if(nums2[low] < nums1[high])
                low++;
            
            else
                high++;
        }
        
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
            result[i] = res.get(i);
        
        return result;
    }
    
    
}
