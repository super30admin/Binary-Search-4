//TC: we are traversing on smaller arrays, ie in our case will be always n1, so TC : o(n1)
//SC: no extra space
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//partitioned 2 arrays, fir get partition on n1, according to that get on n2, if its proper, means if l1<r2 and l2 < r1 means its sorted if not kep on moving, and in end if its odd in length, get middle one so min of(r1,r2) , else get avg of mat.max(l1,l2) and math.min(r1,r2);
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //null check
        if(nums1.length == 0 && nums2.length == 0) return 0.0;
        //partition in nums1
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2,nums1);
        int low = 0; int high = n1;// as for n elements partiction is n+1; so for n-1 elements partition is n
        while(low <= high)
        {
            int  partX = low+(high-low)/2;
            int  partY = (n1+n2)/2 - partX;// partition formula

            double l1 = partX == 0  ? Integer.MIN_VALUE : nums1[partX -1];
            double r1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];// if partition at 0 then l1 is - inf and r1 is nums[p]

            double l2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY -1];
            double r2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

            if(l1 <= r2 && l2 <= r1)
            {
                if((n1+n2)%2 != 0){ // means odd
                    return Math.min(r1,r2);

                }
                else{
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }

            }
            else if(l2 > r1 ){
                low = partX +1;
            }
            else if(l1 > r2)
            {
                high = partX -1;
            }
        }
        return 2142.43223;
    }
}