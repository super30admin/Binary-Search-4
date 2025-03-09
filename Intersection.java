
// Time Complexity : O(mlog(m)+nlog(n)+mlogn) sort arrays and then binary search on larger array
// Space Complexity : O(intersection of m and n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Binary Search
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if(m>n){
            return intersect(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low=0;
        int high=n-1;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<m;i++){
            int target=nums1[i];
            int bsIdx=bs(nums2,low,high,target);
            if(bsIdx!=-1){
                result.add(nums2[bsIdx]);
                low=bsIdx+1;
            }
        }

        int[] res=new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i]=result.get(i);
        }

        return res;
    }

    private int bs(int[] nums,int low,int high,int target){

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==low || nums[mid]>nums[mid-1])
                    return mid;
                else high=mid-1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }

        return -1;
    }
}



