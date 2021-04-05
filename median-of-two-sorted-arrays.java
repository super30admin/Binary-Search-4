// Time Complexity :
O(log (m+n) ) where m and n are lengths of the two arrays
// Space Complexity :
o(1)
// Did this code successfully run on Leetcode :
yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

/*
Should check if:
l1 < r2
l2 < r1
*/

class Solution {
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        /*This is needed to cover [2,3,4,5] [1]  {even length of n1 and 0 -> 1 of 2 }
        [3,4,5,6,7,8] [0] -> does'nt work
        [3,4,5,6,7,8] [1] -> does'nt work
        [3,4,5,6,7,8] [2] -> does'nt work
        [3,4,5,6,7,8] [3] -> does'nt work
        [3,4,5,6,7,8][4]  -> does'nt work
        [3,4,5,6,7,8][5]  -> works
        [3,4,5][contains one element from 0->10] -> works
        */
       if (n2 < n1) 
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0;
        int high = n1;
        while(low <= high){
        int part1 =  low + (high - low)/2 ;
        int part2 = (n1 + n2)/2 - part1;
        
        int l1 = (part1 == 0) ? Integer.MIN_VALUE : nums1[part1-1]; 
        int l2 = (part2 == 0) ? Integer.MIN_VALUE : nums2[part2-1];
        int r1 = (part1 == n1) ? Integer.MAX_VALUE : nums1[part1];
        int r2 = (part2 == n2) ? Integer.MAX_VALUE : nums2[part2];
        
        if(l1 > r2){
            high = part1 - 1;
        }
        else if(l2 > r1){
          low = part1 + 1;  
        }else{
                
                if ((n1 + n2) % 2 != 0) 
                     return ((double) Math.min(r1, r2));
                else 
                    return ((double) Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            }
        
        }
     return  0; 
    }
}