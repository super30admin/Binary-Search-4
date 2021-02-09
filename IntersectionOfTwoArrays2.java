// TC: O(m+n)
// SC : O(min(m,n))
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//        int n1 = nums1.length;
//        int n2 = nums2.length;
//        if ( n1 > n2)
//          return intersect(nums2, nums1);
//        HashMap<Integer, Integer> map = new HashMap();
//     // store the smaller array in hashmap
//        List<Integer> list = new ArrayList();
//        for ( int num : nums1)
//        {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//     // iterate through the bigger array
//        for ( int num : nums2)
//        {
//            if (map.containsKey(num))
//            {
//                map.put(num, map.get(num) - 1);
//                map.remove(num, 0);
//                list.add(num);
//            }
//        }
//        // convert the list of integers into result int[] array
//        int[] result = new int[list.size()];
//        for ( int i = 0; i < result.length; i++)
//        {
//            result[i] = list.get(i);
//        }
//         return result;
//   }
// }

// 2 pointers
// TC: O(m+n)
// SC: O(1)
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//        int n1 = nums1.length;
//        int n2 = nums2.length;
//        if ( n1 > n2)
//          return intersect(nums2, nums1);
//         int p1 = 0;
//         int p2 = 0;
//         List<Integer> list = new ArrayList();
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);
//         while ( p1 < n1 && p2 < n2)
//         {
//             if (nums1[p1] == nums2[p2])
//             {
//                 list.add(nums1[p1]);
//                 p1++;
//                 p2++;
//             }
//             else if (nums1[p1] < nums2[p2])
//             {
//                 p1++;
//             }
//             else
//             {
//                 p2++;
//             }
//         }
//       // convert the list of integers into result int[] array
//        int[] result = new int[list.size()];
//        for ( int i = 0; i < result.length; i++)
//        {
//            result[i] = list.get(i);
//        }
//         return result;
//     }
// }


// Binary Search
// TC: O(mlogn)
// SC: O(1)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if ( n1 > n2)
            return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0;
        int high = n2 - 1 ;
        List<Integer> list = new ArrayList();
        // Iterate on the smaller array
       for (int i = 0; i < nums1.length; i++)
       {
          int bIndex = binarySearch(nums2, nums1[i], low, high);
          if (bIndex != -1)
          {
              list.add(nums1[i]);
              low = bIndex + 1;
          }
       }
      // convert the list of integers into result int[] array
       int[] result = new int[list.size()];
       for ( int i = 0; i < result.length; i++)
       {
           result[i] = list.get(i);
       }
        return result;
    }
    private int binarySearch(int[] nums2, int target, int low, int high)
    {
        while ( low <= high)
        {
            int mid = low + (high-low)/2;
            if (nums2[mid] == target)      
            {
                if (mid == low || nums2[mid] > nums2[mid-1])  // check if nums[mid] is the leftmost element that is equal to the target
                    return mid;
                else
                    high = mid - 1;       // keep moving left ( because we need to find the leftmost element)
            }
            else if (nums2[mid] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }
}
