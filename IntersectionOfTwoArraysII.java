package binarySearch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
	//Time Complexity : O(n log m), where n are elements in nums1 and m in nums2
  	//Space Complexity : O(1)
  	//Did this code successfully run on Leetcode : Yes
  	//Any problem you faced while coding this : No
	public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return intersect(nums2, nums1);
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int low = 0;
        for(int i: nums1) {
            int idx = binarySearch(nums2, low, nums2.length - 1, i);
            if(idx != -1) {
                res.add(nums2[idx]);
                low = idx + 1;
            }
        }
        
        int[] result = new int[res.size()];
        int idx = 0;
        for(int k: res)
            result[idx++] = k;
        
        return result;
    }
    
    private int binarySearch(int[] arr, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) {
                if(mid > low && arr[mid - 1] == target)
                    high = mid - 1;
                else
                    return mid;
            } else if(arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return -1;
    }
	
    //Time Complexity : O(n+m), where n are elements in nums1 and m in nums2
  	//Space Complexity : O(1)
  	//Did this code successfully run on Leetcode : Yes
  	//Any problem you faced while coding this : No
	public int[] intersect1(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return intersect(nums2, nums1);
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        
        int[] result = new int[res.size()];
        int idx = 0;
        for(int k: res)
            result[idx++] = k;
        
        return result;
    }
	
	//Time Complexity : O(n+m), where n are elements in nums1 and m in nums2
	//Space Complexity : O(n), for map
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int[] intersect2(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return intersect(nums2, nums1);
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums1)
            map.put(i, map.getOrDefault(i, 0) + 1);
        
        List<Integer> res = new ArrayList<>();
        for(int i: nums2) {
            if(map.containsKey(i)) {
                res.add(i);
                map.put(i, map.get(i) - 1);
                if(map.get(i) == 0)
                    map.remove(i);
            }
        }
        
        int[] result = new int[res.size()];
        int idx = 0;
        for(int i: res)
            result[idx++] = i;
        
        return result;
    }
}
