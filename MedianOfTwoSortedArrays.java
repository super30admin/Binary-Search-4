package Nov29;

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        /*
        Time Complexity: O(m) where m is length of smaller array
        Space Complexity: O(1) 
        Approach: Binary Search approach used to partition the two arrays such that we get two parts from each of the arrays.
        */
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        // this ques is solved assuming that nums1 is smaller in length compared to nums2
        // so if that is not the case, call the function with params reversed
        if (n1 > n2)  {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        // NOTE: low and high pointers are being placed on partitions and not indices of the array, so we place high at n1 and not n1-1.
        int low = 0, high = n1;
        
        while (low <= high) {
           
            int partX = low + (high-low)/2;
            int partY = (n1 + n2)/2 - partX;
            
            double l1 = (partX == 0) ? Integer.MIN_VALUE : nums1[partX-1];
            double r1 = (partX == n1) ? Integer.MAX_VALUE : nums1[partX];
            double l2 = (partY == 0) ? Integer.MIN_VALUE : nums2[partY-1];
            double r2 = (partY == n2) ? Integer.MAX_VALUE : nums2[partY];
            
            // correct partition check:
            // if correct partition:  find median
            if (l1 <= r2 && l2 <= r1) {
                // even no.of elements: find median
                if ((n1+n2)%2 == 0) {
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }
                // odd no.of elements: find median
                else {
                    return Math.min(r1, r2);
                }
            } 
            // if NOT incorrect partition: check which pointer to move, low or high and move accordingly.
            // NOTE TO SELF: check class video for better understanding
            else if (l2 > r1) {
                low = partX + 1;
            } else {
                high = partX - 1;
            }
        }
        
        return 1.00;
        
    }
}