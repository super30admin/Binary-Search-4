// Time Complexity : O(log(n) + k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //edge
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        //set the lengths
        int n1 = nums1.length;
        int n2 = nums2.length;
        //check to see if n1 is the samller array if not then switch it by calling recursion
        if(n1 > n2) return intersect(nums2, nums1);
        //sort the arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //create a result array to add to
        ArrayList<Integer> res = new ArrayList<>();
        //start a for loop iterating through the smaller array
        //and set a low pointer
        int l = 0;
        for(int i = 0; i < n1; i++){
            //call binary search to find the lowest similar number in the n2 array
            int sameIndex = binarySearch(nums2, nums1[i], l, n2-1);
            //if the index is not -1 then add it to the result
            if(sameIndex != -1){
                res.add(nums1[i]);
                //move the low pointer so that we dont access the same index agian in later binary search
                l = sameIndex + 1;
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }

    private int binarySearch (int [] nums, int tar, int low, int high){
        //while loop
        while(low <= high){
            //set the mid 
            int mid = low + (high - low)/2;
            //if the mid is equal to target
            if(nums[mid] == tar){
                //check the first index by either checking if the mid equals low or if the left most element we are looking at is greater 
                //then its previous indicating it is the last element of its kind
                if(mid == low || nums[mid] > nums[mid - 1]){
                    return mid;
                }
                //keep moving left to find it
                else{
                    high = mid - 1;
                }
            }
            //check if the element is on the left is so move the high
            else if(nums[mid] > tar){
                high = mid - 1;
            }
            //then it is on the right move low
            else{
                low = mid + 1;
            }
        }
        //if nothing is found return -1
        return -1;
    }
}