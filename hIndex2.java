//Time Complexity:O(logN) where N is the length of the citations array.
//Space Complexity:O(1)
//Approach- The number of papers having atleast k citations in the given list such that all the papers in the list have no more than or at least k citations can be found by adjusting the midpoint of the array. If the length of the array - mid element is equal to mid, then that means, there are atleast mid number of citations in the given list. Else if it is lesser than n-mid, then the left needs to be moved to the right half or if its is greater then right needs to be moved to the left half and then the mid needs to be calculated again to find the h-index.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public int hIndex(int[] citations) {
        int left=0, n=citations.length;
        int right=citations.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(citations[mid]==n-mid){
                return n-mid;
            }
            else if(citations[mid]<n-mid){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return n-left;
    }
}