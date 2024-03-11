package week7.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TC - O(n log m) ,where m- big array
//SC - O(1)
class Solution10 {
  public int[] intersect(int[] nums1, int[] nums2) {
      int n1 = nums1.length;
      int n2 = nums2.length;
      if (n1 > n2)
          return intersect(nums2, nums1);

      // sorting arrays
      Arrays.sort(nums1);
      Arrays.sort(nums2);

      int low = 0;
      int high = n2 - 1; //use biggest array-1
      List<Integer> result = new ArrayList<>();
      for (int target : nums1) {
          int BSindex = binarySearch(nums2, low, high, target);
          if (BSindex != -1) {  //if no elt is found, return -1
              result.add(target);
              low = BSindex + 1;
          }
      }
      int[] output = new int[result.size()];
      for (int i = 0; i < result.size(); i++) {
          output[i] = result.get(i);
      }
      return output;
  }

  private int binarySearch(int[] nums2, int low, int high, int target) {
      while (low <= high) {
          int middle = low + (high - low) / 2;
          if (nums2[middle] == target) {
              // first occurrence
              if (middle == low || nums2[middle] > nums2[middle - 1]) 
                  return middle;
              else
                  high = middle - 1;
          } else if (nums2[middle] > target)
              high = middle - 1;
          else
              low = middle + 1;
      }

      return -1;
  }
}
/**
* Approach 1
* Use hashmap to store the no and it's frequnecy
* iterate over secondary array (large) and check it in hashmap.
* If element is found in map, reduce the frequency. Add it to result list.
* if frequency is 0, remove it. map.remove(num,0) - removes num and key if 0.
* if we completed traversing bigger array, return result
* TC - O(n+m)
* SC -O(m)
* 
* Approach 2
* Two pointer
* 1. Sort array
* 2. Two pointers p1, p2. p1 - bigger array
* 3. if p1==p2, p1++, p2++, add arr[p1] to result
* 4. if p1!=p2 and p1<p2, p1++
* 5. p1>p2 p2++
* 6. If p1 or p2 reaches out of bound, exit
* TC - O(n+m)
* SC -O(1)
*/
public class IntersectionOfArrays_Binarysearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
