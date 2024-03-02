// https://leetcode.com/problems/intersection-of-two-arrays-ii/

// Time Complexity: O(n1 log n1 + n2 log n2)
// Space Complexity: O(min(n1, n2))

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> li = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int low = 0;
        int high = n2-1;
        for(int i = 0; i < n1; i++) {
            int bidx = binarySearch(nums2, low, high, nums1[i]);
            if(bidx != -1) {
                li.add(nums1[i]);
                low = bidx + 1;
            }
        }

        int[] arr = new int[li.size()];
        for(int i = 0; i < li.size(); i++) {
            arr[i] = li.get(i);
        }

        return arr;
    }

    private int binarySearch(int[] arr, int low, int high, int num) {
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(arr[mid] == num) {
                if(mid == low || arr[mid] > arr[mid-1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if(arr[mid] < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}