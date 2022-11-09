// TC : O(nlogn + mlogm)
// SC : O(1)
// Binary Search Solution
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
        int high = n - 1;
        for(int i = 0; i < m; i++) {
            int x = binarySearch(nums1, low, high, nums2[i]);
            if(x != -1) {
                low = x + 1;
                res.add(nums2[i]);
            }
        }
        
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++)
            result[i] = res.get(i);
        
        return result;
    }
    
    private int binarySearch(int[] arr, int low, int high, int x) {
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(arr[mid] == x) {
                if(mid == low || arr[mid - 1] < arr[mid])
                    return mid;
                high = mid - 1;
            }
            else if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
