// Time Complexity : O(min(m,n)log(max(m,n))) where m, n are array lengths.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to sort the arrays first(as asked in followup question) and do binary search on larger array by
iteratively traversing nums1 array's elements and check if its present in nums2. If so, we add it to the result
and increment the index. We can also do using 2 pointers approach post sorting. If unsorted, we can hashmap
to store the smaller array's elements for better space complexity and traverse through bigger array and update
the count and add the common numbers to the result.
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2)
            return intersect(nums2, nums1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        int low = 0, high = n2 - 1;

        for(int num : nums1) {
            int idx = binarySearch(low, high, nums2, num);
            if(idx != -1) {
                result.add(num);
                low = idx + 1;
            }

        }
        int[] re = new int[result.size()];
        for(int i = 0 ; i < re.length ; i++) {
            re[i] = result.get(i);
        }
        return re;
    }

    private int binarySearch(int low, int high, int[] nums, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == low || nums[mid - 1] != nums[mid])
                    return mid;
                else
                    high = mid -1 ;
            }
            else if(nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}