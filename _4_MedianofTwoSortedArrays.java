// Time Complexity : olog(min(n,m)) where n and m are lengtn of arrays
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// divede the two arrays simulteniously in such sa way that number if elements on the left halves of array is equal to right halves 
class Solution {

  class Solution {
      public double findMedianSortedArrays(int[] nums1, int[] nums2) {

          if(nums1.length > nums2.length){
              return findMedianSortedArrays(nums2, nums1);
          }

          int start = 0 ;
          int end = nums1.length;

          while(start <= end){

              int px = start + (end - start)/2;
              int py = (nums1.length + nums2.length)/2  - px ;

              int x1 = px == 0 ? Integer.MIN_VALUE : nums1[px-1] ;
              int x2 = px == nums1.length ? Integer.MAX_VALUE : nums1[px];

              int y1 = py == 0 ? Integer.MIN_VALUE : nums2[py-1] ;
              int y2 = py == nums2.length ? Integer.MAX_VALUE : nums2[py];

              if(x1<= y2 && y1<= x2){

                  if((nums1.length + nums2.length)%2==0){
                      return (Math.max(x1,y1) + Math.min(x2, y2))/2.0;
                  }
                  else{
                      return Math.min(x2, y2);
                  }

              }
              else if(x1 > y2 && y1<= x2){
                  end = px-1;
              }
              else if(x1<=y2 && y1> x2){
                  start = px+1;
              }
              /*else if (x1> y2 && y1> x2){
                  // NOt possible since nums1 and nums2 are sorted in ascending order
                  proof : if( x1 > y2)
                      x2 > x1 > y2 > y1 so y1 < x2

              }*/
          }

          return -1;

      }
  }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int start = 0 ;
        int end = nums1.length;

        while(start <= end){

            int px = start + (end - start)/2;
            int py = (nums1.length + nums2.length + 1)/2  - px ;

            int x1 = px == 0 ? Integer.MIN_VALUE : nums1[px-1] ;
            int x2 = px == nums1.length ? Integer.MAX_VALUE : nums1[px];

            int y1 = py == 0 ? Integer.MIN_VALUE : nums2[py-1] ;
            int y2 = py == nums2.length ? Integer.MAX_VALUE : nums2[py];

            if(x1<= y2 && y1<= x2){

                if((nums1.length + nums2.length)%2==0){
                    return (Math.max(x1,y1) + Math.min(x2, y2))/2.0;
                }
                else{
                    return Math.max(x1, y1);
                }

            }
            else if(x1 > y2 && y1<= x2){
                end = px-1;
            }
            else if(x1<=y2 && y1> x2){
                start = px+1;
            }
            /*else if (x1> y2 && y1> x2){
                // NOt possible since nums1 and nums2 are sorted in ascending order
                proof : if( x1 > y2)
                    x2 > x1 > y2 > y1 so y1 < x2

            }*/
        }

        return -1;

    }
}
