//Approach- Create a partition between the nums1 and nums2 arrays initially by their length/2;
// then try to move the partition1 and partition2 points till all the elements
// in the left size of both the partitions are smaller than
//  all the elements of right side of both partitions
//Time Complexity - O(log(min(m,n))) - where m - length of nums1, n - length of nums2
//Space Complexity - O(1)

class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    if(nums1 == null && nums2 == null){
      return 0.0;
    }

    int n1 = nums1.length;
    int n2 = nums2.length;

    if(n1 > n2){
      return findMedianSortedArrays(nums2,nums1);
    }


    int low = 0, high = n1;
    int part1 = low + (high-low)/2;
    int part2 =  (n1+n2)/2 - part1;

    while(low <= high){

      double l1 = part1 == 0 ? Integer.MIN_VALUE : nums1[part1-1];
      double l2 = part2 == 0 ? Integer.MIN_VALUE : nums2[part2-1];
      double r1 = part1 == n1 ? Integer.MAX_VALUE : nums1[part1];
      double r2 = part2 == n2 ? Integer.MAX_VALUE : nums2[part2];

      if(l1 <= r2 && l2 <= r1){
        if((n1+n2)%2 == 0){
          return (Math.max(l1,l2) + Math.min(r1,r2)) /2;
        }
        else{
          return Math.min(r1,r2);
        }
      }

      if(l1 > r2){
        part1--;
        part2++;
      }
      else{
        part1++;
        part2--;
      }
    }
    return 0.0;
  }
}
