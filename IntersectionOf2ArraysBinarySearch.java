
// Time Complexity : O(N)+O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*Approach:
1)iterate on 1st array and carry binary search on 2nd array
2) if(nums[mid]==target)
            {
                if(mid==low || nums[mid]>nums[mid-1])
                {
                    return mid;
                }
                high=mid-1;
    checking for duplicates
*/

import java.util.*;
class IntersectionOf2ArraysBinarySearch {
    public int[] intersect(int[] nums1, int[] nums2) {
       if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0)
       {
           return new int[]{};
       
       }
        
       Map<Integer,Integer> map = new HashMap<>();
        
       if(nums1.length>nums2.length)
       {
           return intersect(nums2,nums1);
       }
        
        // bianry search approach
        
        // iterate on 1st array and carry binary search on 2nd array
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int low =0, high = nums2.length-1;
        
        List<Integer> res = new ArrayList();
        
        for(int i=0;i<nums1.length;i++)
        {
            int target = nums1[i];
            int binaryIndex = binarySearch(nums2, target,low, high);
            if(binaryIndex !=-1)
            {
                res.add(nums1[i]);
                low = binaryIndex +1;
            }
            
        }
        
        int [] resArr = new int[res.size()];
        for(int i=0;i<res.size();i++)
        {
            resArr[i]=res.get(i);
        }
        
        return resArr;
    }
    
    private int binarySearch(int nums[],int target, int low, int high)
    {
        while(low<=high)
        {
            int mid = low+ (high-low)/2;
            if(nums[mid]==target)
            {
                if(mid==low || nums[mid]>nums[mid-1])
                {
                    return mid;
                }
                high=mid-1;
            }
            else if (target>nums[mid])
            {
                low = mid+1;
            }
           else
           {
               high=mid-1;
           }
            
        }
        return -1;
    }
    
}