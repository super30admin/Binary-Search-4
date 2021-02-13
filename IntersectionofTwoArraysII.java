import java.util.*;

// Time Complexity :O(mlogm+nlogn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :getting started

// Your code here along with comments explaining your approach
public class IntersectionofTwoArraysII {

    class Solution1 {
        public int[] intersect(int[] nums1, int[] nums2) {
            //if nums1 is longer than nums2, swap nums1 and nums2
            if(nums1.length > nums2.length){
                return intersect(nums2, nums1);
            }

            //create hashmap to store values from nums1 and frequency
            HashMap<Integer,Integer> hashMap = new HashMap<>();

            //add nums1 to hashmap
            for(int num:nums1){
                hashMap.put(num, hashMap.getOrDefault(num,0)+1);
            }

            //create list to store intersected values
            List<Integer> list = new ArrayList<>();

            //iterate over nums2 and check if it exist in hashmap
            for(int num:nums2){
                int count = hashMap.getOrDefault(num, 0);
                if(count>0){
                    list.add(num);
                    hashMap.put(num, count-1);
                }
            }
            //convert list to array
            int[] result = new int[list.size()];
            int i =0;
            for(int num:list){
                result[i++] = num;
            }
            return result;
        }
    }

    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            //sort both arrays
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            //create pointers
            int i=0, j=0;

            List<Integer> list = new ArrayList<>();

            //Sort
            while(i < nums1.length && j <nums2.length){
                if(nums1[i] == nums2[j]){
                    list.add(nums1[i]);
                    i++;
                    j++;
                }else if(nums1[i]<nums2[j]){
                    i++;
                }else{
                    j++;
                }
            }
            //convert list to array
            int[] result = new int[list.size()];
            int k =0;
            for(int num:list){
                result[k++] = num;
            }
            return result;
        }
    }





}
