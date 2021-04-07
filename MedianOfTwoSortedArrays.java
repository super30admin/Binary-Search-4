
// Time Complexity : O(log(min(m,n))) where m and n are lengths of the input arrays 
// Space Complexity :O(1) as we are not usign any extra space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach


class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      
      // keeping nums1 as the one with smaller length
      if(nums1.length>nums2.length)
      {
        return findMedianSortedArrays(nums2,nums1);
      }
      
      int l = 0;
      int r = nums1.length;
      
      int combinedLength = nums1.length + nums2.length;
      
      while(l <= r)
      {
        int partX = l+(r-l)/2;
        int partY = (combinedLength+1)/2 - partX;
        //get left element from the partition in nums1
        int leftX = getMax(nums1,partX);
        //get right element from the partition in nums1
        int rightX= getMin(nums1,partX);
        
        //get left element from the partition in nums2
        int leftY = getMax(nums2,partY);
        //get right element from the partition in nums2
        int rightY = getMin(nums2,partY);
        
        //condition where the complete left of x and y has smaller elements than complete right of x and y
        if(leftX <= rightY && leftY <= rightX)
        {
        	//if we have total no of elements even
          if(combinedLength%2 == 0)
          {
            return (Math.max(leftX,leftY) + Math.min(rightX,rightY))/2.0;
          }
          
          return Math.max(leftX,leftY);
        }
        //not sorted so we shift the partition
        if(leftX > rightY)
        {
          r = partX -1;
        }
        else
        {
          r = partX +1;
        }
      }
        return -1;
    }
  
    private int getMax(int[] nums,int partition)
    {
      if(partition == 0)
      {//if it goes out of bound on the left hand side
        return (int)Double.NEGATIVE_INFINITY;
      }
      else
      {
        return nums[partition-1];
      }
    }
  
   private int getMin(int[] nums,int partition)
    {
      if(partition == nums.length)
      {//if it goes out of bound on the right hand side
        return (int)Double.POSITIVE_INFINITY;
      }
      else
      {
        return nums[partition];
      }
    }
}