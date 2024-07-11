// Time Complexity : O(mlogm + nlogn) + O(mlogn) (For Binary Search) => O(mlogm + nlogn) where m is the length of nums1[] and n is the length of nums2[], as we sort both the arrays
// Space Complexity : O(min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Forgot to start the next binary search from the index+1 where the previous element was found

/*
Approach: Sort both the arrays. Perform binary search on the smaller array by iterating over the large array. Start looking for that element using binary search and ensure you find the first occurance of that element. Then start binary search from the next index.
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) {
            return new int[] {};
        }

        int m = nums1.length;
        int n = nums2.length;
        List<Integer> answer = new ArrayList<>();

        if(m < n){
            intersect(nums2, nums1); //To always ensure nums2 will have less number of elements
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int low = 0;
        int high = n -1;

        for(int i =0; i<nums1.length; i++){
            int target = nums1[i];
            int binarySearchIndex = binarySearch(nums2, target, low, high);
            if(binarySearchIndex != -1){
                answer.add(target);
                low = binarySearchIndex+1; //perform binar search on binarySearchIndex+1 to avoid looking for the same element twice
            }
        }

        int[] result = new int[answer.size()];

        for(int i =0; i< result.length; i++){
            result[i] = answer.get(i);
        }

        return result;
    }

    private int binarySearch(int[] nums2, int target, int low, int high){

        while(low <= high){

            int mid = low + (high - low)/2; // To prevent Integer overflow

            if(nums2[mid] == target){

                // To ensure we are looking at the first occurance of that element
                if( mid == low || nums2[mid - 1] != target){
                    return mid;
                }

                high = mid -1; //If not 1st occurance move high
            }
            else if(nums2[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid -1;
            }

        }

        return -1;
    }
}