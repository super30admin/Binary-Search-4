// for two pointer based solution
// Time Complexity : O(mlogm) + O(nlogn) for sorting two arrays of siz m and n resp.
// Space Complexity : O(min(m, n)) for creating a list of atmost min(m,n) elements

// for hashmap based solution
// Time Complexity : O(m+n) for iterating over small array to create hashmap and then iterating over larger array to find match
// Space Complexity : O(min(m,n)) for creating hashmap of small array and also result list will be of max size min(m, n)

// Did this code successfully run on Leetcode : yes



package com.madhurima;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays {

    //Sorting both arrays, then use two pointers approach to find intersections
    public int[] intersectTwoPointers(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[]{};
        }

        int m = nums1.length;
        int n = nums2.length;
        if(m > n){
            return intersectTwoPointers(nums2, nums1);
        }

        Arrays.sort(nums1); //TC = O(mlogm)
        Arrays.sort(nums2); //TC = O(nlogn)

        List<Integer> result = new ArrayList<>();

        int n1 = 0;
        int n2 = 0;

        while(n1 < m && n2 < n){
            if(nums1[n1] < nums2[n2]){
                n1++;
            }else if(nums2[n2] < nums1[n1]){
                n2++;
            }else{ // both are equal
                result.add(nums1[n1]);
                n1++;
                n2++;
            }
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;

    }


    //HashMap based solution
    public int[] intersectHashMap(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return new int[]{};
        }

        int m = nums1.length;
        int n = nums2.length;

        if(m > n){
            return intersectHashMap(nums2, nums1); //want length of nums1 array lesser than length of nums2 array
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> result = new ArrayList<>();


        //creating hashmap for nums1 as it has min length to save space
        for(int num: nums1){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for(int num: nums2){
            if(hm.containsKey(num)){
                result.add(num);
                int count = hm.get(num);
                count--;
                if(count == 0){
                    hm.remove(num);
                }else{
                    hm.put(num, count);
                }
            }
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;

    }
}
