// Time Complexity : log(min(m,n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Partition of the arrays 
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //to ensure first array is smaller
        if(m > n) return findMedianSortedArrays(nums2, nums1);
        //declare and initialize the 4 numbers 
        double valueL1 = 0;
        double valueL2 = 0;
        double valueR1 = 0;
        double valueR2 = 0;
        
        //find partition in nums1 array
        for(int i = 0; i <= m; i++) {
            //each 0 to n can be a valid partition
            int part1 = i; 
            //check if partition2 possible for this partion1
            //if possible, find partition2
            if((m+n+1)/2 - part1 <= n && (m+n+1)/2 - part1 >= 0) {
                int part2 = (m+n+1)/2 - part1;
                
                //get the values of L1,L2,R1,R2
                //if partition1 is at 0th number (no numbers in partition1 from nums1), 
                //then L1 = minvalue,
                //else L1 = previous number of partition1 (position = partition-1)
                if(part1 == 0) valueL1 = Integer.MIN_VALUE;
                else valueL1 = nums1[part1-1];
                //if partition1 is at mth number (no numbers in partition2 from nums1), 
                //then R1 = maxvalue,
                //else R1 = next number of partition1 (position = partition)
                if (part1 == m) valueR1 = Integer.MAX_VALUE;
                else valueR1 = nums1[part1];
                //if partition2 is at 0th number (no numbers in partition1 from nums2), 
                //then L2 = minvalue,
                //else L2 = previous number of partition2 (position = partition-1)
                if(part2 == 0) valueL2 = Integer.MIN_VALUE;
                else valueL2 = nums2[part2-1];
                //if partitio2 is at nth number (no numbers in partition2 from nums2), 
                //then R2 = maxvalue,
                //else R2 = next number of partition2 (position = partition)
                if (part2 == n) valueR2 = Integer.MAX_VALUE;
                else valueR2 = nums2[part2];
                
                //check for correct partition condition
                //to be correct partition, 
                //Last element of partition1 from nums1 < first number of partition2 from nums2
                //Last element of partition1 from nums2 <= first number of partition2 from nums1
                if(valueL1 < valueR2 && valueL2 <= valueR1 ) {
                    //if even numbers : median = avg of max of partion1 and min of partition2
                    if((n+m)%2 == 0) {
                        return (Math.max(valueL1,valueL2) + Math.min(valueR1,valueR2))/2;
                    }
                    //if odd numbers : median = max of partition1
                    else return Math.max(valueL1, valueL2);
                }                
            }            
        } return -1;  //if no median return -1 (wont reach this condition)    
    }
}


/*
Eg : 
Even No (m+n) : 
part1 = part2 = 6
Median = Max of part1 + min of part2 / 2
[1,3,5,7,9,10]
[2,6,9,11,13,15]
1,3,5,7(L1)  | (R1)9,10
2,6(L2)      | (R2)9,11,13,15
Correct Partition :
L1<R2 && L2<=R1 (as L2 and R1 can be equal)
Ans : 7+9/2 = 8

Odd No (m+n) : 
part1 > part2 (Part1 has one more number than Part2)
Median = Max of part1 (max between L1 and L2)
[1,3,5,7,9,10]
[2,6,9,11,13]
1,3,5,7(L1)  | (R1)9,10
2,6(L2)      | (R2)9,11,13
Correct Partition :
L1<R2 && L2<=R1 (as L2 and R1 can be equal)
Ans : 7 


Find different partitions and check if its correct partition
and then return result based on even or odd case 

Partition to satisfy both odd and even case :
part2 = (m+n+1)/2 - part1
Part1 should be valid (for loop : 0 to m, included)
Part2 should be valid (0 to n, included)

Partitions are number based (0-n) and not position based (0 - n-1)
*/

