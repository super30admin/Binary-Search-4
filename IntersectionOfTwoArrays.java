package BinarySearch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
    -------------------------------------------------------------------------------------------------------
    Time complexity : o(N) 
    space complexity: o(N)
    Did this code run successfully in leetcode : yes
    problems faces : no*/

public class IntersectionOfTwoArrays {

    // using auxilary data structure map 
   public int[] intersect(int[] nums1, int[] nums2) {

       List<Integer> result = new ArrayList<>();

       if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];


       HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
       int n1 = nums1.length;
       int n2 = nums2.length;

       //we want the nums1 to be smaller size, if not recalll the method interchanging nums1 and nums2
       if(n1 > n2) return intersect(nums2, nums1);


       for(int i : nums1)
       {
           map.put(i, map.getOrDefault(i, 0)+1);
       }

       for(int j : nums2)
       {
           if(map.containsKey(j))
           {
               result.add(j);
               map.put(j, map.get(j)-1);
               map.remove(j,0);
           }
       }

       int[] resultArray = new int[result.size()];

       for(int i=0;i<result.size();i++)
       {
           resultArray[i] = result.get(i);
       }

       return resultArray;

    }

   //if the given Arrays are sorted arrays, we will do two pointer solution
   public int[] intersectSortedArrays(int[] nums1, int[] nums2) {

       Arrays.sort(nums1);
       Arrays.sort(nums2);

       List<Integer> result = new ArrayList<>();

       if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];

       int n1 = nums1.length;
       int n2 = nums2.length;

       //we want the nums1 to be smaller size, if not recalll the method interchanging nums1 and nums2
       if(n1 > n2) return intersect(nums2, nums1);

       int p1 =0; int p2 =0;

       while(p1 <n1 && p2<n2)
       {
           if(nums1[p1] == nums2[p2])
           {
               result.add(nums1[p1]);
               p1++;
               p2++;
           }
           else if(nums1[p1] < nums2[p2])
           {
               p1++;
           }
           else
           {
               p2++;
           }
       }




       int[] resultArray = new int[result.size()];

       for(int i=0;i<result.size();i++)
       {
           resultArray[i] = result.get(i);
       }

       return resultArray;

    }

}