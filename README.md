# Binary-Search-4



## Problem1 
Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

class Solution {
   // TC O(nlogm) SC O(m)
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
            }
        int n1 = nums1.length;
        int n2 = nums2.length;
        ArrayList<Integer> result = new ArrayList<>();
        if(n2 > n1){
           return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int low = 0;
        int high = nums2.length -1; 
        
        for(int i = 0; i<n1; i++){ 
         int bIndex = binarysearch(nums2, low, high, nums1[i]);
            if(bIndex != -1){
                result.add(nums1[i]);
                low = bIndex + 1;
            }
    }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i< result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
}
    private int binarysearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high - low)/2;
            if(target == nums[mid]){
                if(mid == low || nums[mid-1]<nums[mid]){
                    return mid;
                }
                else {
                    high = mid-1;
                }
                
            }else if(target>nums[mid]){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return -1;
        
        
    }
}


## Problem2
Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

class Solution {
    //TC O(log min(m,n)) SC O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return 0.0;
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        
        int low = 0;
        int high = n1;
        
        while(low<=high){
            int partX = low + (high - low)/2;
            int partY = (n1+n2)/2 - partX;
            
            double L1 = partX == 0 ? Integer.MIN_VALUE: nums1[partX-1];
            double L2 = partY == 0 ? Integer.MIN_VALUE: nums2[partY-1];
            double R1 = partX == n1 ? Integer.MAX_VALUE: nums1[partX];
            double R2 = partY == n2 ? Integer.MAX_VALUE: nums2[partY];
            if(L1<=R2 && L2<=R1){
                if((n1+n2)%2 != 0){
                    return Math.min(R1, R2);
                }
                return (Math.max(L1,L2) + Math.min(R1,R2)) / 2.0;
            }
            else if(L2>R1){
                low = partX + 1;
            } else{
                high = partX -1;
            }
            
        }
        return 1.1;
    }
}
