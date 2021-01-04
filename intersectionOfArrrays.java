// Time Complexity : O(MlogM + NlogN) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int low  = 0;
        List<Integer> result = new ArrayList();
        
        for(int i  = 0; i < nums1.length; i++) {
            int loc = binarySearch(nums2, nums1[i], low);
            if(loc < nums2.length && nums2[loc] == nums1[i]) {
                result.add(nums2[loc]);
                low = loc + 1;
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    public int binarySearch(int[] arr, int val, int low) {
        if(low >= arr.length) 
            return arr.length;
        int hi = arr.length - 1;
        int ans = arr.length;
        
        while(low <= hi) {
            int mid = low + (hi - low) / 2;
            if(arr[mid] == val) {
                ans = mid;
                hi = mid - 1;
            }
            else if(arr[mid] < val) {
                low = mid + 1;
            }
            else
                hi = mid - 1;
        }
        return ans;
    }
    
}