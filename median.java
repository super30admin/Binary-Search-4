/* time complexity: O(m+n) for the two pointer approach and for the partition approach it is O(log(min(n1,n2)))  ~ O(log(n))
Space Complexity: two pointer approach: O(n1+n2) and for the partition approach it is O(1).
Explanation: For the two pointer approach, we use two pointers to iterate over the arrays simultaneously and add them into the result array as the lowest of both the elements at the pointers is found. Finally the median by using the index the median element is found.
For the partition approach, we use binary search over the partition indices of the minimum length array and based on the outside four elements near the partition the sorting condition is maintained and then the median is found. 
 */

class median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int n1 = nums1.length;
//         int n2 = nums2.length;
//         int p1 =0, p2 = 0, counter =0 ;
//         int[] result = new int[n1+n2];
//         int index = (n1+n2) /2;
//         while(p1<n1 && p2<n2){
//             if(nums1[p1]<nums2[p2]){
//                 result[counter] = nums1[p1];
//                 counter++;
//                 p1++;
//             }
//             else if(nums2[p2] < nums1[p1]){
//                 result[counter] = nums2[p2];
//                 counter++;
//                 p2++;
//             }
//             else{
//                 result[counter] = nums1[p1];
//                 counter++;
//                 result[counter] = nums2[p2];
//                 counter++;
//                 p1++;p2++;
//             }
            
//         }
//         while(p1<n1){
//             result[counter] = nums1[p1];
//             counter++;p1++;
//         }
//         while(p2<n2){
//             result[counter] = nums2[p2];
//             counter++;p2++;
//         }
              
//         if((n1+n2)%2 ==0){
            
//              return (result[index] + result[index-1] )/2.0;
//         }
//         else{
//             return result[index] / 1.0;
            
//         }
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);
        }
        
        int l =0, h= n1;  // since we are performing binary search over the partitions
        while(l<=h){
            int px = l+ (h-l)/2;
            int py = (n1+n2)/2 - px;
            
            int l1 = (px==0) ? Integer.MIN_VALUE : nums1[px-1];
            int r1 = (px==n1) ? Integer.MAX_VALUE : nums1[px];
            int l2 = (py==0) ? Integer.MIN_VALUE : nums2[py-1];
            int r2 = (py==n2) ? Integer.MAX_VALUE : nums2[py];
            
            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0;
                }else return Math.min(r1,r2);
            }else if(l2>r1){
                l = px+1;
            }
            else{
                h = px-1;
            }
            
        }

        return -34;
    }
}