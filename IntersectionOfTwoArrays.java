
// Time Complexity : O(Max(m,n) for sortong and O(min(m,n)) where m and n are the lenghts of nums1 and nums2 respectively
// Space Complexity :O(1) as we are not usign any extra space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      
      //sort both the input arrays
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      
      //list to store the elements that are same in both the arrays
      List<Integer> list = new ArrayList<>();
      
      int p1=0,p2=0;
      
      while(p1<nums1.length && p2<nums2.length)
      {
        if(nums1[p1]<nums2[p2])
        {
          p1++;
        }
        
        else if(nums1[p1]>nums2[p2])
        {
          p2++;
        }
        //both arrays have same element add it to the list
        else
        {
          list.add(nums1[p1]);
          p1++;
          p2++;
        }
      }
      //convert the list to array
      int[] result = new int[list.size()];
      for(int i=0;i<result.length;i++)
      {
        result[i]=list.get(i);
      }
        
      return result;
    }
}