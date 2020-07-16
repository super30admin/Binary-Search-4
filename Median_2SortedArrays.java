/**
 * Time O(log m) m- length of the smaller array amongst the gvn input arrays
 * Space : O(1)
 *
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // if((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) return 0;
        // else if((nums1 == null || nums1.length == 0)) return nums2[(nums2.length-1)/2];
        // else if((nums2 == null || nums2.length == 0)) return nums1[(nums1.length-1)/2];

        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        //System.out.println("pgm"+nums1.length+" "+nums2.length);
        int low = 0, high = nums1.length;
        int l1=0,l2=0,r1=0,r2=0;

        while(low<=high){
            int mid = low+(high-low)/2;
            int cnt = (nums2.length+nums1.length+1)/2 - mid;
            //System.out.println(low+""+high+""+cnt);
            l1 = mid == 0 ? Integer.MIN_VALUE : nums1[mid-1];           //2
            r1 = mid == nums1.length ? Integer.MAX_VALUE : nums1[mid];  // 999
            l2 = cnt == 0 ? Integer.MIN_VALUE : nums2[cnt-1];           // 1
            r2 = cnt == nums2.length ? Integer.MAX_VALUE : nums2[cnt];  // 3


            if(l1 <= r2 && l2<= r1){                                    //
                if((nums1.length+nums2.length)%2 == 0)
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                else
                    return (Math.max(l1,l2));
            }
            else if(l1 > r2)
                high = mid-1;
            else
                low = mid+1;

        }
        return -1;
    }
}