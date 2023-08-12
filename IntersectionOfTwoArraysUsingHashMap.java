package org.example;

// Time Complexity : O(m+n)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysUsingHashMap {

    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        List<Integer> result = new ArrayList<>();

        if(m > n) return intersect(nums2, nums1);

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<m; i++)
        {
            if(map.containsKey(nums1[i]))
            {
                map.put(nums1[i],map.get(nums1[i])+1);
            }else{
                map.put(nums1[i],1);
            }
        }
        for(int i=0; i<n; i++)
        {
            if(map.containsKey(nums2[i]))
            {
                result.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
                map.remove(nums2[i],0);
            }
        }

        int[] temp = new int[result.size()];
        for(int i=0; i<temp.length; i++)
        {
            temp[i] = result.get(i);
        }
        return temp;
    }
}
