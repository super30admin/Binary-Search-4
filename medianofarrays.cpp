/*  Time : O(log(Min(M, N)))
    Space : O(1)
    Leetcode : Yes
    Explanation : Find the first partition such that all elements in X, Y to left of partition are less than
                all elements to the right of the partition. Find median based on odd or even.
*/
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) 
    {
        if(nums1.size() > nums2.size())
        {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int x = int(nums1.size());
        int y = int(nums2.size());
        
        int left = 0;
        int right = x;
        
        while(left <= right)
        {
            int partitionX = left + (right - left) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;
            
            // We have both partitions, get rightMax and leftMin
            int maxLeftX = (partitionX == 0) ? INT_MIN : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? INT_MAX : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? INT_MIN : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? INT_MAX : nums2[partitionY];
            
            // Compare them s.t all on left < right
            if(maxLeftX <= minRightY && maxLeftY <= minRightX)
            {
                // If the combined sum is even, get the average of max(left) and min(right)
                if((x+y) % 2 == 0)
                {
                    return ((double)(max(maxLeftX , maxLeftY) + min(minRightX, minRightY))) / 2; 
                }
                // else get max of left side
                else
                {
                    return (double)(max(maxLeftX, maxLeftY)); 
                }
            }
            else if(maxLeftX > minRightY)
            {
                right = partitionX - 1;
            }
            else
            {
                left = partitionX + 1;
            }
        }
        return 0.0;
    }         
                
};