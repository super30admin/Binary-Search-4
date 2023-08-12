package org.example;

// Time Complexity : O(mlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysUsingBinarySearch {

    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        List<Integer> result = new ArrayList<>();

        if(m > n) return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int low = 0; int high = n-1;
        for(int i=0; i<m; i++)
        {
            int midIndex = binarySearch(nums2, low, high, nums1[i]);
            if(midIndex != Integer.MIN_VALUE)
            {
                result.add(nums1[i]);
                low = midIndex + 1;
            }
        }

        int[] temp = new int[result.size()];
        for(int i=0; i<temp.length; i++)
        {
            temp[i] = result.get(i);
        }
        return temp;
    }

    public int binarySearch(int[] arr, int low, int high, int target)
    {

        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(arr[mid] == target)
            {
                if(low == mid || arr[mid] > arr[mid-1])
                {
                    return mid;
                }else{
                    high = mid -1;
                }
            }else if(arr[mid] > target)
            {
                high = mid -1;
            }else{
                low= mid + 1;
            }
        }

        return Integer.MIN_VALUE;
    }
}
