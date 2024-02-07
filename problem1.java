// Time Complexity : O(m log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*check if each element in first array exists in second array using binary search.
If present, store it in a new list and change the search space to present index + 1, so it doesn't include that element again. 
If not present, change l and h and call binary search on other elements in first array. 
 * 
 */
class problem1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(m > n)
            return intersect(nums2, nums1);
        int l = 0;
        int h = n - 1;
        for(int i = 0; i < m; i++){
            int bsIdx = binarySearch(nums2, l, h, nums1[i]);
            if(bsIdx != -1){
                li.add(nums1[i]);
                l = bsIdx + 1;
            }
        }
        int[] arr = new int[li.size()];
        for(int i = 0; i < li.size(); i++){
            arr[i] = li.get(i);
        }
        return arr;
    }
    private int binarySearch(int arr[], int l, int h, int target){
        while(l <= h){
            int mid = l + (h-l)/2;
            if(arr[mid] == target){
                if(mid > l && arr[mid] == arr[mid-1]){
                    h = mid - 1;
                }
                else {
                    return mid;
                }
            }
            else if(arr[mid] > target){
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return -1;
    }
}