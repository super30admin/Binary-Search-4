//Problem 91: Intersection of Two Arrays II
//TC:O(mlog(n)), where n is the larger array and m is the smaller array
//SC: O(1)

/*
Steps
If the array is sorted, Binary Search on the larger array. Iterate over the smaller array and use smaller array element as the target elemnt and find the first occurence of that element using Binary Search on bigger array which is nums2. If first occurence is found, just move your start pointer to firstOcurIdx+1;. So that next time search can start from next index of the founded index 
*/

import java.util.*;
class Solution91BS{

    //Using BinarySearch
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0) return new int[0];
        
        int n1=nums1.length;
        int n2=nums2.length;
        //Binary Search on the larger array
        if(n1>n2) return intersect(nums2,nums1);
        
        //If array is sorted
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        
        int start=0;
        for(int i=0;i<nums1.length;i++){
            int target = nums1[i];
            //First Occurence from left;
            int firstOcurIdx = getFirstOccurence(nums2,target,start);
            
            if(firstOcurIdx==-1) continue;
            result.add(target);
            //next time dont consider founded firstOcurIdx in the search space
            start = firstOcurIdx+1;
            
        }
        
        int[] arr = new int[result.size()];
        int i=0;
        for(int elem:result){
            arr[i++] = elem;
        }
        
        return arr;
    }

    //First Occurence from left;
    private int getFirstOccurence(int[] nums, int target, int start){
        
        int end = nums.length-1;
        int res =-1;
        while(start<=end){
            
            int mid = start + (end-start)/2;
            
            if(nums[mid]==target){
                res = mid;
                end = mid-1;
            }else if(target>nums[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
            
        }
        return res;
    }


}