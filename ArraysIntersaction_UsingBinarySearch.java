// Time Complexity :O(mlogn) n = length of array1 m = length of array2
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach

// search smaller arrays element in other array by setting low and high index
// make a binarysearch function which will return an index where element matches (will return -1 if element doesn't exist) set low = retrunIndex +1; and start searching the next element from low to high using binarysearch function repeat it for all element


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        if(nums1 == null || nums1.length == 0 || nums2 == null | nums2.length ==0)
            return new int[0];
        
        if(nums2.length > nums1.length) 
        {
            // make sure the first array is big1
          return intersect(nums2,nums1);
        }
        // imagine if given arrays are sorted 
        Arrays.sort(nums1); Arrays.sort(nums2);
       
       int low = 0; int high = nums1.length-1;
        
        for( int i =0 ; i < nums2.length; i++)
        {
           // for every element's search reinstialize the low for that get bIndex and set low = bIndex+1;
            int bIndex = binarySearch(nums1,  low, high, nums2[i]);
                if(bIndex != -1)
                {
                    result.add(nums2[i]);
                    low = bIndex +1;
                }
          
        } 
    
        int[] arr = new int[result.size()];
         for(int i = 0 ; i < result.size();i++ )
        {
            arr[i] = result.get(i);
        }
        return arr;
    }
    
    private int binarySearch(int[] arr, int l, int h, int target)
    {
        while(l<=h)
        {
            int mid = l +(h-l)/2;
            if(arr[mid] == target)
                if(mid == l || arr[mid] > arr[mid-1])
                    return mid;
                else h = mid-1;
            else if(target > arr[mid] )
                l = mid+1;
            else
                 h = mid-1;
        }
        
        return -1;
    }
}