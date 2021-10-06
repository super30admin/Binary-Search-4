//time complexity - o(log(min(n,m))) where n and m is the size of the input
//space complexity - 0(1)
//worked on leetcode - yes
//any doubts - no
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1= nums1.length; int n2= nums2.length;
        if(n1 > n2)return findMedianSortedArrays(nums2,nums1);
        //as we are taking high and low on partitions its length
        int low=0;int high = n1;
        while(low <= high){
            int partX = low + (high-low)/2;
            int partY = (n1+n2)/2 - partX;
            int L1 = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int R1 = partX == n1 ? Integer.MAX_VALUE : nums1[partX];
            int L2 = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int R2 = partY == n2 ? Integer.MAX_VALUE : nums2[partY];
            
            if(L1 <= R2 && L2 <= R1){
                if((n1+n2)%2==0){
                  return (double)(Math.max(L1,L2) + Math.min(R1,R2))/2;
                }
                else{
                    return (double) Math.min(R1,R2);
                }
            }
            else if(L1 > R2){
                high = partX -1;
            }
            else{
                low = partX +1;
            }
            
        }
        return 18.00;
    }
}