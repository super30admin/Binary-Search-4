//approach -1
//take a new array, add this two array there with twopointers, and hen find the median of the new array. which is answer. 
//tc - O(m+n) - traverseing through both to make a new. 
//sc - O(m+n) - new array


//approach -2
//to reduce the TC above to logarithmic, we can use the binary search on partitions. 
//we will do binary search on small array , let say size m;
//tc - O(log m), sc- O(1)
/*logic - 
//take half part from one array  and second half part from second array. 
//decide the partition based on the first array, so if we take x elements from 1st array, it will be M-x elements from second aray. 
//where M= sum of the length of both array/2
// we also check if partitions are valid, for that we have condition check for this two sorted array's partition, 
//first array hold l1 and r1, while second holds l2 and r2. 
//l1<=r2 && l2 <=r1; if this satisfy means partition is valid
//now check if m+n is odd ? then answer is min of (r1,r2) else (P+Q)/2; P = Max of (l1,l2); Q = Min of (r1,r2);
//apply binary search on the Minimum array for partition !
//if while partitioning, any time if l1 or l2 becoms out of bound, then assign it -infinity
//and for r1 and r2 assign them +infinity. 
//for nums1 = [1,2,3,4,5,6,7] , nums2 =[5,6,7,8,9], let say partition is like in box pattern, when we define the partition on the vertical line
//if we make partition aafter 3, then l1 =3 and r1 =4, 
//because we took the 3 elemnt from the first array and m+n/2 = 6; we will take 6-3 =3 element from second array. 
//so l2 = 7 nd r2 = 8. 
//now we check the condition, if all satisfy then good to go for answer , if not then just update the high. 
//so , if l1 <= r2 is false, that mean l1 has higher alue and so we should move partition of nums1 left, which will ultimately move the nums2's partition to the right. 
//if l2<=r1 is false; then l2 is greater then r1, so we move right and partition will extend on right side more for nums, whih will ultimately result in less partition / less number of element from nums2.
//we use binary search here to get the correct partition. 

 */
class Solution{

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1 == null || nums1.length ==0) &&(nums2 == null || nums2.length ==0)) return 0.0;

        int m = nums1.length;
        int n = nums2.length;

        if(m > n)
        return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = m;

        while(low <= high)
        {
            int mid = low + (high -low)/2;
            int partX = mid;
            int partY = (m+n)/2  - partX;

            double l1 = partX == 0 ? Integer.MIN_VALUE: nums1[partX-1];
            double r1 = partX == m ? Integer.MAX_VALUE: nums1[partX];

            double l2 = partY == 0 ? Integer.MIN_VALUE: nums2[partY-1];
            double r2 = partY == m ? Integer.MAX_VALUE: nums2[partY];

            //if we get the correct partition
            if(l1 <= r2 && l2 <= r1)
            {
                if((m+n) % 2 == 0)
                return ((Math.max(l1,l2) + Math.min(r1,r2))/2);

                return math.min(r1,r2);
            }
            if(l1 > r2)
            {
                //move left
                high = mid -1;
            }else
            {
                //l2 > r1; so move right
                low = mid +1;
            }
        }
        return 1232343.00; // you can return whatever value and it's never going to print as array will always have answer.
}