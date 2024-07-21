// Time Complexity : 1 - O(m+n), 2 - O(mlogm+nlogn), 3-O(mlogm)
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

// Hashmap approach
/*class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> hashmap = new HashMap<>();

        for(int i = 0; i<nums1.length; i++) {
            hashmap.put(nums1[i], hashmap.getOrDefault(nums1[i], 0) +1);
        }

        for(int num: nums2) {
            if(hashmap.containsKey(num)&& hashmap.get(num)>0) {
                result.add(num);
                hashmap.put(num, hashmap.get(num)-1);
            }
        }

        int[] intersection = new int[result.size()];
        for(int i = 0; i<result.size(); i++) {
            intersection[i] = result.get(i);
        }
        return intersection;
    }
}*/

// 2 pointers
/*class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        int first = 0;
        int second = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while(first<m && second<n) {
            if(nums1[first] == nums2[second]) {
                result.add(nums1[first]);
                first++;
                second++;
            } else if(nums1[first] < nums2[second]) {
                first++;
            } else {
                second++;
            }
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}*/

// Binary Search
class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;

    if(m < n) {
      intersect(nums2, nums1);
    }

    List<Integer> result = new ArrayList<>();
    int low = 0;
    int high = n-1;

    Arrays.sort(nums1);
    Arrays.sort(nums2);

    for(int i = 0; i<m; i++) {
      int target = nums1[i];
      int index = binarySearch(nums2, low, high, target);
      if(index != -1) {
        result.add(target);
        low = index+1;
      }
    }

    int[] answer = new int[result.size()];
    for(int i = 0; i<result.size(); i++) {
      answer[i] = result.get(i);
    }

    return answer;
  }

  int binarySearch(int[] nums, int low, int high, int target) {
    while(low <= high) {
      int mid = low + (high-low)/2;
      if(nums[mid] == target) {
        if(mid==low || nums[mid-1]!=target) return mid;
        else {
          high = mid-1;
        }
      }
      else if(nums[mid]>target) high = mid-1;
      else low = mid+1;
    }
    return -1;
  }
}
