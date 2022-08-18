// Time Complexity : om(logn) // mis nums1 length and n is nums2 length this is when array is sorted
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
     
        if(n1>n2){
            intersect(nums2,nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int low=0;
        for(int i=0;i<nums1.length;i++){
            int target = nums1[i];
           
            int mindex =binarySearch(nums2,low,nums2.length-1,target); //firstoccurence through binary srch
            if(mindex!=-1){
                result.add(nums2[mindex]);
                low = mindex+1;
            }
        }
        int[] r = new int[result.size()];
        for(int i=0;i<result.size();i++){
            r[i]=result.get(i);
        }
        
        return r;
    }
    
    private int binarySearch(int[] nums,int low,int high,int target){
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid]==target){
                if(mid ==low || nums[mid-1]<nums[mid]){
                    return mid;
                }else{
                    high = mid-1;
                }
            }else if(nums[mid]>target){
                high = mid-1;
            }else{
                low=mid+1;
            }

        }
        return -1;
    }
}