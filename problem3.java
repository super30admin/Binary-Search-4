// Time Complexity : O(n)
// Space Complexity : O(n) -> storing the sorted array in another array
// Did this code successfully run on Leetcode : Yes, 3ms

// Your code here along with comments explaining your approach

// Sort the arrays and combine them in one array based on 2 pointer approach and determine median based on the length of the array

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        
        int[] jointArray = new int[m+n];
        
        int len =  jointArray.length;
        
        int k = 0;
        int i = 0, j = 0;
        while(i < m && j < n){
            jointArray[k++] = nums1[i] < nums2[j] ? nums1[i++]: nums2[j++];
        }
    
    while(i < m){
        jointArray[k++] = nums1[i++]; 
    }
    
    while(j < n){
        jointArray[k++] = nums2[j++];
    }
        
       // System.out.println(Arrays.toString(jointArray));
        
    if(len % 2 == 0){
        return (double)(jointArray[len/2] + jointArray[len/2 -1])/2;
    }
        else{
            return jointArray[len/2];
        }
    
}
}