public class Problem1 {
    class Solution {
        //t.c ->o(mlogm) +O(nlogn)
        //s.c ->O(1) + O(size of result list)
        public int[] intersect(int[] nums1, int[] nums2) {
            if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 ){
                return new int[]{};
            }
            int m = nums1.length;
            int n = nums2.length;
            if(m>n){
                //we're making sure nums1 is smallest;
                return intersect(nums2, nums1);
            }
            //sort both the arrays
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            List<Integer> result = new ArrayList<>();
            int low = 0;
            for(int i =0 ;i<m;i++){
                //find the
                int bs = binarySearch(nums2,low,n-1,nums1[i]);
                if(bs !=-1){
                    result.add(nums1[i]);
                    low = bs+1;
                }
            }
            int[] ans = new int[result.size()];
            for(int i=0;i<result.size();i++){
                ans[i] = result.get(i);
            }
            return ans;
        }
        private int binarySearch(int[] nums, int low, int high, int target){
            while(low<=high){
                int mid = low + (high - low)/2;
                if(nums[mid] == target){
                    if(mid == low || nums[mid-1] != target){
                        return mid;
                    }
                    high = mid -1;
                }
                else if(nums[mid] < target){
                    low = mid + 1;
                }
                else{
                    high = mid-1;
                }
            }
            return -1;
        }
    }
}
