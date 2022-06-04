// Time Complexity : O(log(m)) where m : length of smallest array.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* PartX :- Partition index of array 1.
 * PartY :- Partition index of array 2.
 * L1 :- Largest element on left partion of array 1.
 * L2 :- Largest element on left partion of array 2.
 * R1 :- Smallest element on Right partion of array 1.
 * R2 :- Smallest element on Right partion of array 2.
 *
 *      1. Calculate PartX by calculating median using low and high pointers.
 *      2. Calculate PartY by subtracting partX from total elements in array 1 and 2.
 *      3. If L1 <= R2 and L2 <= R1 then median is found return the median based on odd and even length.
 *         If l1 > R2 change high pointer to partX - 1 else change low pointer to partX + 1.  
 */
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int n1 = nums1.size();
        int n2 = nums2.size();
        
        if (n1 == 0 && n2 == 0)
            return 0;
        
        if (n2 < n1)
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0, high = n1;
        
        while (low <= high)
        {
            int partX = low + (high - low) / 2;
            int partY = (n1 + n2)/2 - partX;
            
            double l1 = partX == 0 ? INT_MIN : nums1[partX - 1];
            double r1 = partX == n1 ? INT_MAX : nums1[partX];
            
            double l2 = partY == 0 ? INT_MIN : nums2[partY - 1];
            double r2 = partY == n2 ? INT_MAX : nums2[partY];
            
            if (l1 <= r2 && l2 <= r1)
            {
                if ((n1 + n2) % 2 == 0)
                {
                    return (max(l1, l2) + min(r1, r2)) / 2;
                }
                else
                {
                    return min(r1, r2);
                }
            }
            else if (l1 > r2)
            {
                high = partX - 1;
            }
            else
            {
                low = partX + 1;
            }
        }
        
        return 0;
    }
};