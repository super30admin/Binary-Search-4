// Time Complexity: O(mlgn)
// Space Complexity: O(1)

class Solution1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if( m > n ) {
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0;
        int high = n-1;
        List<Integer> li = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            int bsidx = binarySearch(nums2, low, high, nums1[i]);
            if( bsidx != -1) {
                li.add(nums1[i]);
                low = bsidx + 1;
            }
        }
        int[] result = new int[li.size()];
        for(int i = 0; i < li.size(); i++) {
            result[i] = li.get(i);
        }
        return result;
    }

    private int binarySearch(int[] arr, int low, int high, int target) {
        while( low <= high ) {
            int mid = low + (high-low)/2;
            if( arr[mid] == target ) {
                if( mid > low && arr[mid] == arr[mid-1] ) {
                    high = mid-1;
                } else {
                    return mid;
                }
            } else if ( arr[mid] > target) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}