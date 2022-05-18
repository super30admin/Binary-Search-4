
// Time Complexity : O(log(min(m,n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class Solution {
    //TC O(log(min(m,n))
	//SC O(1)
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null)
            return 0.0;
        
        int m = nums1.Length;
        int n = nums2.Length;
        if(n < m)
            return FindMedianSortedArrays(nums2, nums1);
        
        int low = 0;
        //we cant use m-1 because we need partition, not element
        int high = m;
        
        while(low <= high)
        {
            int partX = low + (high - low)/2;
            
            int partY = (m+n)/2 - partX;
            
            //we calculate l1, l2, r1, r2
            //we also need to check if we reach end of partition, if yes, 
            //then set l to min value and r to max value
            double l1 = Int32.MinValue;
            if(partX != 0)
                l1 = nums1[partX-1];
            double l2 = Int32.MinValue;
            if(partY != 0)
                l2 = nums2[partY-1];            
            double r1 = Int32.MaxValue;
            if(partX < m)
                r1 = nums1[partX];    
            double r2 = Int32.MaxValue;
            if(partY < n)
                r2 = nums2[partY];
            
            //we need to make sure L1 <= R2 and L2 <= R1, it means, Left is smaller than right, now we can find middle elements from l and r	        
		    //If there are Odd lements, total, answer lies on right side, then min(R1, R2) will be median
		    //If there are even elements, median will be averge of two middle element
			//(max(L1,L2)+min(R1, R2))/2
            if(l1 <= r2 && l2 <= r1)
            {
                if((m+n)%2 == 0)
                    return (double)(Math.Max(l1, l2) + Math.Min(r1, r2))/2;
                else
                    return Math.Min(r1, r2);
            }
            else
            {
                //it means, we need to move toward larger elements
                //if l1 is greater than r2, then we set high to mid -1, go towards l1 or larger element
                //else go right, thats where larger element is
                if(l1 > r2)
                    high = partX-1;
                else
                    low = partX+1;
            }
        }
        
        return 0;
    }
}