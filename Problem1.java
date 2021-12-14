//Time Complexity: O(m log n) where m>n if arrays are sorted
//Space Complexity: O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(nums1.length > nums2.length){
            int []temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }

        List<Integer> res = new ArrayList<>();
        int low = 0;
        for(int i=0;i<nums1.length;i++){
            low = binarySearch(nums2,low, nums2.length,nums1[i]);
            if(low >= nums2.length)
                break;
            if(nums2[low] == nums1[i]){
                res.add(nums1[i]);
                low++;
            }
        }
        int result[] = new int[res.size()];
        low = 0;
        for(int i:res)
            result[low++] = i;
        return result;
    }

    public int binarySearch(int []nums, int low, int high, int target){
        int mid;
        while(low<high){
            mid = low + (high-low)/2;

            if(nums[mid]<target)
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }
}