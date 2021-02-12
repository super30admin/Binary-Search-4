// Time Complexity : O(log(min(m,n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Intersection2Arrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        //edge
        if(nums1 == null || nums2 == null){
            return new int[0];
        }
        if(nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        int short = nums1.length;
        int long = nums2.length;
        if(long < short) return intersect(nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> res = new ArrayList<>();

        int low = 0;
        //loop thru smaller, binary search through bigger
        for(int i = 0; i < short; i++){
            int idx = binarySearch(nums2, nums1[i], low, long-1);

            if(idx != -1){
                res.add(nums1[i]);
                //move the low pointer so that we dont access the same index agian in later binary search
                low = idx + 1;
            }
        }

        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }

    private int binarySearch (int [] nums, int target, int low, int high){

        while(low <= high){

            int mid = low + (high - low)/2;

            if(nums[mid] == target){
                //if mid is low or curr mid is too big
                if(mid == low || nums[mid] > nums[mid - 1]){
                    return mid;
                }
                //move left to smaller num
                else{
                    high = mid - 1;
                }
            }
            //if element is on the left, move high to less than mid
            else if(nums[mid] > target){
                high = mid - 1;
            }
            //if on the right, move low above mid
            else{
                low = mid + 1;
            }
        }
        //if not in nums
        return -1;
    }
}