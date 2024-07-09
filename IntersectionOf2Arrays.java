/***
 Using Binary Search
 TC - O(mlogm + nlogn)
 SC - O(min(m,n))
 */
class IntersectionOf2Arrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)
            return new int[]{};

        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        //Sort Arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int m = nums1.length;
        int n = nums2.length;

        if(m < n)
            return intersect(nums2, nums1);

        int low =0, high = n-1;

        for(int num : nums1) {
            int bsIndex = BinarySearch(nums2, low, high, num);

            if(bsIndex != -1) {
                result.add(num);
                low = bsIndex+1;
            }
        }

        int[] arr = new int[result.size()];
        int i =0;
        for(int num : result) {
            arr[i++] = num;
        }

        return arr;

    }

    private int BinarySearch(int[] arr, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high-low)/2;

            if(arr[mid] == target) {
                if(mid == low || arr[mid-1] != target)
                    return mid;

                high = mid-1;
            }

            else if(arr[mid] < target) {
                low = mid+1;
            }

            else{
                high = mid-1;
            }
        }

        return -1;
    }
}