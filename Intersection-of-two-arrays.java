//binary search solution
//time - O(nlogm) n - length of smaller array, m - length of larger array
//space - O(result.length)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null) return new int[]{};
        List<Integer> result = new ArrayList<>();
        if(nums2.length < nums1.length) intersect(nums2,nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int low = 0, high = nums1.length-1;

        for(int i=0; i<nums2.length; i++){
            int binarySearchIndex = binarySearch(nums1, low, high, nums2[i]);
            if(binarySearchIndex != -1){
                result.add(nums1[binarySearchIndex]);
                low = binarySearchIndex+1;
            }
        }

        int[] res = new int[result.size()];

        for(int i=0; i<result.size(); i++){
            res[i] = result.get(i);
        }

        return res;
    }

    private int binarySearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid==low || nums[mid-1] < nums[mid]){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}
