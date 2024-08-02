# Binary-Search-4



## Problem1 
--Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

class Solution {
   
    public int[] intersect(int[] nums1, int[] nums2) {
       int m = nums1.length;
       int n = nums2.length;
       if(m<n){
        return intersect(nums2,nums1);
       } 
       Arrays.sort(nums1);
       Arrays.sort(nums2);       
       List<Integer> result = new ArrayList<>();
       int index = 0;
       for(int i =0; i<nums2.length; i++){
        int loc = binarysearch(nums1,nums2[i],index);
        if(loc < nums1.length && nums1[loc] == nums2[i]){
          result.add(nums1[loc]);
          index = loc+1;
        }
       }
       int[] res = new int[result.size()];
       int i =0;
       for(Integer r : result){
           res[i] = r;
           i++;
       }
       return res;
    }
    private int binarysearch(int[] nums1, int target , int index){
        int low = index; int high = nums1.length-1;
        while(low <= high){
            int mid = low+(high-low)/2;                 
            if(nums1[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }  
}




## Problem2
--Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      if(nums1 == null && nums2 == null){
        return -1.0;
      }
      int m = nums1.length;
      int n = nums2.length;
      if(m>n){
        return findMedianSortedArrays(nums2,nums1);
      }
      int low = 0;
      int high = m;
      while(low <= high){
       int partx = low+(high-low)/2;
       int party = (m+n)/2 -partx;
       int l1 = (partx == 0) ? Integer.MIN_VALUE: nums1[partx-1];
       int r1 = (partx == m) ? Integer.MAX_VALUE: nums1[partx];
       int l2 = (party == 0) ? Integer.MIN_VALUE: nums2[party-1];
       int r2 = (party == n) ? Integer.MAX_VALUE: nums2[party];

       if(l1<=r2 && l2<=r1){
        if((m+n)%2 == 0){            
            return (double) (Math.max(l1,l2)+Math.min(r1,r2))/2;
        }
        return (double)  Math.min(r1,r2);
       }
       if(l1>r2){
        high = partx-1;
       }else if(l2>r1){
        low = partx+1;
       }
      }
      return -1.0;       
    }
}


