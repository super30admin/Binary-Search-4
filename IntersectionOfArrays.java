// Time Complexity : O(nlogn +mlogn +mlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : sort both arrays. Iterate through smallest array, for each element get the index of that element in
/// in second array from start(initially 0), if present add to result, update start to next index of key in second array
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length){
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int start =0;
        for(int i=0;i<nums1.length;i++){
            int j = binarySearch(nums2, start, nums1[i]);
            if(j!=-1){
                start=j+1;
                result.add(nums1[i]);
            }
        }    
        int res[] = new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i] = result.get(i);
        }                                                             
        return res;
    }
    private int binarySearch(int arr[], int start, int key){
        int low = start, high = arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==key){
                if(mid==start || arr[mid-1]!=key)
                    return mid;
                else{
                    high=mid-1;
                }
            }
            else if(arr[mid]>key){
                high = mid-1;
            }
            else{
                low= mid+1;
            }
        }
        return -1;
    }
}