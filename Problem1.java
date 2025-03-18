// Binary Search
// TC: O(mlog(n) + mlog(m) + nlog(n)) >> sorting: mlog(m) + nlog(n)
// SC: O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return null;
        int m = nums1.length; //smaller
        int n = nums2.length;
        //we want m < n
        if(m > n){
            intersect(nums2, nums1);
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0;
        int high = n - 1;
        for(int i = 0; i < m; i++){
            //gives 1st occurance of target
            int bSearch = bs(nums2, nums1[i], low, high);
            if(bSearch != -1){
                result.add(nums1[i]);
                low = bSearch + 1;
            }
        }

        int[] ans = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            ans[i] = result.get(i);
        }
        return ans;
    }

    public int bs(int[] nums, int target, int left, int right){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                if(mid == left || nums[mid - 1] != target){
                    return mid;
                }
                right = mid - 1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}


// Brute Force:
// TC: O(m x n) SC: O(1) > convert found element to 1001
// HashMap: O(m + n) SC:O(min of m, n)
// Freq arr: O(m + n) SC: O(min of m, n)
// Sorting: O(m + n + mlog(m) + nlog(n)) SC:O(1)
