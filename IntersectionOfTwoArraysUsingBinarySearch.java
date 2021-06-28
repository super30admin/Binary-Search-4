package BinarySearch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
    -------------------------------------------------------------------------------------------------------
    Time complexity : o(NlogN) 
    space complexity: o(N)
    Did this code run successfully in leetcode : yes
    problems faces : no*/

public class IntersectionOfTwoArraysUsingBinarySearch {
    
    // using binary search
   public int[] intersect(int[] nums1, int[] nums2) {
       
       List<Integer> result = new ArrayList<>();
       
       if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
       
       Arrays.sort(nums1);
       Arrays.sort(nums2);
       
       int n1 = nums1.length;
       int n2 = nums2.length;
       
       //we want the nums1 to be smaller size, if not recalll the method interchanging nums1 and nums2
       if(n1 > n2) return intersect(nums2, nums1);
 
       int j =0;
       for(int i=0;i<nums1.length;i++)
       {
           int eleIndex = binarySearch(nums2, j, nums1[i]);
           if(eleIndex != -1) 
           {
               result.add(nums1[i]);
               j = eleIndex+1;
           }
       }
       
       int[] resultArray = new int[result.size()];
       
       for(int i=0;i<result.size();i++)
       {
           resultArray[i] = result.get(i);
       }
       
       return resultArray;
       
    }
   
   private int binarySearch(int[] nums2,int index,int target)
   {
       int low = index;
       int high = nums2.length-1;
       
       while(low <= high)
       {
           int mid = low +(high - low)/2;
           
           if(nums2[mid] == target)
           {
               if(mid == low || nums2[mid] > nums2[mid-1])
               {
                   return mid;
               }else
               {
                  high = mid-1;
               }
           } else if(nums2[mid] > target)
           {
               high = mid -1;
           }else
           {
               low = mid+1;
           }
           
       }
       
       return -1;
   }
   
   

}
