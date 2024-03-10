//TimeComplexity : O(log(n-k));
//Space Complexity : O(1)
class Solution {
    int binarySearch(int []arr, int low, int high, int target) {
        while(low <= high) {
            int mid = low+(high-low)/2;
            if(arr[mid] == target) {
                if(mid == low || arr[mid] > arr[mid-1]) {
                    return mid;
                } else {
                   high = mid-1;
                }
            } else if(arr[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return intersect(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> li = new ArrayList<>();
        int low = 0; 
        int high = nums2.length-1;
        for(int i =0; i<nums1.length;i++) {
            int target = nums1[i];
            int bsiIndex = binarySearch(nums2,low,high,target);
            if(bsiIndex != -1) {
                li.add(target);
                low = bsiIndex + 1;
            }
        }
        int []res = new int[li.size()];
        for(int i =0; i<li.size();i++) {
            res[i] = li.get(i);
        }
        return res;
    }
}