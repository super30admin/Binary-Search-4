// Time Complexity :O(m + n ) n = length of array1 m = length of array2
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach

// imagine both arrays are sorted 
//using two pointers take p1 =0 and p2 =0 if element at p1 and p2 are equal add it to result and increase p1 n p2 by 1
//else  if element at [p1] < [p2] inc p1 else inc p2;


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
         int p1 =0;
        int p2 = 0;
        
        while(p2 <= nums2.length-1 && p1 <= nums1.length-1 )
        {
            if(nums1[p1] == nums2[p2])
            {
                result.add(nums2[p2]);
                p1++;p2++;
            }
            else if( nums1[p1] < nums2[p2])
                p1++;
            else p2++;
        }
        
        int[] arr = new int[result.size()];
         for(int i = 0 ; i < result.size();i++ )
        {
            arr[i] = result.get(i);
        }
        return arr;
    }
}