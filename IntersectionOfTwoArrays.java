class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null || nums1.length == 0 || nums2.length == 0){
            return null;
        }

        int m = nums1.length;
        int n = nums2.length;
        if(m>n){
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int low = 0;
        for(int i=0; i<m; i++){
            int idx = binarySearch(nums2, low, n-1, nums1[i]);
            if(idx!=-1){
                result.add(nums1[i]);
                low = idx + 1;
            }
        }

        int[] arr = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            arr[i] = result.get(i);
        }
        return arr;
    }

    private int binarySearch(int[] nums, int l, int h, int target){
        while(l<=h){
            int mid = l + (h-l)/2;
            if(nums[mid] == target){
                if(mid == l || nums[mid-1]!= target){
                    return mid;
                }
                h=mid - 1;
            } else if (nums[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
