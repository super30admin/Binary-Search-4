// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*Approach:
1) we use most efficient approach with binary search 
2) we first start with finding the partitions in the array and calculate the median depending on odd and even elements
3) eg: we have 
-> num1: 1,7,8,10,11
-> num2: 2,3,4,5,6,12,13
4) In the above 2 arrays we find the partitions using l1,l2, r1 and r2 respectively.
in the above example we will partition using 
 int low =0;
 int high=n1; 

 int partX = low+(high-low)/2; // number of elemets we pick from nums1
 int partY = (n1+n2)/2- partX;

5) rest whole procedure according to the code

            else if(l1>r2)
            {
                high= partX-1;
            }
            else
            {
                low = partX+1;
            }
    if l1>r2 we need to search for smaller elememnt
    -> Thus we need to shift our high thus we can shift the partition to left to find the smaller element (array is sorted)
    -> else we just need to find the larger element and we increment our low
*/



class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length==0 && nums2.length==0)
        {
            return 0.0;
            
        }
        
        int n1 =nums1.length;
        int n2 = nums2.length;
        
        if(n1>n2)
        {
            return findMedianSortedArrays(nums2,nums1);
        }
        
        int low =0;
        int high=n1; // it should be n1 and not n1-1 as we are dealing with partitions and not elements
        
        while(low<=high)
        {
            int partX = low+(high-low)/2; // number of elemets we pick from nums1
            int partY = (n1+n2)/2- partX;
            
            double l1 = partX==0 ? Integer.MIN_VALUE : nums1[partX-1];
            // if partX ==0 we have no elements left on l1 or its side
            // if not we have partX-1 as we are choosing on partitions not elements 
            // lets say we have 0,1,2 as patitions thus partx=2 then we would have nums[1] thus we would partition till nums1[1] including 2 elements at index 0 and 1
            
            double l2 = partX==n1 ? Integer.MAX_VALUE : nums1[partX];
            // if we reach partX as length of first array then we reach till end and we assign + infinity else start the elements right at partition partX and onwards
            
            // same will go for partitions on second array with r1 and r2
            double r1 = partY==0 ? Integer.MIN_VALUE : nums2[partY-1];
            double r2 = partY==n2 ? Integer.MAX_VALUE : nums2[partY];
            
            
            // acceptance condition
            if(l1<=r2 && r1<=l2)
            {
                // if we have odd elements 
                if((n1+n2)%2 !=0 )
                {
                    // we will have median in right parts of array 
                    // i.e min of l2 and r2, the reason for this is we are having suppose 11 elements then 5 would be on left and 6 would be on right 
                    // thus median would be lying on right side
                    return Math.min(l2,r2);
                    
                }
                return (Math.max(l1,r1)+Math.min(l2,r2))/2;
                
            }
            else if(l1>r2)
            {
                high= partX-1;
            }
            else
            {
                low = partX+1;
            }
        }
        
        return 0.0;
    }
}


