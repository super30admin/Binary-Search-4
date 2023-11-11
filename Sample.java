// # Binary-Search-4
// ## Problem1 
// Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

// Time Complexity : O(m log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n) return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> li = new ArrayList<>();
        int low = 0; int high = n-1;
        for(int i=0; i<m; i++){
            int target = nums1[i];
            int index = binarySearch(nums2, low, high, target);
            if(index != -1){
                low = index + 1;
                li.add(target);
            }
        }
        int[] result = new int[li.size()];
        for(int i=0; i<li.size(); i++){
            result[i] = li.get(i);
        }
        return result;
    }

    private int binarySearch(int[] arr, int low, int high, int target){
        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                if(mid == low || arr[mid - 1] < arr[mid]){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if(arr[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}



// ## Problem2
// Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0) return 0.0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1>n2) return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = n1;
        while(low <= high){
            int partX = low + (high - low)/2;
            int partY = (n1+n2)/2 - partX;
            int l1 = partX == 0? Integer.MIN_VALUE: nums1[partX - 1];
            int l2 = partY == 0? Integer.MIN_VALUE: nums2[partY - 1];
            int r1 = partX == n1? Integer.MAX_VALUE: nums1[partX];
            int r2 = partY == n2? Integer.MAX_VALUE: nums2[partY];
            if(l1 <= r2 && l2 <= r1){
                if((n1+n2) %2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }else{
                    return Math.min(r1,r2);
                }   
            }else if(l2 > r1){
                low = partX + 1;
            }else{
                high = partX - 1;
            }
        }
        return 66.6666666;
    }
}

