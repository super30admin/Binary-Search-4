class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> List = new ArrayList<>();
        int index = 0;
        for(int i = 0;i< nums1.length;i++){
            int location = binarySearch(nums2,index,nums1[i]);
            if(location<nums2.length && nums2[location] == nums1[i]){
                List.add(nums1[i]);
                index = location+1;
            }
        }
        int[] result = new int[List.size()];
        int i = 0;
        for(int ele: List){
            result[i++] = ele;
        }
        return result;
    }
    public Integer binarySearch(int[] nums,int index,int target){
        int left = index;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]<target) left = mid+1;
            else right = mid-1;
        }
    return left;
    }
}