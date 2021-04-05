class Solution {
    // Time Complexity : O(N1+N2)  N1: first array size; N2:second array size
// Space Complexity : O(N1+N2)  merged array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /* 
 2-pointers
 1. Merge two arrays using merge function two pointers.
 2. Then take the median of merged array.
 */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0; int p2=0; int i=0;
        int[] merge = new int[nums1.length + nums2.length];
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] <= nums2[p2]){
                merge[i++] = nums1[p1];
                p1++;
            }
            else{
                merge[i++] = nums2[p2];
                p2++;
            }
        }
        
        while(p1 < nums1.length){
            merge[i++] = nums1[p1];
            p1++;
        }
        while(p2 < nums2.length){
            merge[i++] = nums2[p2];
            p2++;
        }
        
        int n= (nums1.length + nums2.length);
        
        if(n%2 == 0){
            return (double)(merge[n/2]+ merge[(n/2)-1])/2;
        }
        else{
            return merge[n/2];
        }
        
    }
}





class Solution {
    // Time Complexity : O(logN1)  N1: smallest of both arrays
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /* 
 Binary-Search
 1. Do BS on smallest array and partition it.
 2. Now partition the second array such that part1 has more or equal elements than part2.
 3. left1<right2 && left2<right1.
 4. Do the BS untill the point 3 is met.
 */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length; int n2 = nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2, nums1);
        int low = 0; int high = nums1.length;
        while( low <= high){
            int mid = low + (high-low)/2;
            int partX = mid;
            int partY = (n1+n2+1)/2 - partX;
            double l1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX-1];
            double r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY-1];
            double r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            
            if(l1 <= r2 && l2 <= r1){
                if((n1+n2)%2 == 0)
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                else
                    return Math.max(l1,l2);

            }
            if(l1>r2)
                high = partX -1;
            else
                low = partX + 1;
        }
        return -1;
    }
}