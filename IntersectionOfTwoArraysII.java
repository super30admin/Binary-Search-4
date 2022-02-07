class Solution {
    // Time Complexity : O(m+n), where m is the length of nums1 and n is the length of nums2
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No

    //Approach 1 : Using HashMap
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) +1);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] result = new int[list.size()];
        for(int j = 0; j < list.size(); j++) {
            result[j] = list.get(j);
        }
        return result;
    }
}

// Time Complexity : O(max(m,n)), where m is the length of nums1 and n is the length of nums2, both are sorted
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach 2 : Using two pointer
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;
        List<Integer> list = new ArrayList<>();
        while(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] == nums2[p2]) {
                list.add(nums1[p1]);
                p1++;
                p2++;
            } else if(nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }


        int[] result = new int[list.size()];
        for(int j = 0; j < list.size(); j++) {
            result[j] = list.get(j);
        }
        return result;
    }
}

// Time Complexity : O(m logn), where m is the length of smaller array nums1 and n is the length of larger array nums2, both are sorted
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach 3 : Using binary search
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) return intersect(nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int low = 0; int high = n2-1;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n1; i++) {
            int target = nums1[i];
            int index = binarySearch(low, high, target, nums2);
            if(index != -1) {
                list.add(target);
                low = index+1;
            }
        }

        int[] result = new int[list.size()];
        for(int j = 0; j < list.size(); j++) {
            result[j] = list.get(j);
        }
        return result;
    }

    private int binarySearch(int low, int high, int target, int[] nums2) {
        while(low <= high) {
            int mid = low + (high-low)/2;

            if(nums2[mid] == target) {
                if(mid != low && nums2[mid] == nums2[mid-1]) {
                    high = mid-1;
                } else {
                    return mid;
                }
            } else if(nums2[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
}