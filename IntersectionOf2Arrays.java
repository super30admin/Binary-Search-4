// Time Complexity : O(mlogn) where m is the smaller fo the two lists
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
// Sort both Arrays
// For each element in the 1st array, perform binary search in the 2nd Array
// In Binary Search, we want to find the first occurrance of each element, if not already accounted for using global low pointer



class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
         if(nums1 == null || nums2 == null) return null;

        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return intersect(nums2,nums1);
        Arrays.sort(nums1); //smaller array
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList();
        int low = 0;
        for(int i = 0; i < n1; i++) {
            int bCollide = binarySearch(nums2, nums1[i], low, n2-1);
            if(bCollide != -1) { //found the element in 2nd array
                low = bCollide+1;
                result.add(nums2[bCollide]);
            }
        }

        int[] ret = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            ret[i] = result.get(i);
        }
        return ret;
    }

    public int binarySearch(int[] arr, int target, int low, int high) {

        while(low <= high) {
            int mid = low + (high - low)/2 ;
            if(arr[mid] == target) { //return the left most
                if(mid == low || arr[mid] > arr[mid-1])
                    return mid;
                else
                    high = mid - 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

//Hashmap approach -
//Maitain a hashmap< element, count> for first Array
//Iterate over 2nd array and include all the elements in the result that are present in the map as well.
    public int[] intersectHashMap(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null) return null;

        int n1 = nums1.length;
        int n2 = nums2.length;
        //if(n1 > n2) intersect(nums,n1);

        List<Integer> result = new ArrayList();
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0; i < n1; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
        }

        for(int i = 0; i < n2; i++) {
            if(map.get(nums2[i]) != null) {
                if(map.get(nums2[i]) > 0) {
                    result.add(nums2[i]);
                    map.put(nums2[i], map.get(nums2[i])-1);
                }
                if(map.get(nums2[i]) == 0) {
                    map.remove(nums2[i],0);
                }
            }
        }
        int[] ret = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            ret[i] = result.get(i);
        }
        return ret;

    }
}
