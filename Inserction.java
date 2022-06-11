//-----------------HASHMAP SOLUTION------------------
// Time Complexity :O(m)+O(n) where m and  n are lengths of input arrays
// Space Complexity :O(n) (hashmap space) +O(result) as we are making arraylist
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

//we are making hashmap of numbers and count of numbers in lengthy array, then in smaller array we are 
//checking if the numbr is present if yes, then we'll decrement the count in hashmap and add in list
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return new int[0];
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                list.add(nums1[i]);
                map.put(nums1[i], map.get(nums1[i]) - 1);
            }
            map.remove(nums1[i], 0);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

// -----------TWO POINTER---------------
// Time Complexity :[O(mlogm)+O(nlogn)(if we consider sort)+O(m+n)]
// Space Complexity :constant if we dont consider array list
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return new int[0];
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ptr1 = 0;
        int ptr2 = 0;
        while (ptr1 < m && ptr2 < n) {
            if (nums1[ptr1] == nums2[ptr2]) {
                list.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            } else if (nums1[ptr1] < nums2[ptr2]) {
                ptr1++;
            } else {
                ptr2++;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

/// -----------------BINARY SEARCH--------------------------
// Time Complexity :O(nlogn+mlogm)(if we consider sorting)+O(logm)->binary
/// search on smaller array
// Space Complexity :size of arraylist ie. ==result
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return new int[0];
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int start = 0;
        int end = n - 1;
        for (int i = 0; i < m; i++) {
            int r = binarySearch(nums2, start, end, nums1[i]);
            if (r != -1) {
                list.add(nums1[i]);
                start = r + 1;
            }

        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private int binarySearch(int[] arr, int st, int en, int target) {
        int start = st;
        int end = en;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target && (mid == start || arr[mid - 1] < arr[mid])) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}