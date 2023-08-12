package org.example;

// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysUsingTwoPointers {

    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        List<Integer> result = new ArrayList<>();

        if(m > n) return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;

        while(p1 < m && p2 < n)
        {
            if(nums1[p1] == nums2[p2])
            {
                result.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1] < nums2[p2])
            {
                p1++;
            }else{
                p2++;
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
