// Time Complexity : O(log n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//brute force can be, traversing the array and checking if ele at curr index >= len-currindex
//Beacuse it is sorted array, can take advantage of binary search to find hIndex 
//find the mid of the array, check if the trialIndex at the mid is equal to ele at the mid, if so return trialIndex
//if it is greater, make low=mid+1
//else high=mid-1
//need to return the highest hindex possible, so return len-low at last


class Solution {
    public int hIndex(int[] citations) {
        int l=0;
        int h=citations.length-1;
        int len=citations.length;
        
        while(l<=h){
            int mid=l+(h-l)/2;
            
            int trialhIndex= len-mid;
            if(trialhIndex==citations[mid]){
                return trialhIndex;
            }
            else if(trialhIndex>citations[mid]){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return len-l;
    }
}