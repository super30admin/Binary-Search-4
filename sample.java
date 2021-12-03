class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> result = new ArrayList<>();
        if(nums1 == null || nums2 == null || nums1.length ==0 || nums2.length==0) return new int[0];
        if(nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0; int high = nums2.length -1;
        for(int i = 0;i < nums1.length; i++){
            int bIndex = binarySearch(nums2, low, high, nums1[i]);
            if(bIndex != -1){
                result.add(nums1[i]);
                low = bIndex + 1;
            }
        }
        int []arr = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            arr[i] = result.get(i);
        }
        return arr;
    }
    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) {
                if(mid == low || arr[mid] > arr[mid -1]){
                    return mid;
                } else {
                    high  = mid -1;
                }
            } else if(arr[mid] > target){
                high = mid -1;
            } else{
                low = mid + 1;

            }
        }
        return -1;
    }
}

//O(log(n)) time and no space
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0) return 0.0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2,nums1); //binary search in smaller array
        int low = 0; int high  = n1;
        while(low <= high){
            int partX = low + (high - low ) / 2;
            int partY =( n1 + n2) / 2 - partX;
            double  L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            double  R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double  L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            double  R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            if(L1 <= R2 && L2 <= R1){
                //correct partition
                //find median
                if((n1 + n2) % 2 == 0){
                    return (Math.max(L1, L2) + Math.min(R1,R2)) / 2;
                } else {
                    return Math.min(R1, R2);
                }
            } else if(L1 > R2) {
                high = partX - 1;
            } else {
                low = partX + 1;
            }
        }
        return 0;

    }
}