//brute force- merge two arrays using 2 pointers then find middle ele. TC- O(m+n)
//second brute force- sort them and find midian- tc- m+nlog(m+n)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1>n2) return findMedianSortedArrays(nums2, nums1);//making sure that num1 is smaller than nums2

        int low = 0;
        int high = n1;//partition last index will be as size of array, we are partitionaing after each box in array

        while(low <= high){// doig binary search---TC- O(logn1)
        int partX = low + (high - low)/2;//getting mid value first in partx
        int partY = (n1+n2)/2 - partX;// formula to calculate partY, basically avg of 2 arrays then minus partx
        // from it will give us where to do partition in secont array

        //placing the L1, L2, R1, R2 pointers
        int L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
        int R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
        int L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
        int R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];

        if(L1 <= R2 && L2 <= R1){
            //correct partition
            if((n1 + n2) % 2 == 0){
                return (Math.max(L1, L2) + Math.min(R1, R2))/2.0;// return type is double
            }
            else{
                return Math.min(R1, R2);
            }
        }else if(L2 > R1){
            low = partX + 1;
        }else{
            high = partX - 1;
        }

        }

        return -1;
    }
}